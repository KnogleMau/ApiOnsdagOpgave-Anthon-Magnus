package app.routes;


import io.javalin.apibuilder.EndpointGroup;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;

public class Routes {
PoemRoutes poemRoutes = new PoemRoutes();
    public EndpointGroup getRoutes(){

        return () -> {
          get("/", ctx -> ctx.result("Hello World"));
          path("/poem", poemRoutes.getRoutes());
        };
    }
}
