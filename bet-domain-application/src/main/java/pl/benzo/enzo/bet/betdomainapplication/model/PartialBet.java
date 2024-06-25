package pl.benzo.enzo.bet.betdomainapplication.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.benzo.enzo.bet.platformlibrary.model.enumerated.BetStatus;
import pl.benzo.enzo.bet.platformlibrary.model.enumerated.Category;
import pl.benzo.enzo.bet.platformlibrary.model.enumerated.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(collection = "partialBets")
@NoArgsConstructor
@Getter
@Setter
public class PartialBet {
    @Id
    private String partialBetId;
    private String eventId;
    private String title;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Category category;
    private Status status;
    private String actorId;
    private String actorName;
    private String teamName;
    private LocalDateTime createdAt;
    private BigDecimal odds;
    private BetStatus betStatus;
    private Boolean approve;
}
