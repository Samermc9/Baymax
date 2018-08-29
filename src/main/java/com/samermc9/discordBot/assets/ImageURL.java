package com.samermc9.discordBot.assets;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ImageURL {
    public static List<String> surrealMemes = new ArrayList<String>(Arrays.asList("", "", "", "", "", "", ""));


    public static String getRandomSurrealMemes() {
        Collections.shuffle(surrealMemes);
        return surrealMemes.get(0);
    }

}
