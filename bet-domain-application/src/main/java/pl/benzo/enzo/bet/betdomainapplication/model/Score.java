package pl.benzo.enzo.bet.betdomainapplication.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.benzo.enzo.bet.betdomainapplication.model.enumerated.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(collection = "scores")
@NoArgsConstructor
@Getter
@Setter
public class Score {
    private String scoreId;
    private Status status;
    private String title;
    private Boolean playerOneWinner;
    private Boolean playerTwoWinner;
    private BigDecimal winnerPoints;
    private BigDecimal loserPoints;
    private LocalDateTime finishedAt;
    private Event event;
}
