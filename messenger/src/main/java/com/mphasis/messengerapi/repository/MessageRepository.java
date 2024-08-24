package com.mphasis.messengerapi.repository;

import java.util.LinkedHashMap;
import java.util.Map;

import com.mphasis.messengerapi.model.Message;

public class MessageRepository {
	
	
    private static Map<Integer, Message> messages = new LinkedHashMap<Integer, Message>();

	public static Map<Integer, Message> getMessages() {
		return messages;
	}

	public static void setMessages(Map<Integer, Message> messages) {
		MessageRepository.messages = messages;
	}

     
}
