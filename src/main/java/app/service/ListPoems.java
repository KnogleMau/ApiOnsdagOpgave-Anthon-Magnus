package app.service;

import app.dtos.PoemDTO;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ListPoems {

    public List<PoemDTO> poemDTOList = new ArrayList<>();
    {
    PoemDTO p1 = PoemDTO.builder()
            .lyric("You and me alone\n" +
                    "Madness of world locked away\n" +
                    "Peace and quiet reigns\n")
            .build();

    PoemDTO p2 = PoemDTO.builder()
            .lyric("Aching heart and mind\n" +
                    "Needs touch of a caring soul\n" +
                    "Yearning company.\n")
            .build();

    PoemDTO p3 = PoemDTO.builder()
            .lyric("JANUARY\n" +
                    "Delightful display\n" +
                    "Snowdrops bow their pure white heads\n" +
                    "To the sun's glory.\n")
            .build();

    PoemDTO p4 = PoemDTO.builder()
            .lyric("Mellow, mild, May day,\n" +
                    "calling children out to play.\n" +
                    "Summer's on her way!\n")
            .build();

    PoemDTO p5 = PoemDTO.builder()
            .lyric("Like crunchy cornflakes\n" +
                    "Gold leaves rustle underfoot\n" +
                    "Beauty in decay.\n")
            .build();

    PoemDTO p6 = PoemDTO.builder()
            .lyric("Strokes of affection\n" +
                    "Light and tenderly expressed\n" +
                    "Keep love’s bonds so strong.\n")
            .build();

    PoemDTO p7 = PoemDTO.builder()
            .lyric("Yellow flame flickers\n" +
                    "Shadows dance upon the wall\n" +
                    "Love grows ever strong.\n")
            .build();

    poemDTOList.add(p1);
    poemDTOList.add(p2);
    poemDTOList.add(p3);
    poemDTOList.add(p4);
    poemDTOList.add(p5);
    poemDTOList.add(p6);
    poemDTOList.add(p7);
    }
}
