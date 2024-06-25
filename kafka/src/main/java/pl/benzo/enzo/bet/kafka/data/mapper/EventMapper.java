package pl.benzo.enzo.bet.kafka.data.mapper;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.benzo.enzo.bet.kafka.data.Actor;
import pl.benzo.enzo.bet.kafka.data.Event;
import pl.benzo.enzo.bet.kafka.data.Market;
import pl.benzo.enzo.bet.kafka.logic.helper.StringExtractor;
import pl.benzo.enzo.bet.platformlibrary.model.MmaEventDTO;
import pl.benzo.enzo.bet.platformlibrary.model.enumerated.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class EventMapper {
    public Event mapToEventFromMma(MmaEventDTO dto){
        Event event = new Event();
        Actor fighterFirst = new Actor();
        Actor fighterSecond = new Actor();
        Market versusFirst = new Market();
        Market versusSecond = new Market();

        String[] fighters = StringExtractor.extractFighters(dto.getName());

        if(fighters!=null) {
            fighterFirst.setName(fighters[0]);
            fighterFirst.setActorId(fighters[0] + dto.getLeagueId() + dto.getEventId());

            fighterSecond.setName(fighters[1]);
            fighterSecond.setActorId(fighters[1] + dto.getLeagueId() + dto.getEventId());

            versusFirst.setActor(fighterFirst);
            versusFirst.setOdds(BigDecimal.ONE);

            versusSecond.setActor(fighterSecond);
            versusSecond.setOdds(BigDecimal.ONE);

            event.setFirstSubject(versusFirst);
            event.setSecondSubject(versusSecond);
        }

        event.setEventId(String.valueOf(dto.getEventId()));
        event.setTitle(dto.getName() + dto.getLeagueId());
        event.setStartTime(dto.getDateTime());
        event.setEndTime(dto.getDateTime().plusMinutes(30));

        if(dto.getDateTime().isBefore(LocalDateTime.now())) {
            event.setStatus(Status.FINISHED);
            event.setDeprecate(true);
        } else {
            event.setStatus(Status.ONGOING);
        }

        return event;
    }
}
