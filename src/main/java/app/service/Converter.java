package app.service;

import app.dtos.PoemDTO;
import app.dtos.PoemResponseDTO;
import app.entities.Poem;

import java.util.List;
import java.util.stream.Collectors;

public class Converter {


    public Poem DtoToEntity(PoemDTO poemDTO){

        return Poem.builder()
                .lyric(poemDTO.getLyric())
                .build();
    }

    public List<Poem> convertToEntities(PoemResponseDTO poemResponseDTO) {

        List<PoemDTO> poemListDTO = poemResponseDTO.getPoemDTOList();

        return poemListDTO.stream()
                .map(this::DtoToEntity)
                .collect(Collectors.toList());
    }
}
