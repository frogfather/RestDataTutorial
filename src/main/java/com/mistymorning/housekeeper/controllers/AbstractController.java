package com.mistymorning.housekeeper.controllers;

import javax.validation.constraints.NotNull;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;



public abstract class AbstractController {
	
	final ObjectMapper objectMapper = new ObjectMapper();

	    protected Response buildResponse(@NotNull Boolean success, @NotNull Object payload) {
	        try {
	        	
	            return Response.ok(objectMapper.writeValueAsString(ImmutableMap.of(
	                    "success", success,
	                    "result", payload
	            ))).build();
	        } catch (JsonProcessingException e) {
	            throw new RuntimeException(e);
	        }
	    }

	    protected Response notAuthorisedResponse() {
	        return Response.status(Response.Status.FORBIDDEN)
	                .entity(ImmutableMap.of(
	                        "status", false,
	                        "result", "You are not authorized to query this resource"))
	                .build();
	    }

	    protected Response notFoundResponse(String result) {
	        return Response.status(Response.Status.NOT_FOUND)
	                .entity(ImmutableMap.of("status", false,"result", result))
	                .build();
	    }
	
}
