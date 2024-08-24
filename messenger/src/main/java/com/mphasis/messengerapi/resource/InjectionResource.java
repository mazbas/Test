package com.mphasis.messengerapi.resource;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.ws.rs.BeanParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.CookieParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.mphasis.messengerapi.model.ParamBeanFilter;

@Path("inject")
public class InjectionResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("annotations")
	public String getInjectionAnnotations(@BeanParam ParamBeanFilter beanParam) {
	 
	 return "Matrix Param = "+beanParam.getMatrixParam()+
			 "Header Parma value = "+beanParam.getAuthSessionId()+
	 		 "Base URI = "+beanParam.getBaseURI()+
	 		 "CookieParam = " +beanParam.getName();
	 		 
	 		
 }
 
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("annotations2")
	public String getInjectionAnnotations2(@Context HttpHeaders header,@Context UriInfo info) {
    	
    	    // Map<String,List<String>> headers  = header.getRequestHeaders();
    	     
    	    // Collection<List<String>> list = headers.values();
    	    		 
    	//return "All Header Values = " +list;
            String URI= info.getAbsolutePath().toString();
            return "Absolute URI = " +URI;
            
      }
        @POST
        @Produces(MediaType.TEXT_PLAIN)
        @Path("login")
        public String login(@FormParam("username")String username) {
        	
        	return "Hello "	+username;
        }

}
	 

