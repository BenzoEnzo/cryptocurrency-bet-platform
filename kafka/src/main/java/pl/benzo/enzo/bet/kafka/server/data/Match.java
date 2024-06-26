package pl.benzo.enzo.bet.kafka.server.data;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "matches")
@NoArgsConstructor
@Getter
@Setter
public class Match {
    @Id
    private String matchId;
    private String name;
    private Actor winner;
    private Actor loser;
}
