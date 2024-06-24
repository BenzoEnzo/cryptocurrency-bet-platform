package pl.benzo.enzo.bet.betdomainapplication.controller;

import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.benzo.enzo.bet.betdomainapplication.logic.EventFacade;
import pl.benzo.enzo.bet.betdomainapplication.logic.service.extended.CreateEventService;
import pl.benzo.enzo.bet.betdomainapplication.model.dto.EventDTO;
import pl.benzo.enzo.bet.betdomainapplication.model.dto.request.CreateEventRequest;
import pl.benzo.enzo.bet.betdomainapplication.model.dto.response.CreateEventResponse;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventController {
    private final EventFacade eventFacade;

    @PostMapping("")
    public ResponseEntity<CreateEventResponse> createEvent(@RequestBody CreateEventRequest request){
        return new ResponseEntity<>(eventFacade.createEvent(request), HttpStatus.CREATED);
    }

    @GetMapping("/upcoming")
    public ResponseEntity<List<EventDTO>> getUpcomingEvents(){
        return new ResponseEntity<>(eventFacade.findUpcomingEvents(), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<EventDTO>> getAllEvents(){
        return new ResponseEntity<>(eventFacade.findAllEvents(), HttpStatus.OK);
    }
}
