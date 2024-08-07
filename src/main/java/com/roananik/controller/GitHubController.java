package com.roananik.controller;
import com.roananik.service.GitHubService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.kohsuke.github.GHFileNotFoundException;

@Path("/api/v1/github")
public class GitHubController {

    @Inject
    GitHubService gitHubService;

    @GET
    @Path("/repositories/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRepositories(@PathParam("name") String name,
                                    @HeaderParam("Accept") String accept) throws GHFileNotFoundException {
        if (!"application/json".equals(accept)) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
        return Response.ok(gitHubService.getRepositories(name)).build();
    }
}
