package pl.benzo.enzo.bet.platformlibrary.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.benzo.enzo.bet.platformlibrary.model.BetDTO;

@FeignClient(name = "bet-domain-application", url ="http://localhost:8091")
public interface BetClient {
    @RequestMapping(method = RequestMethod.POST, value ="/api/bets")
    BetDTO saveBet(@RequestBody BetDTO request);
}
