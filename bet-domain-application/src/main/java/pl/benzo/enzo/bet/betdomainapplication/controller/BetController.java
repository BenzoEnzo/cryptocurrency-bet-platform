package pl.benzo.enzo.bet.betdomainapplication.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.benzo.enzo.bet.betdomainapplication.logic.CreateBetService;
import pl.benzo.enzo.bet.platformlibrary.model.BetDTO;

@RestController
@RequestMapping("/api/bets")
@RequiredArgsConstructor
public class BetController {
    private final CreateBetService createBetService;

    @PostMapping("")
    public ResponseEntity<BetDTO> saveBet(@RequestBody BetDTO request){
        return new ResponseEntity<>(createBetService.saveNewBet(request), HttpStatus.CREATED);
    }
}
