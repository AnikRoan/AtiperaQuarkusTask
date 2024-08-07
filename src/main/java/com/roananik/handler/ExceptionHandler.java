package com.roananik.handler;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.kohsuke.github.GHFileNotFoundException;

@Provider
public class ExceptionHandler implements ExceptionMapper<GHFileNotFoundException> {

    @Override
    public Response toResponse(GHFileNotFoundException ex) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .status(Response.Status.NOT_FOUND.getStatusCode())
                .message(ex.getMessage())
                .build();
        return Response.status(Response.Status.NOT_FOUND).entity(errorResponse).build();
    }
}
