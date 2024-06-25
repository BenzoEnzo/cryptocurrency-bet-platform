package pl.benzo.enzo.bet.platformserver.logic;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import pl.benzo.enzo.bet.platformlibrary.model.BetDTO;
import pl.benzo.enzo.bet.platformlibrary.model.TransactionDTO;


import java.util.HashMap;
import java.util.Map;


@Configuration
public class KafkaProducerConfig {


    public Map<String, Object> producerFactory(String groupId) {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:29092");
        configProps.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return configProps;
    }


    public <T> KafkaTemplate<String, T> kafkaTemplate(String groupId) {
        Map<String, Object> mapProps = producerFactory(groupId);
        ProducerFactory<String, T> producerFactory = new DefaultKafkaProducerFactory<>(mapProps);
        return new KafkaTemplate<>(producerFactory);
    }

    @Bean
    public KafkaTemplate<String, BetDTO> betsTemplate(){
        return kafkaTemplate("my-bets");
    }

    @Bean
    public KafkaTemplate<String, TransactionDTO> transactionsTemplate(){
        return kafkaTemplate("my-transactions");
    }
}
