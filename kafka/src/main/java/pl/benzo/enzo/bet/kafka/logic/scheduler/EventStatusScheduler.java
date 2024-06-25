package pl.benzo.enzo.bet.kafka.logic.scheduler;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pl.benzo.enzo.bet.kafka.data.Event;
import pl.benzo.enzo.bet.kafka.logic.service.EventService;
import pl.benzo.enzo.bet.platformlibrary.model.enumerated.Status;


import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventStatusScheduler {
    private final EventService eventService;
    private final ExecutorService executorService;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final Logger logger = LoggerFactory.getLogger(EventStatusScheduler.class);

    @Scheduled(fixedRate = 60000)
    public void updateEventStatuses() {
        List<Event> events = new CopyOnWriteArrayList<>(eventService.findAllEvents());
        LocalDateTime now = LocalDateTime.now();

        executorService.submit(() -> updateStartedEvents(events, now));
        executorService.submit(() -> updateFinishedEvents(events, now));
    }

    private void updateStartedEvents(List<Event> events, LocalDateTime now) {
        logger.info("Checking for started events at {}", now);

        List<Event> startedEvents = events.stream()
                .filter(event -> event.getStartTime() != null && event.getEndTime() != null)
                .filter(event -> event.getStartTime().isBefore(now) && event.getEndTime().isAfter(now) && event.getStatus() != Status.ONGOING)
                .toList();

        if (startedEvents.isEmpty()) {
            logger.info("No events to update to ONGOING status.");
        } else {
            for (Event event : startedEvents) {
                event.setStatus(Status.ONGOING);
                eventService.saveEvent(event);
                logger.info("Updated event {} to ONGOING status", event.getEventId());
            }
        }
    }

    private void updateFinishedEvents(List<Event> events, LocalDateTime now) {
        logger.info("Checking for finished events at {}", now);

        List<Event> finishedEvents = events.stream()
                .filter(event -> event.getEndTime() != null)
                .filter(event -> event.getEndTime().isBefore(now) && event.getStatus() != Status.FINISHED)
                .toList();

        if (finishedEvents.isEmpty()) {
            logger.info("No events to update to FINISHED status.");
        } else {
            for (Event event : finishedEvents) {
                event.setStatus(Status.FINISHED);
                event.setDeprecate(true);
                eventService.saveEvent(event);

                kafkaTemplate.send("finished-events",event.getEventId());

                logger.info("Updated event {} to FINISHED status", event.getEventId());
            }
        }
    }
}