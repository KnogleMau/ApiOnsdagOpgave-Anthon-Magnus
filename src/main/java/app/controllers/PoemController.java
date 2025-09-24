package app.controllers;

import app.config.HibernateConfig;
import app.dao.PoemDAO;
import app.dtos.PoemDTO;
import app.entities.Poem;
import app.service.PoemService;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import jakarta.persistence.EntityManagerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PoemController {
    private final EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();

    PoemService ps = new PoemService();
    PoemDAO poemDAO = new PoemDAO(emf);

    private static final Logger logger = LoggerFactory.getLogger(PoemController.class);
    private static final Logger debugLogger = LoggerFactory.getLogger("app");

    public void getAllPoems(Context ctx){
        List<PoemDTO> poemDTOs = poemDAO.getAllPoems();
        ctx.status(HttpStatus.OK);
        ctx.json(poemDTOs);
        logger.info("Fetched all highscores, count: " + poemDTOs.size());
    }


public void createPoem(Context ctx){
    PoemDTO poemDTO = ctx.bodyAsClass(PoemDTO.class);

    Poem newPoem = poemDAO.createPoemFromDTO(poemDTO);
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

public void updatePoem(Context ctx){
int id = Integer.parseInt(ctx.pathParam("id"));
PoemDTO poemDTO = ctx.bodyAsClass(PoemDTO.class);
poemDTO = poemDAO.updatePoem(id,poemDTO);
ctx.status(HttpStatus.OK);
ctx.json(poemDTO);
}

public void deletePoem(Context ctx){
int id = Integer.parseInt(ctx.pathParam("id"));
poemDAO.deletePoem(id);
ctx.result("Highscore with id " + id + " deleted");
}

public void createIntialLoadData(List<PoemDTO>poemList){
    for(PoemDTO poemDTO : poemList){
        poemDAO.createPoemFromDTO(poemDTO);
    }
}
public void getDataFromApi(String url){
        List<Poem> poemList = ps.convertToEntities(url);
        for(Poem poem : poemList){
            poemDAO.createPoem(poem);
        }
    }



}
