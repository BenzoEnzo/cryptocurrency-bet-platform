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
    Integer countPartialBets = 0;
    Integer winRatio = 0;
    LocalDateTime createdAt;
    Status finalStatus;
    BetStatus finalBetStatus;
public BetDTO(){}

    public void addWinRatio(){
    this.winRatio+=1;

    if((winRatio.equals(countPartialBets) && !winRatio.equals(0))){
        this.finalStatus = Status.FINISHED;
        this.finalBetStatus = BetStatus.WON;
    }

    }
}
