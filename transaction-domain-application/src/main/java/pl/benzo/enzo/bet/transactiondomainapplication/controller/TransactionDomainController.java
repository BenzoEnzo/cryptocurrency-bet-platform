package pl.benzo.enzo.bet.transactiondomainapplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.benzo.enzo.bet.platformlibrary.model.TransactionDTO;
import pl.benzo.enzo.bet.transactiondomainapplication.facade.TransactionDomainFacade;

@RequestMapping("/api/transactions")
@RestController
@RequiredArgsConstructor
public class TransactionDomainController {
    private final TransactionDomainFacade transactionDomainFacade;

    @PostMapping("")
    public ResponseEntity<TransactionDTO> validateTransactionAccountBalance(@RequestBody TransactionDTO request){
        return transactionDomainFacade.compareOperationWithBalance(request);
    }

    @PostMapping("")
    public ResponseEntity<TransactionDTO> saveTransaction(@RequestBody TransactionDTO request){
        return transactionDomainFacade.saveTransaction(request);
    }
}
