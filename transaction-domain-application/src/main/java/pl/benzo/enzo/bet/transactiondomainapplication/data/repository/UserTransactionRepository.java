package pl.benzo.enzo.bet.transactiondomainapplication.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.benzo.enzo.bet.transactiondomainapplication.data.UserTransaction;

@Repository
public interface UserTransactionRepository extends JpaRepository<UserTransaction,Long> {
}
