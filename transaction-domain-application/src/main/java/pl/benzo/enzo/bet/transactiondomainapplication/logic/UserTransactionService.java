package pl.benzo.enzo.bet.transactiondomainapplication.logic;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.benzo.enzo.bet.platformlibrary.model.TransactionDTO;
import pl.benzo.enzo.bet.transactiondomainapplication.data.UserTransaction;
import pl.benzo.enzo.bet.transactiondomainapplication.data.UserWallet;
import pl.benzo.enzo.bet.transactiondomainapplication.data.mapper.UserTransactionMapper;
import pl.benzo.enzo.bet.transactiondomainapplication.data.repository.UserTransactionRepository;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserTransactionService {
    private final UserTransactionRepository userTransactionRepository;
    private final UserTransactionMapper userTransactionMapper;
    private final UserWalletService userWalletService;
    private final Logger logger = LoggerFactory.getLogger(UserTransactionService.class);

    public TransactionDTO sendTransaction(TransactionDTO transactionDTO){
        UserTransaction userTransaction = new UserTransaction();

        userTransactionMapper.mapToEntity(userTransaction,transactionDTO);

        UserWallet userWallet = userWalletService.findByUserId(transactionDTO.getUserId());

        if(userWallet == null){
            logger.info("userWallet doesnt exist");
            return null;
        }

        BigDecimal accountBalance = userWallet.getMoneros();

        if(transactionDTO.getPrice().subtract(accountBalance).compareTo(BigDecimal.ZERO) < 0){
            logger.info("User dont have enough money in wallet");
            return null;
        }

        userTransactionRepository.save(userTransaction);

        TransactionDTO response = userTransactionMapper.mapToDTO(userTransaction);
        response.setApproveTransaction(true);

        return response;
    }
}
