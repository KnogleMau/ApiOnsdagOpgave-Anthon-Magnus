package app.routes;

import app.controllers.PoemController;
import io.javalin.apibuilder.EndpointGroup;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.post;

public class PoemRoutes {
PoemController poemController = new PoemController();

    public EndpointGroup getRoutes(){
        return () -> {
          get("/", poemController::findPoem);
          post("/", poemController::createPoem);
        };
    }
}
