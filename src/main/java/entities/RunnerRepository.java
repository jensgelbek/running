/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import dtos.RunnerDTO;
import java.util.List;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author PC
 */
public interface RunnerRepository {
 RunnerDTO create(RunnerDTO rm) throws WebApplicationException;

    RunnerDTO getById(long id) throws WebApplicationException;

    long getRunnerCount() throws WebApplicationException;

    List<RunnerDTO> getAll() throws  WebApplicationException;
}

