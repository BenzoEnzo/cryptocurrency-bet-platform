package pl.benzo.enzo.bet.platformlibrary.model.transaction;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.benzo.enzo.bet.platformlibrary.model.enumerated.TransactionStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class UserTransactionDTO {
    private Long id;
    private String userId;
    private BigDecimal moneros;
    private String walletAddress;
    private TransactionStatus transactionStatus;
    private LocalDateTime createdAt;
    private String betId;
    private boolean deprecate;
}
