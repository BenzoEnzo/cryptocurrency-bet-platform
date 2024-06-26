package pl.benzo.enzo.bet.transactiondomainapplication.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.benzo.enzo.bet.transactiondomainapplication.data.UserWallet;

@Repository
public interface UserWalletRepository extends JpaRepository<UserWallet, Long> {
    UserWallet findUserWalletByUserId(String userId);
    UserWallet findUserWalletByWalletAddress(String address);
}
