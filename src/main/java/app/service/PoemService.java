package app.service;

import app.dtos.LimerickDTO;
import app.dtos.PoemDTO;
import app.dtos.PoemResponseDTO;
import app.entities.Poem;
import app.services.ApiService;

import java.util.List;

public class PoemService {

    ApiService api = new ApiService();
    Converter converter = new Converter();

    public LimerickDTO getPoemsApi(String url){
        return api.fetchData(url, LimerickDTO.class);
    }

    public Poem convertToEntities(String url){
        LimerickDTO limerickDTO = getPoemsApi(url);
        if(limerickDTO == null){
            System.out.println("Fejl, ingen data");
        }
        return converter.LimerickDtoToEntity(limerickDTO);
    }


}
