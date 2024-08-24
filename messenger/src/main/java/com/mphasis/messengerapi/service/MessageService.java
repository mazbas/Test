package com.mphasis.messengerapi.service;

import java.util.ArrayList;
import java.util.Map;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import java.util.List;

import com.mphasis.messengerapi.exceptions.DataNotFoundException;
import com.mphasis.messengerapi.model.ExceptionMessage;
import com.mphasis.messengerapi.model.Message;
import com.mphasis.messengerapi.repository.MessageRepository;



public class MessageService {
	
	private Map<Integer, Message> messages = MessageRepository.getMessages();

	public MessageService() {
		// TODO Auto-generated constructor stub
	
	//messages.put(1, new Message(1, "Hello Jersy", "Basha"));
	//messages.put(2, new Message(2, "Hello JAX-RS", "Basha"));
	}
	
	public List<Message> getAllMessages(){
		
		return new ArrayList<Message>(messages.values());
	}
	
	    public Message getMessage(int id) {
	    	
	    	Message message = messages.get(id);
	    	
//	    	if(message == null) {
//	    		
//	    		throw new DataNotFoundException("Resource Not Found for id -"+id);
//	    	}
//	    	return message;
	    	ExceptionMessage errorMessage = new ExceptionMessage("Resource Not Found",404,"http://google.com");
			  
	    	if(message == null) {
	    		
	    		throw new NotFoundException(Response.status(Status.NOT_FOUND)
				          .entity(errorMessage)
				          .build());
	    	}
	     	 return message;
	    }
	    
	    public Message addMessage(Message message) {
	    	
	    	 message.setId(messages.size()+1);
	         messages.put(message.getId(), message);
	         return message;
	    }
	    
	    public Message deleteMessage(int id) {
	    	
	    return messages.remove(id);	
	    }
	  
	    public Message updateMessage(Message message) {
	    	
	    	
	    	 messages.put(message.getId(),message);
	         
	    	 return message;
	    }

	    public List<Message> getAllMessagesPaginated(int start,int size) {
	    	
	    	List<Message> list= new ArrayList<Message>(messages.values());
	    	    if(start+size > list.size()) {
	    	    	
	    	    	return new ArrayList<Message>();
	    	    }
	    	
	    	return list.subList(start, start+size);
	    }
}

