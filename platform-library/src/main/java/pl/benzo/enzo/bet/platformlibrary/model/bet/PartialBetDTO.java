package pl.benzo.enzo.bet.platformlibrary.model.bet;

import lombok.*;
import pl.benzo.enzo.bet.platformlibrary.model.EventDTO;
import pl.benzo.enzo.bet.platformlibrary.model.enumerated.BetStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartialBetDTO {
    String partialBetId;
    EventDTO event;
    LocalDateTime createdAt;
    BigDecimal ods;
    BigDecimal moneyIn;
    String winnerId;
    LocalDateTime finishedAt;
    BetStatus betStatus;
}
