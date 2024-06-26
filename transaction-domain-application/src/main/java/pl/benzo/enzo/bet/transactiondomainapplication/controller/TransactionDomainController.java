package pl.benzo.enzo.bet.transactiondomainapplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.benzo.enzo.bet.platformlibrary.model.TransactionDTO;
import pl.benzo.enzo.bet.platformlibrary.model.transaction.UserTransactionDTO;
import pl.benzo.enzo.bet.platformlibrary.model.transaction.UserWalletDTO;
import pl.benzo.enzo.bet.transactiondomainapplication.facade.TransactionDomainFacade;

@RequestMapping("/api/transactions")
@RestController
@RequiredArgsConstructor
public class TransactionDomainController {
    private final TransactionDomainFacade transactionDomainFacade;

    @GetMapping("/{userId}")
    public ResponseEntity<UserWalletDTO> readUserWallet(@PathVariable String userId){
        return transactionDomainFacade.readUserWallet(userId);
    }

    @PostMapping("")
    public ResponseEntity<UserTransactionDTO> saveTransaction(@RequestBody TransactionDTO request){
        return transactionDomainFacade.saveTransaction(request);
    }
}
