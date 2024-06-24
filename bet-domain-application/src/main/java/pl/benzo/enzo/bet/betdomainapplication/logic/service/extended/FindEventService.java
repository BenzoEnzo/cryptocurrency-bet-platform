package pl.benzo.enzo.bet.betdomainapplication.logic.service.extended;

import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.benzo.enzo.bet.betdomainapplication.logic.service.EventService;
import pl.benzo.enzo.bet.betdomainapplication.model.dto.EventDTO;
import pl.benzo.enzo.bet.betdomainapplication.model.enumerated.Status;
import pl.benzo.enzo.bet.betdomainapplication.model.mapper.EventMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindEventService {
    private final EventService eventService;
    private final EventMapper eventMapper;

    public List<EventDTO> getUpcomingEvents(){
       return eventService.findAllEventsByStatus(Status.UPCOMING)
                            .stream()
                            .map(eventMapper::mapToDto)
                            .toList();
    }

    public List<EventDTO> getAllEvents(){
        return eventService.findAllEvents()
                .stream()
                .map(eventMapper::mapToDto)
                .toList();
    }
}
