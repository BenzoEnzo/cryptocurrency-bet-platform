package pl.benzo.enzo.bet.betdomainapplication.logic.thread;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class ExecutorConfig {

    @Bean
    public ExecutorService taskExecutor() {
        return Executors.newFixedThreadPool(10);
    }
}