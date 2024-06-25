package pl.benzo.enzo.bet.platformserver.logic;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import pl.benzo.enzo.bet.platformlibrary.model.BetDTO;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, BetDTO> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, BetDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendBetToKafka(String topic, BetDTO betDTO) {
        kafkaTemplate.send(topic, betDTO);
    }
}
