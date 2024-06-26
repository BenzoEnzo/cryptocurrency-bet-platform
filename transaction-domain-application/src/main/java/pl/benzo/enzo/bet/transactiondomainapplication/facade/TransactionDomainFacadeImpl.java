package pl.benzo.enzo.bet.transactiondomainapplication.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.benzo.enzo.bet.platformlibrary.model.TransactionDTO;
import pl.benzo.enzo.bet.transactiondomainapplication.facade.logic.extension.TransactionPersister;
import pl.benzo.enzo.bet.transactiondomainapplication.facade.logic.extension.TransactionValidator;

@Service
@RequiredArgsConstructor
public class TransactionDomainFacadeImpl implements TransactionDomainFacade {
    private final TransactionValidator transactionValidator;
    private final TransactionPersister transactionPersister;

    @Override
    public ResponseEntity<TransactionDTO> compareOperationWithBalance(TransactionDTO request) {
        return new ResponseEntity<>(transactionValidator.compareOperationWithBalance(request), HttpStatus.OK);

    }

    @Override
    public ResponseEntity<TransactionDTO> saveTransaction(TransactionDTO request) {
        return new ResponseEntity<>(transactionPersister.saveTransactionOnDatabase(request), HttpStatus.CREATED);
    }
}
