package pl.benzo.enzo.bet.betdomainapplication.model;

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
    private BigDecimal odds;
    private String choice;
    private LocalDateTime date;
}
