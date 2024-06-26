package pl.benzo.enzo.bet.transactiondomainapplication.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class UserTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userId;
    private BigDecimal moneros;
    private String walletAddress;
    private TransactionStatus transactionStatus;
    private LocalDateTime createdAt;
    private String betId;
    private boolean deprecate;
    @ManyToOne
    @JoinColumn(name = "user_wallet_id")
    private UserWallet userWallet;

}
