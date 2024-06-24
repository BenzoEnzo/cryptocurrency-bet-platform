package pl.benzo.enzo.bet.betdomainapplication.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.benzo.enzo.bet.betdomainapplication.model.enumerated.BetStatus;

import java.math.BigDecimal;

@Document(collection = "singleBets")
@NoArgsConstructor
@Getter
@Setter
public class SingleBet {
    @Id
    private String singleBetId;
    private Event event;
    private Market market;
    private BetStatus betStatus;
    private Boolean playerOneWinner;
    private Boolean playerTwoWinner;
    private BigDecimal winnerPoints;
    private BigDecimal loserPoints;
}
