package pl.benzo.enzo.bet.betdomainapplication.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(collection = "completedBets")
@NoArgsConstructor
@Getter
@Setter
public class CompletedBet {
    private String id;
    private Bet bet;
    private boolean won;
    private LocalDateTime createdAt;
    private BigDecimal prize;
}
