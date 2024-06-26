package pl.benzo.enzo.bet.platformlibrary.model.transaction;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserWalletDTO {
    private Long id;
    private String userId;
    private BigDecimal moneros;
    private String walletAddress;
    private List<UserTransactionDTO> historyTransactions;
}
