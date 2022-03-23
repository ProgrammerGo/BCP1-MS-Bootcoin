package com.nttdata.msbootcoin.config;

import java.util.HashMap;
import java.util.Map;

import com.nttdata.msbootcoin.model.MessageDto;
import com.nttdata.msbootcoin.util.MessageDeserializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

@Configuration
public class KafkaConsumerConfig {
	
	@Value("${spring.kafka.bootstrap-servers}")
	private String bootstrapServers;
	
	@Bean
	public Map<String, Object> consumerConfig(){
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, MessageDeserializer.class);
		return props;
	}
	
	@Bean 
	public ConsumerFactory<String, MessageDto> consumerFactory() {
		return new DefaultKafkaConsumerFactory<>(consumerConfig());
	}
	
	 @Bean
	 public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, MessageDto>> kafkaListenerContainerFactory (
			 ConsumerFactory<String, MessageDto> consumerFactory
			 ){
		 
		 ConcurrentKafkaListenerContainerFactory<String, MessageDto> factory = new ConcurrentKafkaListenerContainerFactory<>();
		 
		 factory.setConsumerFactory(consumerFactory);
		 return factory;
	 }
}
