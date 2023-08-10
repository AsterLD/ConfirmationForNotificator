package com.ld.confirmationfornotificator.config;


import com.ld.confirmationfornotificator.dto.EventStatusDTO;
import com.ld.confirmationfornotificator.dto.EventToApproveDTO;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;


@Configuration
public class KafkaConfig {
    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("notificator").build();
    }

    @Bean
    public KafkaTemplate<String, EventStatusDTO> kafkaTemplate(ProducerFactory<String, EventStatusDTO> producerFactory) {
        return new KafkaTemplate<>(producerFactory);
    }

    @Bean
    public ProducerFactory<String, EventToApproveDTO> producerFactory(KafkaProperties kafkaProperties) {
        return new DefaultKafkaProducerFactory<>(kafkaProperties.buildProducerProperties());
    }
}
