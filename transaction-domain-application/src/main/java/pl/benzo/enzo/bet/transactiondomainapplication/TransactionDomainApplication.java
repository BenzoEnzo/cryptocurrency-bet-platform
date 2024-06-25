package pl.benzo.enzo.bet.transactiondomainapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "pl.benzo.enzo.bet.platformlibrary.client")
public class TransactionDomainApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionDomainApplication.class, args);
    }

}
