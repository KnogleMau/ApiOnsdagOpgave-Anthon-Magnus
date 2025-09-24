package app.service;

import app.dtos.PoemDTO;
import app.entities.Poem;

public class Converter {


    public static Poem DtoToEntity(PoemDTO poemDTO){

        return Poem.builder()
                .lyric(poemDTO.getLyric())
                .build();
    }
}
