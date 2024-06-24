package pl.benzo.enzo.bet.betdomainapplication.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.benzo.enzo.bet.betdomainapplication.model.Event;
import pl.benzo.enzo.bet.betdomainapplication.model.enumerated.Status;

import java.util.List;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {
    List<Event> findAllByStatus(Status status);
}
