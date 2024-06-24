package pl.benzo.enzo.bet.betdomainapplication.logic;


import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import pl.benzo.enzo.bet.betdomainapplication.logic.service.extended.CreateEventService;
import pl.benzo.enzo.bet.betdomainapplication.logic.service.extended.FindEventService;
import pl.benzo.enzo.bet.betdomainapplication.model.Event;
import pl.benzo.enzo.bet.betdomainapplication.model.dto.EventDTO;
import pl.benzo.enzo.bet.betdomainapplication.model.dto.request.CreateEventRequest;
import pl.benzo.enzo.bet.betdomainapplication.model.dto.response.CreateEventResponse;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class EventFacade {
    private final CreateEventService createEventService;
    private final FindEventService findEventService;

    private final Logger logger = LoggerFactory.getLogger(EventFacade.class);

    public Try<CreateEventResponse> createEvent(CreateEventRequest request){
        return Try.of(() -> {
           CreateEventResponse response = createEventService.createNewEvent(request);
           return response;
        }).onSuccess(event -> logger.info("Created event: {}", event.title()))
                .onFailure(e -> logger.info("Failed to create event: {}", e.getMessage()));

    }

    public Try<List<EventDTO>> findUpcomingEvents(){
        return Try.of(() -> {
            List<EventDTO> response = findEventService.getUpcomingEvents();
            return response;
        }).onSuccess(events -> logger.info("Number of upcoming events: {}", events.size()))
                .onFailure(e -> logger.info("Failed to fetch upcoming events: {}", e.getMessage()));
    }
}
