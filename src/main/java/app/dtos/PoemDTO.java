package app.dtos;

import app.entities.Poem;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

@JsonIgnoreProperties(ignoreUnknown = true)
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


