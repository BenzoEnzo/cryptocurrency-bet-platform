package pl.benzo.enzo.bet.betdomainapplication.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.benzo.enzo.bet.betdomainapplication.data.Bet;
import pl.benzo.enzo.bet.betdomainapplication.data.mapper.BetMapper;
import pl.benzo.enzo.bet.platformlibrary.model.BetDTO;

@Service
@RequiredArgsConstructor
public class CreationBetService {
    private final BetService betService;
    private final BetMapper betMapper;
    public BetDTO saveNewBet(BetDTO request){
        Bet bet = new Bet();
        betMapper.mapToEntity(bet,request);
        bet.setApprove(false);
        betService.saveBet(bet);

        return betMapper.mapToDto(bet);
    }
}
