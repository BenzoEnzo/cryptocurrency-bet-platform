package pl.benzo.enzo.bet.betdomainapplication.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.benzo.enzo.bet.betdomainapplication.data.Bet;

@Repository
public interface BetRepository extends MongoRepository<Bet,String> {
}
