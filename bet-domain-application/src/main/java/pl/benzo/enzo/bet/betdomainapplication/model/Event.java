package pl.benzo.enzo.bet.betdomainapplication.model;


import org.springframework.data.annotation.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.benzo.enzo.bet.betdomainapplication.model.enumerated.Category;
import pl.benzo.enzo.bet.betdomainapplication.model.enumerated.Status;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "events")
@NoArgsConstructor
@Getter
@Setter
public class Event {
    @Id
    private String eventId;
    private String title;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Category category;
    private Status status;
    private boolean deprecate = false;
}
