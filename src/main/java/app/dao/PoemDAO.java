package app.dao;

import jakarta.persistence.EntityManagerFactory;

public class PoemDAO {
    private EntityManagerFactory emf;

    public PoemDAO(EntityManagerFactory emf){
        this.emf = emf;
    }

}
