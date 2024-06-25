package pl.benzo.enzo.bet.platformserver.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.benzo.enzo.bet.platformlibrary.model.BetDTO;
import pl.benzo.enzo.bet.platformserver.logic.BetCreationService;

@RestController
@RequestMapping("/api/bets")
@RequiredArgsConstructor
public class BetController {
        private final BetCreationService betCreationService;

    @PostMapping("")
    public ResponseEntity<Void> saveBet(@RequestBody BetDTO request){
        betCreationService.createBet(request);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
