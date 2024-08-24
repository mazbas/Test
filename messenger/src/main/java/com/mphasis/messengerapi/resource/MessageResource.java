package com.mphasis.messengerapi.resource;

import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.mphasis.messengerapi.model.Message;
import com.mphasis.messengerapi.service.MessageService;

@Path("messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class MessageResource {
	
	private static final String BaseURI = null;
	MessageService service = new MessageService();
	//@GET
	//public List<Message> getMessages(){
		
		//return service.getAllMessages();
	//}
	@GET
	public List<Message> getMessages(@QueryParam("start")int start,@QueryParam("size")int size){
		
		if( start >= 0 &&  size > 0) {
			
			return service.getAllMessagesPaginated(start, size);
		}
	
		return service.getAllMessages();
	}
 
 
	
	@GET
   @Path("/{messageId}")
    public Message getMessage(@PathParam("messageId")int id) {
    	
    	return service.getMessage(id);
    	
    }
   // @POST
   // public Message createMessage(Message message) { //from request body
	   
	//  return service.addMessage(message);
     //  }
   
	
	@POST
    public Response createMessage(Message message,@Context UriInfo info) { //from request body
	   
	          Message newMessage = service.addMessage(message);
	             
	        Response response=Response.status(Status.CREATED).header("BaseURI", info.getBaseUri()).entity(newMessage).build();
	        return response;
       }
    
    
	
	//@DELETE	
    //@Path("/{messageId}")
    // public Message deleteMessage(@PathParam("messageId")int id) {
    		
    		//return service.deleteMessage(id);
    		
    	//}
	
	
	@DELETE	
    @Path("/{messageId}")
     public Response deleteMessage(@PathParam("messageId")int id) {
		
		 Message deleteMessage = service.deleteMessage(id);
    		
    		if(deleteMessage == null) {
    			
    			return Response.status(Status.NOT_FOUND)
    				     		.header("status", "NOT FOUND !!!")
    					 		.build();
    			
    		       }
		 
		           return Response.status(Status.OK)
		        		          .entity(deleteMessage)
		        		          .header("status","Message found and Deleted")
		        		          .build();
		  
    		
    	}
	
	
	
    	public Message updateMessage(@PathParam("messageId")int id,Message message) {
         message.setId(id);
         return service.updateMessage(message);
    	}
    	   @Path("/{messageId}/comments")   //   /message/{messageId}/comments
    	 public CommentResource getCommentResource() {
    		 
    		 return new CommentResource();
    	 }


}
