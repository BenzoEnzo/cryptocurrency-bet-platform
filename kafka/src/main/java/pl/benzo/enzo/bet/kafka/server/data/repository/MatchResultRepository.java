package pl.benzo.enzo.bet.kafka.server.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.benzo.enzo.bet.kafka.server.data.MatchResult;
import pl.benzo.enzo.bet.platformlibrary.model.enumerated.Status;

import java.util.List;

@Repository
public interface MatchResultRepository extends MongoRepository<MatchResult,String> {
    List<MatchResult> findMatchResultsByEvent_Status(Status status);
    MatchResult findMatchResultByEvent_EventId(String eventId);
}
