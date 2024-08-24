package com.mphasis.messengerapi.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import com.mphasis.messengerapi.model.ExceptionMessage;

@Provider // this is to give us hint for JAX-RS
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {
      
	  @Override
	  public Response toResponse(DataNotFoundException exception) {
		  
		  ExceptionMessage message = new ExceptionMessage(exception.getMessage(),404,"http://google.com");
		  
		  return Response.status(Status.NOT_FOUND)
				          .entity(message)
				          .build();
	  }
}
