package pl.benzo.enzo.bet.platformlibrary.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "kafka", url ="http://localhost:8092")
public interface TradeClient {

    @RequestMapping(method = RequestMethod.GET, value ="/api/events")
    List<Object> getEvents();
}
