package pl.benzo.enzo.bet.betdomainapplication.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.benzo.enzo.bet.betdomainapplication.model.enumerated.BetStatus;
import pl.benzo.enzo.bet.betdomainapplication.model.enumerated.Status;

@Document(collection = "userBets")
@NoArgsConstructor
@Getter
@Setter
public class UserBet {
    @Id
    private String userBetId;
    private BetStatus userBetStatus;
}
