package app;

import app.config.ApplicationConfig;
import app.controllers.PoemController;
import app.dtos.PoemDTO;
import app.entities.Poem;
import app.service.ListPoems;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
PoemController poemC = new PoemController();
        ListPoems p = new ListPoems();
        String url = "5.179.80.205:7007/api/v1/poem";

        System.out.println("Beer Demo");
        ApplicationConfig.startServer(7076);
        poemC.createIntialLoadData(p.getPoemDTOList());
        poemC.getDataFromApi(url);


    }
}