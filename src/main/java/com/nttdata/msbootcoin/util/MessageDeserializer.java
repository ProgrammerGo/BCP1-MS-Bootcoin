package com.nttdata.msbootcoin.util;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import com.bank.bootcoin.model.MessageDto;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MessageDeserializer implements Deserializer<MessageDto>{
	private final ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public MessageDto deserialize(String topic, byte[] data) {
		try {
            if (data == null){
                System.out.println("Null received at deserializing");
                return null;
            }
            System.out.println("Deserializing...");
            return objectMapper.readValue(new String(data, "UTF-8"), MessageDto.class);
        } catch (Exception e) {
            throw new SerializationException("Error when deserializing byte[] to Message...");
        }
	}

}
