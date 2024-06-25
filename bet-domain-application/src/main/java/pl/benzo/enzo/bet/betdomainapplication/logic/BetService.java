package pl.benzo.enzo.bet.betdomainapplication.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.benzo.enzo.bet.betdomainapplication.data.Bet;
import pl.benzo.enzo.bet.betdomainapplication.data.BetRepository;

@Service
@RequiredArgsConstructor
public class BetService {
    private final BetRepository betRepository;

    public void saveBet(Bet bet){
        betRepository.save(bet);
    }
}
