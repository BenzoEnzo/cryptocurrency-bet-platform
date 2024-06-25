package pl.benzo.enzo.bet.platformlibrary.model;

import lombok.*;
import pl.benzo.enzo.bet.platformlibrary.model.enumerated.Category;
import pl.benzo.enzo.bet.platformlibrary.model.enumerated.Status;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventDTO {
    private String eventId;
    private String title;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Category category;
    private Status status;
}
