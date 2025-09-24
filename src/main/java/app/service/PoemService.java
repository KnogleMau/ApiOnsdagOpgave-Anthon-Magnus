package app.service;

import app.dtos.PoemDTO;
import app.dtos.PoemResponseDTO;
import app.entities.Poem;
import app.services.ApiService;

import java.util.List;

public class PoemService {

    ApiService api = new ApiService();
    Converter converter = new Converter();

    public PoemResponseDTO getPoemsApi(String url){
        return api.fetchData(url, PoemResponseDTO.class);
    }

    public List<Poem> convertToEntities(String url){
        PoemResponseDTO responseDTO = getPoemsApi(url);
        if(responseDTO == null){
            System.out.println("Fejl, ingen data");
        }
        return converter.convertToEntities(responseDTO);
    }


}
