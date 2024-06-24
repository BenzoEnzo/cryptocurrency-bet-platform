package pl.benzo.enzo.bet.betdomainapplication.model.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.benzo.enzo.bet.betdomainapplication.model.enumerated.Category;
import pl.benzo.enzo.bet.betdomainapplication.model.enumerated.Status;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class EventDTO {
    private String eventId;
    private String title;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Category category;
    private Status status;
}
