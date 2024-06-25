package pl.benzo.enzo.bet.kafka.logic.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.benzo.enzo.bet.kafka.data.Event;
import pl.benzo.enzo.bet.kafka.data.EventRepository;
import pl.benzo.enzo.bet.platformlibrary.model.enumerated.Status;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;

    public void saveEvent(Event event){
        eventRepository.save(event);
    }

    public List<Event> findAllEvents(){
        return eventRepository.findEventsByDeprecateIsFalse();
    }

    public void deleteAll(){
        eventRepository.deleteAll();
    }
    public List<Event> findAllEventsByStatus(Status status){
        return eventRepository.findAllByStatus(status);
    }

    public Optional<Event> findEventById(String id){
        return eventRepository.findEventByEventId(id);
    }

    public void deprecateEvent(Event event){
        event.setDeprecate(true);
        eventRepository.save(event);
    }

    public Event findRandomEvent() {
        Random random = new Random();
        List<Event> events = eventRepository.findAll();
        if (events.isEmpty()) {
            return null;
        }
        return events.get(random.nextInt(events.size()));
    }
}
