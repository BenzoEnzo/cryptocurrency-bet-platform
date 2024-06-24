package pl.benzo.enzo.bet.betdomainapplication.model.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.benzo.enzo.bet.betdomainapplication.model.Event;
import pl.benzo.enzo.bet.betdomainapplication.model.dto.EventDTO;
import pl.benzo.enzo.bet.betdomainapplication.model.dto.request.CreateEventRequest;
import pl.benzo.enzo.bet.betdomainapplication.model.dto.response.CreateEventResponse;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class EventMapper {
    public void mapToEntity(Event event, CreateEventRequest request){
        event.setTitle(request.title());
        event.setStartTime(request.startTime());
        event.setEndTime(request.endTime());
        event.setCategory(request.category());
    }

    public CreateEventResponse mapToResponse(Event event){
       return new CreateEventResponse(LocalDateTime.now(), event.getTitle());
    }

    public EventDTO mapToDto(Event event){
        EventDTO eventDto = new EventDTO();

        eventDto.setEventId(event.getEventId());
        eventDto.setTitle(event.getTitle());
        eventDto.setStartTime(event.getStartTime());
        eventDto.setEndTime(event.getEndTime());
        eventDto.setCategory(event.getCategory());
        eventDto.setStatus(event.getStatus());

        return eventDto;
    }
}
