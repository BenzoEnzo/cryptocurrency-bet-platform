package pl.benzo.enzo.bet.betdomainapplication.data.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.benzo.enzo.bet.betdomainapplication.data.PartialBet;
import pl.benzo.enzo.bet.platformlibrary.model.EventDTO;
import pl.benzo.enzo.bet.platformlibrary.model.PartialBetDTO;

@Component
@RequiredArgsConstructor
public class PartialBetMapper {
    public void mapToEntity(PartialBet partialBet, PartialBetDTO betDTO){
        partialBet.setBetStatus(betDTO.getBetStatus());
        partialBet.setCategory(betDTO.getEvent().getCategory());
        partialBet.setActorId(betDTO.getWinnerId());
        partialBet.setOdds(betDTO.getOds());
        partialBet.setEndTime(betDTO.getFinishedAt());
        partialBet.setStatus(betDTO.getEvent().getStatus());
        partialBet.setStartTime(betDTO.getEvent().getStartTime());
    }
    public PartialBetDTO mapToDTO(PartialBet partialBet){
        EventDTO eventDTO = EventDTO.builder()
                .eventId(partialBet.getEventId())
                .title(partialBet.getTitle())
                .endTime(partialBet.getEndTime())
                .startTime(partialBet.getStartTime())
                .category(partialBet.getCategory())
                .build();

        return PartialBetDTO.builder()
                .ods(partialBet.getOdds())
                .partialBetId(partialBet.getPartialBetId())
                .betStatus(partialBet.getBetStatus())
                .event(eventDTO)
                .winnerId(partialBet.getActorId())
                .build();
    }
}
