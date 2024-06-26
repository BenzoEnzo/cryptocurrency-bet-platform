package pl.benzo.enzo.bet.betdomainapplication.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.benzo.enzo.bet.betdomainapplication.data.CompletedBet;
import pl.benzo.enzo.bet.betdomainapplication.data.repository.CompletedBetRepository;

@Service
@RequiredArgsConstructor
public class CompletedBetService {
    CompletedBetRepository completedBetRepository;

    public CompletedBet save(CompletedBet completedBet){
        return completedBetRepository.save(completedBet);
    }
}
