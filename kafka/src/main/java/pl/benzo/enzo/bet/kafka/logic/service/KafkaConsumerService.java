package pl.benzo.enzo.bet.kafka.logic.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import pl.benzo.enzo.bet.kafka.server.data.Event;
import pl.benzo.enzo.bet.kafka.server.service.EventService;
import pl.benzo.enzo.bet.platformlibrary.model.bet.BetDTO;
import pl.benzo.enzo.bet.platformlibrary.model.bet.PartialBetDTO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;


@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumerService {
    private final EventService eventService;
    private final Logger logg = LoggerFactory.getLogger(KafkaConsumerService.class);
    private final KafkaTemplate<String, BetDTO> kafkaTemplate;
    private final ConcurrentHashMap<String, List<BetDTO>> userBets = new ConcurrentHashMap<>();
    @Getter
    private final Set<BetDTO> allBets = new HashSet<>();

    @KafkaListener(topics = "created-user-bets", groupId = "my-bets", containerFactory = "kafkaListenerContainerFactory")
    public void consumeBet(BetDTO betDTO) {
        final String betOwnerMail = betDTO.getUser().getMail();
        final String betOwnerId = betDTO.getUser().getUserId();
        logg.info("Received Bet owner: {} ", betOwnerMail);


        List<PartialBetDTO> partialBets = betDTO.getPartialBets();

        List<Event> events = eventService.findAllEvents();

        Set<String> eventIds = events.stream()
                .map(Event::getEventId)
                .collect(Collectors.toSet());

        boolean allEventsExist = partialBets.stream()
                .allMatch(bet -> eventIds.contains(bet.getEvent().getEventId()));


        if (allEventsExist) {
            logg.info("All events exist for Bet: {}", betOwnerMail);

            allBets.add(betDTO);

            kafkaTemplate.send(betOwnerId,betDTO);

            userBets.computeIfAbsent(betOwnerId, k -> new ArrayList<>()).add(betDTO);
        } else {
            logg.warn("Some events do not exist for Bet: {}", betOwnerMail);
        }

    }

    @KafkaListener(topicPattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", groupId = "my-bets", containerFactory = "kafkaListenerContainerFactory")
    public void listenUserSpecificBets(BetDTO betDTO) {
        final String betOwnerId = betDTO.getUser().getUserId();
        logg.info("Received Bet from user-specific topic for owner: {} ", betOwnerId);
        userBets.computeIfAbsent(betOwnerId, k -> new ArrayList<>()).add(betDTO);
    }

    public List<BetDTO> getBetsForUser(String userId) {
        return userBets.getOrDefault(userId, new ArrayList<>());
    }

}
