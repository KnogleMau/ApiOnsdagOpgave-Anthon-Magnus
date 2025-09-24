package app.dao;

import app.dtos.PoemDTO;
import app.entities.Poem;
import app.service.Converter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

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
            Poem poem = em.find(Poem.class, id);
            if (poem != null) {
                return new PoemDTO(poem);
            } else {
                return null;
            }
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

    public List<PoemDTO> getAllPoems(){
        try (var em = emf.createEntityManager()) {
            TypedQuery<Poem> query = em.createQuery("SELECT p FROM Poem p", Poem.class);
            List<Poem> poems = query.getResultList();
            return PoemDTO.toDTOList(poems);
        }
    }
}
