package pl.benzo.enzo.bet.platformlibrary.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompletedBetDTO {
    private String id;
    private BetDTO bet;
    private boolean won;
    private LocalDateTime createdAt;
    private BigDecimal prize;
}
