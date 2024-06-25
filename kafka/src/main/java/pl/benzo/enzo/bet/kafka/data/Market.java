package pl.benzo.enzo.bet.kafka.data;

import org.springframework.data.annotation.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(collection = "markets")
@NoArgsConstructor
@Getter
@Setter
public class Market {
    @Id
    private String marketId;
    private String description;
    private BigDecimal odds;
    private LocalDateTime date;
    private Actor actor;
}

