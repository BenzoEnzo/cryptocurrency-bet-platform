package pl.benzo.enzo.bet.betdomainapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BetDomainApplication {

    public static void main(String[] args) {
        SpringApplication.run(BetDomainApplication.class, args);
    }

}
