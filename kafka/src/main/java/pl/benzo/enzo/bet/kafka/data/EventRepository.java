package pl.benzo.enzo.bet.kafka.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.benzo.enzo.bet.platformlibrary.model.enumerated.Status;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends MongoRepository<Event,String> {
    List<Event> findAllByStatus(Status status);
    Optional<Event> findEventByEventId(String eventId);
    List<Event> findEventsByDeprecateIsFalse();

}
