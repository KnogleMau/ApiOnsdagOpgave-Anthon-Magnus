package app.config;

import io.javalin.Javalin;
import io.javalin.config.JavalinConfig;
import app.routes.Routes;

public class ApplicationConfig {
    private static Routes routes = new Routes();

    public static void configuratioin(JavalinConfig config){
        config.showJavalinBanner = false;
        config.bundledPlugins.enableRouteOverview("/routes");
        config.router.contextPath = "/api/v1"; // Base path for all endpoints
        config.router.apiBuilder(routes.getRoutes());
    }
    public static Javalin startServer(int port){
        routes = new Routes();
        var app = Javalin.create(ApplicationConfig::configuratioin);
        app.start(port);
        return app;
    }

    public static void stopServer(Javalin app){
        app.stop();
    }

}