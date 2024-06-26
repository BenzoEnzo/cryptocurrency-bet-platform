package pl.benzo.enzo.bet.transactiondomainapplication.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.benzo.enzo.bet.platformlibrary.model.TransactionDTO;
import pl.benzo.enzo.bet.transactiondomainapplication.logic.extension.UserTransactionValidate;

@Service
@RequiredArgsConstructor
public class TransactionDomainFacadeImpl implements TransactionDomainFacade {
    private final UserTransactionValidate userTransactionValidate;

    @Override
    public ResponseEntity<TransactionDTO> compareOperationWithBalance(TransactionDTO request) {
        return new ResponseEntity<>(userTransactionValidate.compareOperationWithBalance(request), HttpStatus.OK);

    }
}
