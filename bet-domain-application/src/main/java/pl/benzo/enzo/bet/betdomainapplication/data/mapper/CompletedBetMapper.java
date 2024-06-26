package pl.benzo.enzo.bet.betdomainapplication.data.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.benzo.enzo.bet.betdomainapplication.data.Bet;
import pl.benzo.enzo.bet.betdomainapplication.data.CompletedBet;
import pl.benzo.enzo.bet.platformlibrary.base.BaseMapper;
import pl.benzo.enzo.bet.platformlibrary.model.bet.CompletedBetDTO;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class CompletedBetMapper implements BaseMapper<CompletedBet,CompletedBetDTO> {
    private final BetMapper betMapper;

    @Override
    public CompletedBet mapToEntity(CompletedBetDTO completedBetDTO) {
        CompletedBet completedBet = new CompletedBet();
        Bet bet = new Bet();
        betMapper.mapToEntity(bet,completedBetDTO.getBet());
        completedBet.setBet(bet);
        completedBet.setWon(completedBet.isWon());
        completedBet.setCreatedAt(LocalDateTime.now());
        return completedBet;
    }

    @Override
    public CompletedBetDTO mapToDto(CompletedBet e) {
        return null;
    }

    @Override
    public void mapToUpdate(CompletedBetDTO completedBetDTO) {

    }
}
