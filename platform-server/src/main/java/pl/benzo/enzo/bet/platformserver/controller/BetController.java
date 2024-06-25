package pl.benzo.enzo.bet.platformserver.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.benzo.enzo.bet.platformlibrary.client.BetDomainClient;
import pl.benzo.enzo.bet.platformlibrary.model.BetDTO;
import pl.benzo.enzo.bet.platformserver.web.KafkaProducerService;

import java.util.List;

@RestController
@RequestMapping("/api/bets")
@RequiredArgsConstructor
public class BetController {
    private final BetDomainClient betDomainClient;
    private final KafkaProducerService kafkaProducerService;
    @PostMapping("")
    public ResponseEntity<BetDTO> saveBet(@RequestBody BetDTO request){
        kafkaProducerService.sendBetToKafka("created-user-bets",request);
        return new ResponseEntity<>(betDomainClient.saveBet(request), HttpStatus.CREATED);
    }
}
