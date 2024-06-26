package pl.benzo.enzo.bet.transactiondomainapplication.facade;

import org.springframework.http.ResponseEntity;
import pl.benzo.enzo.bet.platformlibrary.model.TransactionDTO;

public interface TransactionDomainFacade {
    ResponseEntity<TransactionDTO> compareOperationWithBalance(TransactionDTO request);
    ResponseEntity<TransactionDTO> saveTransaction(TransactionDTO request);
}
