package app.controllers;

import app.config.HibernateConfig;
import app.dao.PoemDAO;
import app.dtos.PoemDTO;
import app.entities.Poem;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import jakarta.persistence.EntityManagerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PoemController {
    private final EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();

    PoemDAO poemDAO = new PoemDAO(emf);

    private static final Logger logger = LoggerFactory.getLogger(PoemController.class);
    private static final Logger debugLogger = LoggerFactory.getLogger("app");


public void createPoem(Context ctx){
    PoemDTO poemDTO = ctx.bodyAsClass(PoemDTO.class);

    Poem newPoem = poemDAO.createPoem(poemDTO);
    ctx.status(HttpStatus.OK);
    ctx.json(newPoem);
}

public void findPoem(Context ctx){
    int id = Integer.parseInt(ctx.pathParam("id"));
    PoemDTO poemDTO = poemDAO.findPoemById(id);
    if (poemDTO != null) {
        ctx.status(HttpStatus.OK);
        ctx.json(poemDTO);
        logger.info("Fetched poems with id: " + id);
    } else {
        ctx.status(HttpStatus.NOT_FOUND);
        ctx.result("poem not found");
        logger.warn("poem with id " + id + " not found");
    }

}

public void deletePoem(Context ctx){

}



}
