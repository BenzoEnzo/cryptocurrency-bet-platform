package pl.benzo.enzo.bet.betdomainapplication.model.dto.response;

import java.time.LocalDateTime;

public record CreateEventResponse(LocalDateTime createdAt,String title) {
}
