package pl.benzo.enzo.bet.betdomainapplication.logic.service.extended;

import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.benzo.enzo.bet.betdomainapplication.logic.service.EventService;
import pl.benzo.enzo.bet.betdomainapplication.model.mapper.EventMapper;
import pl.benzo.enzo.bet.betdomainapplication.model.Event;
import pl.benzo.enzo.bet.betdomainapplication.model.dto.EventDTO;
import pl.benzo.enzo.bet.betdomainapplication.model.dto.request.CreateEventRequest;
import pl.benzo.enzo.bet.betdomainapplication.model.dto.response.CreateEventResponse;
import pl.benzo.enzo.bet.betdomainapplication.model.enumerated.Status;
import pl.benzo.enzo.bet.betdomainapplication.model.exception.EventCreationException;
import pl.benzo.enzo.bet.betdomainapplication.model.repository.EventRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class CreateEventService {
    private final EventService eventService;
    private final EventMapper eventMapper;


    public CreateEventResponse createNewEvent(CreateEventRequest request){
        Event event = new Event();
        eventMapper.mapToEntity(event, request);
        event.setStatus(Status.UPCOMING);
        eventService.saveEvent(event);
        return eventMapper.mapToResponse(event);

    }


}
