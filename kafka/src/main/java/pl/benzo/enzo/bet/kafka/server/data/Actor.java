package pl.benzo.enzo.bet.kafka.server.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.benzo.enzo.bet.platformlibrary.model.enumerated.PlayerType;

@Document(collection = "actors")
@NoArgsConstructor
@Getter
@Setter
public class Actor {
    @Id
    private String actorId;
    private String name;
    private String surrName;
    private String teamName;
    private PlayerType playerType;
}
