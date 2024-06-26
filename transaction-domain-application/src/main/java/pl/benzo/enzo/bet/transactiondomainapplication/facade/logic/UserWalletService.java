package pl.benzo.enzo.bet.transactiondomainapplication.facade.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.benzo.enzo.bet.platformlibrary.model.TransactionDTO;
import pl.benzo.enzo.bet.transactiondomainapplication.data.UserWallet;
import pl.benzo.enzo.bet.transactiondomainapplication.data.repository.UserWalletRepository;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class UserWalletService {
    private final UserWalletRepository userWalletRepository;

    public UserWallet findByUserId(String userId){
        return userWalletRepository.findUserWalletByUserId(userId);
    }

    public UserWallet subtractTransactionAmount(String transactionAddress, BigDecimal moneyToSubtract){
        UserWallet userWallet = userWalletRepository.findUserWalletByWalletAddress(transactionAddress);

        final BigDecimal accBalance = userWallet
                .getMoneros()
                .subtract(moneyToSubtract);

        userWallet.setMoneros(accBalance);

        return userWalletRepository.save(userWallet);
    }
}
