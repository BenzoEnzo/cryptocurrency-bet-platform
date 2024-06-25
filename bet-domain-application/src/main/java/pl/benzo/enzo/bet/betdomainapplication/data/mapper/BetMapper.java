package pl.benzo.enzo.bet.betdomainapplication.data.mapper;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.benzo.enzo.bet.betdomainapplication.data.Bet;
import pl.benzo.enzo.bet.betdomainapplication.data.PartialBet;
import pl.benzo.enzo.bet.platformlibrary.model.BetDTO;
import pl.benzo.enzo.bet.platformlibrary.model.PartialBetDTO;
import pl.benzo.enzo.bet.platformlibrary.model.TransactionDTO;
import pl.benzo.enzo.bet.platformlibrary.model.UserDTO;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BetMapper {
    private final PartialBetMapper partialBetMapper;
    public void mapToEntity(Bet bet, BetDTO betDTO){
        List<PartialBet> partialBetList = betDTO.getPartialBets().stream().map(g -> {
                    PartialBet partialBet = new PartialBet();
                    partialBetMapper.mapToEntity(partialBet,g);
                    return partialBet;
                }).toList();

        bet.setUserId(betDTO.getUser().getUserId());
        bet.setMail(betDTO.getUser().getMail());
        bet.setTransactionId(betDTO.getTransaction().getTransactionId());
        bet.setBetId(betDTO.getUser().getUserId()+betDTO.getTransaction().getTransactionId());
        bet.setPartialBets(partialBetList);

    }

    public BetDTO mapToDto(Bet bet){
        UserDTO user = UserDTO.builder()
                .userId(bet.userId)
                .mail(bet.mail)
                .build();

        TransactionDTO transactionDTO = TransactionDTO.builder()
                .transactionId(bet.getTransactionId())
                .build();

        List<PartialBetDTO> partialBetDTOS = bet.partialBets.stream().map(partialBetMapper::mapToDTO)
                .toList();

        return BetDTO.builder()
                .user(user)
                .betId(bet.getBetId())
                .transaction(transactionDTO)
                .partialBets(partialBetDTOS)
                .build();
    }
}
