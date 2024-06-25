package pl.benzo.enzo.bet.platformlibrary.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import pl.benzo.enzo.bet.platformlibrary.model.enumerated.BetStatus;
import pl.benzo.enzo.bet.platformlibrary.model.enumerated.Status;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class BetDTO {
    String betId;
    UserDTO user;
    TransactionDTO transaction;
    List<PartialBetDTO> partialBets;
    LocalDateTime createdAt;
    LocalDateTime finishedAt;
    Status status;
    BetStatus betStatus;
public BetDTO(){}
}
