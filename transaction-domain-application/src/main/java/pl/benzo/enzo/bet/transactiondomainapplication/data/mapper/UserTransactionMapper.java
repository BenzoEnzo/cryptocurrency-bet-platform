package pl.benzo.enzo.bet.transactiondomainapplication.data.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.benzo.enzo.bet.platformlibrary.model.TransactionDTO;
import pl.benzo.enzo.bet.transactiondomainapplication.data.UserTransaction;

@Component
public class UserTransactionMapper {

    public void mapToEntity(UserTransaction userTransaction, TransactionDTO transactionDTO){
        userTransaction.setUserId(transactionDTO.getUserId());
        userTransaction.setMoneros(transactionDTO.getPrice());
        userTransaction.setBetId(transactionDTO.getBetId());
    }

    public TransactionDTO mapToDTO(UserTransaction userTransaction){
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setTransactionId(String.valueOf(userTransaction.getId()));
        transactionDTO.setBetId(userTransaction.getBetId());
        transactionDTO.setOwnerXmrAddress(userTransaction.getWalletAddress());
        return transactionDTO;
    }
}
