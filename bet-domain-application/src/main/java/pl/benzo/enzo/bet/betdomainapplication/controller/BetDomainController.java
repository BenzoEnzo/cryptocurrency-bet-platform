package pl.benzo.enzo.bet.betdomainapplication.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.benzo.enzo.bet.betdomainapplication.logic.BetPersister;
import pl.benzo.enzo.bet.platformlibrary.model.bet.BetDTO;
import pl.benzo.enzo.bet.platformlibrary.model.bet.CompletedBetDTO;

@RestController
@RequestMapping("/api/bets")
@RequiredArgsConstructor
public class BetDomainController {
    private final BetPersister betPersister;

    @PostMapping("")
    public ResponseEntity<BetDTO> saveBet(@RequestBody BetDTO request){
        return new ResponseEntity<>(betPersister.saveNewBet(request), HttpStatus.CREATED);
    }

    @PostMapping("/complete")
    public ResponseEntity<CompletedBetDTO> saveCompletedBet(@RequestBody CompletedBetDTO request){
        return new ResponseEntity<>(betPersister.saveCompletedBet(request), HttpStatus.CREATED);
    }
}
