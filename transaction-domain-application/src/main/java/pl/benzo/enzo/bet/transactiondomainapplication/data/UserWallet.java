package pl.benzo.enzo.bet.transactiondomainapplication.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class UserWallet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userId;
    private BigDecimal moneros;
    private String walletAddress;
    @OneToMany(mappedBy = "userWallet")
    private List<UserTransaction> historyTransactions;
}
