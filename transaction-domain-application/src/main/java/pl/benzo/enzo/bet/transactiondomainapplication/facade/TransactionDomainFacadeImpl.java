package pl.benzo.enzo.bet.transactiondomainapplication.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.benzo.enzo.bet.platformlibrary.model.TransactionDTO;
import pl.benzo.enzo.bet.platformlibrary.model.transaction.UserTransactionDTO;
import pl.benzo.enzo.bet.platformlibrary.model.transaction.UserWalletDTO;
import pl.benzo.enzo.bet.transactiondomainapplication.facade.logic.extension.TransactionPersister;
import pl.benzo.enzo.bet.transactiondomainapplication.facade.logic.extension.WalletReader;

@Service
@RequiredArgsConstructor
public class TransactionDomainFacadeImpl implements TransactionDomainFacade {
    private final WalletReader walletReader;
    private final TransactionPersister transactionPersister;

    @Override
    public ResponseEntity<UserTransactionDTO> saveTransaction(TransactionDTO request) {
        return new ResponseEntity<>(transactionPersister.saveTransactionOnDatabase(request), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<UserWalletDTO> readUserWallet(String userId) {
        return new ResponseEntity<>(walletReader.readUserWallet(userId),HttpStatus.OK);
    }
}
