package pl.benzo.enzo.bet.transactiondomainapplication.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.benzo.enzo.bet.platformlibrary.model.TransactionDTO;
import pl.benzo.enzo.bet.transactiondomainapplication.logic.UserTransactionService;

@RequestMapping("/api/transactions")
@RestController
@RequiredArgsConstructor
public class UserTransactionController {
    private final UserTransactionService userTransactionService;

    @PostMapping("")
    public ResponseEntity<TransactionDTO> sendTransaction(@RequestBody TransactionDTO request){
        return new ResponseEntity<>(userTransactionService.sendTransaction(request), HttpStatus.CREATED);
    }
}
