package pl.benzo.enzo.bet.platformserver.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.benzo.enzo.bet.platformlibrary.client.SportsClient;
import pl.benzo.enzo.bet.platformlibrary.client.TradeClient;
import pl.benzo.enzo.bet.platformlibrary.model.MmaEventDTO;


import java.util.List;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventController {
    private final TradeClient tradeClient;
    private final SportsClient sportsClient;

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<Object>> getAllEvents(){
        return new ResponseEntity<>(tradeClient.getEvents(), HttpStatus.OK);
    }

    @GetMapping("/mma")
    @ResponseBody
    public ResponseEntity<List<MmaEventDTO>> getAllMMAEvents(){
        return new ResponseEntity<>(sportsClient.getSportsEvent(), HttpStatus.OK);
    }

}
