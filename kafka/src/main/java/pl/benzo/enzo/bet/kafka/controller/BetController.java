package pl.benzo.enzo.bet.kafka.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.benzo.enzo.bet.kafka.logic.service.KafkaConsumerService;
import pl.benzo.enzo.bet.platformlibrary.model.BetDTO;

import java.util.List;

@RestController
@RequestMapping("/api/bets")
@RequiredArgsConstructor
public class BetController {
    private final KafkaConsumerService kafkaConsumerService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<BetDTO>> getBetsForUser(@PathVariable String userId){
        return new ResponseEntity<>(kafkaConsumerService.getBetsForUser(userId), HttpStatus.OK);
    }
}
