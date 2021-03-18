/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import dtos.RenameMeDTO;
import dtos.RunnerDTO;
import entities.RenameMeRepository;
import entities.Runner;
import entities.RunnerRepository;
import facades.FacadeExample;
import facades.FacadeRunner;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import rest.provider.Provider;

/**
 * REST Web Service
 *
 * @author PC
 */
@Path("runner")
public class RunnerResource extends Provider{

private final RunnerRepository REPO = FacadeRunner.getInstance(EMF);

    /**
     * Creates a new instance of RunnerResource
     */
    public RunnerResource() {
    }

    /**
     * Retrieves representation of an instance of rest.RunnerResource
     * @return an instance of java.lang.String
     */
   

    @Override
    public Response getAll() {
         List<RunnerDTO> runnerDTO = REPO.getAll();
        return Response.ok(GSON.toJson(runnerDTO)).build();
    }

    @Override
    public Response getById(int id) {
        RunnerDTO runnerDTO=REPO.getById(id);
        return Response.ok(GSON.toJson(runnerDTO)).build();
    }

    @Override
    public Response create(String requestBody) {
        Runner parsedBody = GSON.fromJson(requestBody, Runner.class);
        RunnerDTO createdRunnerDTO = REPO.create(new RunnerDTO(parsedBody));
        return Response.ok(GSON.toJson(createdRunnerDTO)).build();
    }

    @Override
    public Response update(int id, String requestBody) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
