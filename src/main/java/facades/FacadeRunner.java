/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.RunnerDTO;
import entities.Runner;
import entities.RunnerRepository;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author PC
 */
public class FacadeRunner implements RunnerRepository{
    private static FacadeRunner instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private FacadeRunner() {
    }


    /**
     * @param _emf
     * @return an instance of this repository class.
     */
    public static FacadeRunner getInstance(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new FacadeRunner();
        }
        return instance;
    }
    @Override
    public RunnerDTO create(RunnerDTO r) throws WebApplicationException {
        EntityManager em = emf.createEntityManager();
        Runner runner = new Runner(r.getName(), r.getGender(), r.getbDay());
        try {
            em.getTransaction().begin();
            em.persist(runner);
            em.getTransaction().commit();
            
        } finally {
            em.close();
        }
        
        return new RunnerDTO(runner);
        
    }

    @Override
    public RunnerDTO getById(long id) throws WebApplicationException {
                EntityManager em = emf.createEntityManager();
                return new RunnerDTO(em.find((Runner.class), id));
    }

    @Override
    public long getRunnerCount() throws WebApplicationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RunnerDTO> getAll() throws WebApplicationException {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Runner> query = em.createQuery("SELECT r FROM Runner r", Runner.class);
        List<Runner> rs = query.getResultList();
        return RunnerDTO.getRunnerList(rs);
    }
 }
    

