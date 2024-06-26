package pl.benzo.enzo.bet.transactiondomainapplication.facade.logic.extension;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.benzo.enzo.bet.platformlibrary.model.transaction.UserWalletDTO;
import pl.benzo.enzo.bet.transactiondomainapplication.data.mapper.UserWalletMapper;
import pl.benzo.enzo.bet.transactiondomainapplication.facade.logic.UserWalletService;

@Service
@RequiredArgsConstructor
public class WalletReader {
    private final UserWalletService userWalletService;
    private final UserWalletMapper userWalletMapper;

    public UserWalletDTO readUserWallet(String userId){
        return userWalletMapper.mapToDto(userWalletService.findByUserId(userId));
    }
}
