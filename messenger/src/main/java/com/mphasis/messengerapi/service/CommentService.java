package com.mphasis.messengerapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mphasis.messengerapi.model.Comment;
import com.mphasis.messengerapi.model.Message;
import com.mphasis.messengerapi.repository.MessageRepository;
public class CommentService {

	private Map<Integer,Message> messages = MessageRepository.getMessages();
	
	public List<Comment>getAllComments(int messageId){
		
		Map<Integer,Comment> comments  = messages.get(messageId).getComments();
		
		return new ArrayList<Comment>(comments.values());
	}
	
	public Comment addComment(int messageId,Comment comment) {
		
		Map<Integer,Comment> comments  = messages.get(messageId).getComments();
	    comment.setId(comments.size()+1);
	     // add the comment inside the map of the comment
	    return comments.put(comment.getId(), comment);
	}
	
}
