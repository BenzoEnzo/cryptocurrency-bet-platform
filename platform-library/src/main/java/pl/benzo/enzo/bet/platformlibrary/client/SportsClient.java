package pl.benzo.enzo.bet.platformlibrary.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.benzo.enzo.bet.platformlibrary.model.BetDTO;
import pl.benzo.enzo.bet.platformlibrary.model.MmaEventDTO;

import java.util.List;

@FeignClient(name = "sports-client", url ="https://api.sportsdata.io/v3/mma/scores/json/Schedule/UFC/2024?key=d48a0a229537476096e5092e6ffd5af0")
public interface SportsClient {
    @RequestMapping(method = RequestMethod.GET, value ="")
    List<MmaEventDTO> getSportsEvent();
}
