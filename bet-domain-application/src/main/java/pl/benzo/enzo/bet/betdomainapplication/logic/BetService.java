package pl.benzo.enzo.bet.betdomainapplication.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.benzo.enzo.bet.betdomainapplication.model.Bet;
import pl.benzo.enzo.bet.betdomainapplication.model.BetRepository;

@Service
@RequiredArgsConstructor
public class BetService {
    private final BetRepository betRepository;

    public void saveBet(Bet bet){
        betRepository.save(bet);
    }
}
