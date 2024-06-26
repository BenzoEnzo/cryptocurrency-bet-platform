package pl.benzo.enzo.bet.platformlibrary.model;

import lombok.*;
import pl.benzo.enzo.bet.platformlibrary.model.transaction.UserTransactionDTO;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {
    UserTransactionDTO userTransactionDTO;
    String userId;
    String transactionId;
    BigDecimal price;
    BigDecimal prizeToWin;
    String ownerXmrAddress;
    String sendToXmrAddress;
    String betId;
    Boolean approveTransaction;
    BigDecimal afterTransactionBalance;
}
