package pl.benzo.enzo.bet.kafka.data.mapper;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.benzo.enzo.bet.kafka.data.Event;
import pl.benzo.enzo.bet.platformlibrary.model.MmaEventDTO;
import pl.benzo.enzo.bet.platformlibrary.model.enumerated.Status;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class EventMapper {
    public Event mapToEventFromMma(MmaEventDTO dto){
        Event event = new Event();
        event.setEventId(String.valueOf(dto.getEventId()));
        event.setTitle(dto.getName() + dto.getLeagueId());
        event.setStartTime(dto.getDateTime());

        if(dto.getDateTime().isBefore(LocalDateTime.now())) {
            event.setStatus(Status.FINISHED);
            event.setDeprecate(true);
        } else {
            event.setStatus(Status.ONGOING);
        }

        return event;
    }
}
