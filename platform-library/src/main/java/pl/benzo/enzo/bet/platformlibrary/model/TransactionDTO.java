package pl.benzo.enzo.bet.platformlibrary.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {
    String userId;
    String transactionId;
    BigDecimal price;
    BigDecimal prizeToWin;
    String ownerXmrAddress;
    String sendToXmrAddress;
    String betId;
    Boolean approveTransaction;
}
