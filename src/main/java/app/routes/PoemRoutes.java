package app.routes;

import app.controllers.PoemController;
import io.javalin.apibuilder.EndpointGroup;

import static io.javalin.apibuilder.ApiBuilder.*;

public class PoemRoutes {
PoemController poemController = new PoemController();

    public EndpointGroup getRoutes(){
        return () -> {

          get("/", poemController::getAllPoems);
          get("/{id}", poemController::findPoem);
          post("/", poemController::createPoem);
          delete("/{id}", poemController::deletePoem);
          put("/{id}", poemController::updatePoem);

        };
    }
}
