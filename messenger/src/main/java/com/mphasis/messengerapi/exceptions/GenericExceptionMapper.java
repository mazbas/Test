package com.mphasis.messengerapi.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.mphasis.messengerapi.model.ExceptionMessage;
@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable exception) {
		
		ExceptionMessage exceptionMessage = new ExceptionMessage("Internal Sever Error", 500, "abc.com");
		
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				        .entity(exceptionMessage)
				        .build();
	}
	


}
