package pl.benzo.enzo.bet.kafka.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.benzo.enzo.bet.kafka.database.Event;
import pl.benzo.enzo.bet.kafka.logic.service.EventService;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @GetMapping("")
    public ResponseEntity<List<Event>> getEvents(){
        return new ResponseEntity<>(eventService.findAllEvents(), HttpStatus.OK);
    }


}
