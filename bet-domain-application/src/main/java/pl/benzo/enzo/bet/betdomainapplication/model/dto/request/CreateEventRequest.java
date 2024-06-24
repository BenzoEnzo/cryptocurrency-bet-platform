package pl.benzo.enzo.bet.betdomainapplication.model.dto.request;

import pl.benzo.enzo.bet.betdomainapplication.model.enumerated.Category;

import java.time.LocalDateTime;

public record CreateEventRequest(String title,
                                 LocalDateTime startTime,
                                 LocalDateTime endTime,
                                 Category category) {
}
