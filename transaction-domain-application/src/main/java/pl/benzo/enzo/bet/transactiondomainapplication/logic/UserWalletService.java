package pl.benzo.enzo.bet.transactiondomainapplication.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.benzo.enzo.bet.transactiondomainapplication.data.UserWallet;
import pl.benzo.enzo.bet.transactiondomainapplication.data.repository.UserWalletRepository;

@Service
@RequiredArgsConstructor
public class UserWalletService {
    private final UserWalletRepository userWalletRepository;

    public UserWallet findByUserId(String userId){
        return userWalletRepository.findUserWalletByUserId(userId);
    }
}
