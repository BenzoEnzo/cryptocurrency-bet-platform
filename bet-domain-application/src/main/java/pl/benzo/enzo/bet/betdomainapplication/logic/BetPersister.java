package pl.benzo.enzo.bet.betdomainapplication.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.benzo.enzo.bet.betdomainapplication.data.Bet;
import pl.benzo.enzo.bet.betdomainapplication.data.CompletedBet;
import pl.benzo.enzo.bet.betdomainapplication.data.mapper.BetMapper;
import pl.benzo.enzo.bet.betdomainapplication.data.mapper.CompletedBetMapper;
import pl.benzo.enzo.bet.platformlibrary.model.BetDTO;
import pl.benzo.enzo.bet.platformlibrary.model.CompletedBetDTO;

@Service
@RequiredArgsConstructor
public class BetPersister {
    private final BetService betService;
    private final BetMapper betMapper;
    private final CompletedBetMapper completedBetMapper;
    private final CompletedBetService completedBetService;
    public BetDTO saveNewBet(BetDTO request){
        Bet bet = new Bet();
        betMapper.mapToEntity(bet,request);
        bet.setApprove(false);
        betService.saveBet(bet);

        return betMapper.mapToDto(bet);
    }

    public CompletedBetDTO saveCompletedBet(CompletedBetDTO completedBetDTO){
        CompletedBet completedBet = new CompletedBet();
        return completedBetMapper.mapToDto(completedBetService.save(completedBet));
    }
}
