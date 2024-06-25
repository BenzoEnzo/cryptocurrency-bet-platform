package pl.benzo.enzo.bet.kafka.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "matchResults")
@NoArgsConstructor
@Getter
@Setter
public class MatchResult {
    @Id
    private String matchResultId;
    private Event event;
    private Match match;
}
