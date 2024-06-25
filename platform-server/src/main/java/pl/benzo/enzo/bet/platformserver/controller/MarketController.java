package pl.benzo.enzo.bet.platformserver.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.benzo.enzo.bet.platformlibrary.client.TradeClient;


import java.util.List;

@RestController
@RequestMapping("/api/markets")
@RequiredArgsConstructor
public class MarketController {
    private final TradeClient tradeClient;


    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<Object>> getAllEvents(){
        return new ResponseEntity<>(tradeClient.getEvents(), HttpStatus.OK);
    }

}
