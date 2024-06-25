package pl.benzo.enzo.bet.platformlibrary.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.benzo.enzo.bet.platformlibrary.model.TransactionDTO;

@FeignClient(name = "transaction-application", url ="http://localhost:8086")
public interface TransactionClient {
    @RequestMapping(method = RequestMethod.POST, value ="/api/transactions")
    TransactionDTO sendTransaction(@RequestBody TransactionDTO request);
}
