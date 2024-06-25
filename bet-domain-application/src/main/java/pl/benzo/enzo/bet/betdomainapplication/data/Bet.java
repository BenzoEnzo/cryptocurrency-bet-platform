package pl.benzo.enzo.bet.betdomainapplication.data;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "bets")
@NoArgsConstructor
@Getter
@Setter
public class Bet {
    @Id
    public String betId;
    public String userId;
    public String mail;
    public String transactionId;
    public Boolean approve;
    public List<PartialBet> partialBets;
}
