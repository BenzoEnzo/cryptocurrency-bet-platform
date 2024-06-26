package pl.benzo.enzo.bet.transactiondomainapplication.facade;

import org.springframework.http.ResponseEntity;
import pl.benzo.enzo.bet.platformlibrary.model.TransactionDTO;
import pl.benzo.enzo.bet.platformlibrary.model.transaction.UserTransactionDTO;
import pl.benzo.enzo.bet.platformlibrary.model.transaction.UserWalletDTO;

public interface TransactionDomainFacade {
    ResponseEntity<UserTransactionDTO> saveTransaction(TransactionDTO request);
    ResponseEntity<UserWalletDTO> readUserWallet(String userId);
}
