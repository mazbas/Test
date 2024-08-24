package com.mphasis.messengerapi.resource;



import java.util.List;

//import java.awt.PageAttributes.MediaType;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
//import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import com.mphasis.messengerapi.model.Comment;
import com.mphasis.messengerapi.service.CommentService;

public class CommentResource {  // /messages/{messageId}/
	
//	@GET
//	@Path("comments")
//	@Produces(MediaType.TEXT_PLAIN) //message/{messageId}/comments
//	
//	public String test(@PathParam("messageId") int messageId) {
//		
//		return "Comment Test= " +messageId;
//	}

   CommentService commentSevice = new CommentService();
    @GET
   	@Produces(MediaType.APPLICATION_JSON)
   public List<Comment>getComments(@PathParam("messageId") int messageId){
	   
	   return commentSevice.getAllComments(messageId);
   }
    
    @POST 
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Comment createComment(@PathParam("messageId") int messageId,Comment comment){
    	 
    	return  commentSevice.addComment(messageId, comment);
    	 
     }

}




