package pl.benzo.enzo.bet.transactiondomainapplication.logic;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.benzo.enzo.bet.transactiondomainapplication.data.UserTransaction;
import pl.benzo.enzo.bet.transactiondomainapplication.data.repository.UserTransactionRepository;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class UserTransactionService {
    private final UserTransactionRepository userTransactionRepository;

    public UserTransaction saveUserTransaction(UserTransaction userTransaction){
        return userTransactionRepository.save(userTransaction);
    }

    public UserTransaction findUserTransactionById(Long id){
        return userTransactionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("UserTransaction doesnt exist"));
    }

    public UserTransaction delete(Long id){
        UserTransaction userTransaction = findUserTransactionById(id);
        userTransaction.setDeprecate(true);
        return saveUserTransaction(userTransaction);
    }

}
