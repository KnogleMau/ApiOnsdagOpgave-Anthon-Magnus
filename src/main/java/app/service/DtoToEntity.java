package app.service;

import app.dtos.PoemDTO;
import app.entities.Poem;

public class DtoToEntity {


    public Poem DtoToEntity(PoemDTO poemDTO){

        return Poem.builder()
                .id(poemDTO.getId())
                .lyric(poemDTO.getLyric())
                .build();
    }
}
