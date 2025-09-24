package app.entities;

import app.dtos.PoemDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString


@Entity
public class Poem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String lyric;


    public Poem(PoemDTO poemDTO)
    {
        this.id = poemDTO.getId();
        this.lyric = poemDTO.getLyric();
    }
}
