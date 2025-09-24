package app;

import app.config.ApplicationConfig;
import app.dtos.PoemDTO;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        PoemDTO p1 = new PoemDTO();
        p1.setId(1);
        p1.setLyric("You and me alone\n" +
                "Madness of world locked away\n" +
                "Peace and quiet reigns\n");

        PoemDTO p2 = new PoemDTO();
        p1.setId(2);
        p1.setLyric("Aching heart and mind\n" +
                "Needs touch of a caring soul\n" +
                "Yearning company.\n");

        PoemDTO p3 = new PoemDTO();
        p1.setId(3);
        p1.setLyric("JANUARY\n" +
                "Delightful display\n" +
                "Snowdrops bow their pure white heads\n" +
                "To the sun's glory.\n");

        PoemDTO p4 = new PoemDTO();
        p1.setId(4);
        p1.setLyric("Mellow, mild, May day,\n" +
                "calling children out to play.\n" +
                "Summer's on her way!\n");

        PoemDTO p5 = new PoemDTO();
        p1.setId(5);
        p1.setLyric("Like crunchy cornflakes\n" +
                "Gold leaves rustle underfoot\n" +
                "Beauty in decay.\n");

        PoemDTO p6 = new PoemDTO();
        p1.setId(6);
        p1.setLyric("Strokes of affection\n" +
                "Light and tenderly expressed\n" +
                "Keep love’s bonds so strong.\n");

        PoemDTO p7 = new PoemDTO();
        p1.setId(7);
        p1.setLyric("Yellow flame flickers\n" +
                "Shadows dance upon the wall\n" +
                "Love grows ever strong.\n");

        ApplicationConfig.startServer(7076);

    }
}