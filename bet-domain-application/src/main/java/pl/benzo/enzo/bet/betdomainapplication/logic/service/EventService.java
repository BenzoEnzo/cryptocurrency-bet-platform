package pl.benzo.enzo.bet.betdomainapplication.logic.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.benzo.enzo.bet.betdomainapplication.model.Event;
import pl.benzo.enzo.bet.betdomainapplication.model.enumerated.Status;
import pl.benzo.enzo.bet.betdomainapplication.model.repository.EventRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;

    public void saveEvent(Event event){
        eventRepository.save(event);
    }

    public List<Event> findAllEvents(){
        return eventRepository.findAll();
    }

    public List<Event> findAllEventsByStatus(Status status){
        return eventRepository.findAllByStatus(status);
    }

    public Optional<Event> findEventById(String id){
        return eventRepository.findById(id);
    }

    public void deprecateEvent(Event event){
        event.setDeprecate(true);
        eventRepository.save(event);
    }
}
