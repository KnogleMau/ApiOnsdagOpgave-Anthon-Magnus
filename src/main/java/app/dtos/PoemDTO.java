package app.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class PoemDTO {
    private int id;
    private String lyric;
}
