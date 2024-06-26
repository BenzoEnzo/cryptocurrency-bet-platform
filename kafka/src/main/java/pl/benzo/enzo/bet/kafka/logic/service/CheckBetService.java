package pl.benzo.enzo.bet.kafka.logic.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import pl.benzo.enzo.bet.kafka.server.data.MatchResult;
import pl.benzo.enzo.bet.kafka.server.service.MatchResultService;
import pl.benzo.enzo.bet.platformlibrary.model.bet.BetDTO;
import pl.benzo.enzo.bet.platformlibrary.model.enumerated.BetStatus;
import pl.benzo.enzo.bet.platformlibrary.model.enumerated.Status;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CheckBetService {
    private final MatchResultService matchResultService;
    private final KafkaTemplate<String,BetDTO> kafkaTemplate;
    private final KafkaConsumerService kafkaConsumerService;
    private final Logger logg = LoggerFactory.getLogger(CheckBetService.class);

    @KafkaListener(topics = "finished-events", groupId = "my-bets", containerFactory = "kafkaListenerContainerFactory")
    public void findEventScoreAndBet(String eventId){
        logg.info("Event with id: {}", eventId + " has ended");
        MatchResult matchResult = matchResultService.findByEventId(eventId);

        if (matchResult == null) {
            logg.warn("No match result exists for event id: {}", eventId);
            return;
        }

        String winner = matchResult.getMatch().getWinner().getActorId();
        Set<BetDTO> bets = kafkaConsumerService.getAllBets();

        Set<BetDTO> betsForEvent = bets.stream()
                .filter(bet -> bet.getPartialBets().stream()
                        .anyMatch(partialBet -> partialBet.getEvent().getEventId().equals(eventId)))
                .collect(Collectors.toSet());

        betsForEvent.forEach(bet -> {
            bet.getPartialBets().stream()
                    .filter(partialBet -> partialBet.getEvent().getEventId().equals(eventId))
                    .forEach(partialBet -> {
                        if (partialBet.getWinnerId().equals(winner)) {
                            partialBet.setBetStatus(BetStatus.WON);
                            partialBet.getEvent().setStatus(Status.FINISHED);
                            bet.addWinRatio();
                            logg.info("Bet {} won! Bet owner: {}", bet.getBetId(), bet.getUser().getMail());
                        } else {
                            partialBet.setBetStatus(BetStatus.LOST);
                            partialBet.getEvent().setStatus(Status.FINISHED);
                            bet.setFinalBetStatus(BetStatus.LOST);
                            bet.setFinalStatus(Status.FINISHED);
                            logg.info("Bet {} lost. Bet owner: {}", bet.getBetId(), bet.getUser().getMail());
                        }
                    });

            kafkaTemplate.send(bet.getUser().getUserId(), bet.getBetId(), bet);
        });
    }
}
