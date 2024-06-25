package pl.benzo.enzo.bet.platformserver.logic;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import pl.benzo.enzo.bet.platformlibrary.model.BetDTO;
import pl.benzo.enzo.bet.platformlibrary.model.TransactionDTO;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<String, BetDTO> betsTemplate;
    private final KafkaTemplate<String, TransactionDTO> transactionsTemplate;
    private final Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);

    public void sendTransactionToKafka(TransactionDTO transactionDTO) {
        transactionsTemplate.send("transaction-topic", transactionDTO);
        logger.info("Sent transaction to Kafka: " + transactionDTO);
    }

    public void sendBetToKafka(BetDTO betDTO) {
        betsTemplate.send("created-user-bets", betDTO);
        logger.info("Sent bet to Kafka: " + betDTO);
    }
}
