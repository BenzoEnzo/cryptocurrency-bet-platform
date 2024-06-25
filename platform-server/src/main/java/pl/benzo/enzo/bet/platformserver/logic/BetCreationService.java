package pl.benzo.enzo.bet.platformserver.logic;

import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.benzo.enzo.bet.platformlibrary.client.TransactionClient;
import pl.benzo.enzo.bet.platformlibrary.model.BetDTO;
import pl.benzo.enzo.bet.platformlibrary.model.TransactionDTO;

@Service
@RequiredArgsConstructor
@Slf4j
public class BetCreationService {
    private final TransactionClient transactionClient;
    private final KafkaProducerService kafkaProducerService;
    private final Logger logger = LoggerFactory.getLogger(BetCreationService.class);

    public void createBet(BetDTO betDTO) {
        TransactionDTO transactionDTO = betDTO.getTransaction();

        Try.of(() -> sendTransactionInThread(transactionDTO))
                .andThen(transactionResponse -> {
                    if (transactionResponse.getApproveTransaction()) {
                        kafkaProducerService.sendBetToKafka(betDTO);
                    } else {
                        logger.info("Transaction not approved");
                    }
                })
                .onFailure(throwable -> logger.error("Failed to process bet creation", throwable));
    }

    private TransactionDTO sendTransactionInThread(TransactionDTO transactionDTO) {
        return Try.of(() -> transactionClient.sendTransaction(transactionDTO))
                .getOrElseThrow(throwable -> new RuntimeException("Failed to send transaction", throwable));
    }
}


