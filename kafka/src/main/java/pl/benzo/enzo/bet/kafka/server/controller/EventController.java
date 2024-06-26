package pl.benzo.enzo.bet.kafka.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.benzo.enzo.bet.kafka.server.data.Event;
import pl.benzo.enzo.bet.kafka.server.data.MatchResult;
import pl.benzo.enzo.bet.kafka.server.service.EventService;
import pl.benzo.enzo.bet.kafka.server.service.MatchResultService;
import pl.benzo.enzo.bet.platformlibrary.model.MmaEventDTO;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;
    private final MatchResultService matchResultService;

    @GetMapping("")
    public ResponseEntity<List<Event>> getEvents(){
        return new ResponseEntity<>(eventService.findAllEvents(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Void> createEvent(@RequestBody Event event){
        eventService.saveEvent(event);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping("/matchResult")
    public ResponseEntity<Void> createMatchResult(@RequestBody MatchResult matchResult){
        matchResultService.saveMatchResult(matchResult);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("")
    public ResponseEntity<Void> deleteAll(){
        eventService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/mma")
    public ResponseEntity<List<Event>> getAll(@RequestBody List<MmaEventDTO> mmaEvents){
        eventService.saveAll(mmaEvents);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
