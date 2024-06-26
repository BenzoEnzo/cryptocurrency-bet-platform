package pl.benzo.enzo.bet.kafka.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.benzo.enzo.bet.kafka.server.data.MatchResult;
import pl.benzo.enzo.bet.kafka.server.data.repository.MatchResultRepository;
import pl.benzo.enzo.bet.platformlibrary.model.enumerated.Status;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchResultService {
    private final MatchResultRepository matchResultRepository;

    public List<MatchResult> findAllByEventStatusIsFinished(){
        return matchResultRepository.findMatchResultsByEvent_Status(Status.FINISHED);
    }

    public MatchResult findByEventId(String eventId){
        return matchResultRepository.findMatchResultByEvent_EventId(eventId);
    }
    public void saveMatchResult(MatchResult matchResult) {
        matchResultRepository.save(matchResult);
    }
}
