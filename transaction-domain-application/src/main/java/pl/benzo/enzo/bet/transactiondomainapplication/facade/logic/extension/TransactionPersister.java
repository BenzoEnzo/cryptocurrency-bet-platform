package pl.benzo.enzo.bet.transactiondomainapplication.facade.logic.extension;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.benzo.enzo.bet.platformlibrary.model.TransactionDTO;
import pl.benzo.enzo.bet.transactiondomainapplication.data.UserTransaction;
import pl.benzo.enzo.bet.transactiondomainapplication.data.UserWallet;
import pl.benzo.enzo.bet.transactiondomainapplication.data.mapper.UserTransactionMapper;
import pl.benzo.enzo.bet.transactiondomainapplication.facade.logic.UserTransactionService;
import pl.benzo.enzo.bet.transactiondomainapplication.facade.logic.UserWalletService;

@Service
@RequiredArgsConstructor
public class TransactionPersister {
    private final UserTransactionService userTransactionService;
    private final UserTransactionMapper userTransactionMapper;
    private final UserWalletService userWalletService;

    @Transactional
    public TransactionDTO saveTransactionOnDatabase(TransactionDTO transactionDTO){
        UserTransaction userTransaction = new UserTransaction();

        userTransactionMapper.mapToEntity(userTransaction,transactionDTO);

        UserWallet userWallet = userWalletService.subtractTransactionAmount(userTransaction.getWalletAddress(),transactionDTO.getPrice());

        userTransaction.setUserWallet(userWallet);

        userTransactionService.saveUserTransaction(userTransaction);

        transactionDTO.setAfterTransactionBalance(userWallet.getMoneros());

        return transactionDTO;
    }
}
