package app.dtos;

import app.entities.Poem;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class PoemDTO {
    private int id;
    private String lyric;



    public PoemDTO(Poem poem) {
        this.id = poem.getId();
        this.lyric = poem.getLyric();
    }

    public static List<PoemDTO> toDTOList(List<Poem> resultList) {
        return resultList.stream().map(PoemDTO::new).toList();
    }
}


