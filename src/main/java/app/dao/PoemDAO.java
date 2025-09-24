package app.dao;

import app.dtos.PoemDTO;
import app.entities.Poem;
import app.service.Converter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import static java.lang.module.ModuleDescriptor.read;

public class PoemDAO {
    private EntityManagerFactory emf;

    public PoemDAO(EntityManagerFactory emf){
        this.emf = emf;
    }
public Poem createPoem(PoemDTO poem){
        try(EntityManager em = emf.createEntityManager()){
           Poem pEntity = Converter.DtoToEntity(poem);
            em.getTransaction().begin();
            em.persist(pEntity);
            em.getTransaction().commit();
            return pEntity;
        }
}

public PoemDTO findPoemById(int id){
        try(EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            PoemDTO foundPoem = em.find(PoemDTO.class, id);
            em.getTransaction().commit();
            return foundPoem;
        }
}
    public void deletePoem(int id) {
        try(var em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Poem poem = em.find(Poem.class, id);
            if (poem != null) {
                em.remove(poem);
            }
            em.getTransaction().commit();
        }
    }
}
