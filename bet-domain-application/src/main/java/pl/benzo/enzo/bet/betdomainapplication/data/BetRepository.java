package pl.benzo.enzo.bet.betdomainapplication.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BetRepository extends MongoRepository<Bet,String> {
}
