package pl.benzo.enzo.bet.transactiondomainapplication.facade.logic.extension;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.benzo.enzo.bet.platformlibrary.model.TransactionDTO;
import pl.benzo.enzo.bet.platformlibrary.model.transaction.UserTransactionDTO;
import pl.benzo.enzo.bet.transactiondomainapplication.data.UserTransaction;
import pl.benzo.enzo.bet.transactiondomainapplication.data.UserWallet;
import pl.benzo.enzo.bet.transactiondomainapplication.data.mapper.UserTransactionMapper;
import pl.benzo.enzo.bet.transactiondomainapplication.facade.logic.UserTransactionService;
import pl.benzo.enzo.bet.transactiondomainapplication.facade.logic.UserWalletService;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransactionPersister {
    private final UserTransactionService userTransactionService;
    private final UserTransactionMapper userTransactionMapper;
    private final UserWalletService userWalletService;

    @Transactional
    public UserTransactionDTO saveTransactionOnDatabase(TransactionDTO transactionDTO){

        UserTransactionDTO userTransactionDTO = transactionDTO.getUserTransactionDTO();
        UserTransaction userTransaction = userTransactionMapper.mapToEntity(userTransactionDTO);

        UserWallet userWallet = userWalletService.subtractTransactionAmount(userTransaction.getWalletAddress(), transactionDTO.getPrice());

        userTransaction.setUserWallet(userWallet);

        return userTransactionMapper.mapToDto( userTransactionService.saveUserTransaction(userTransaction));
    }
}
