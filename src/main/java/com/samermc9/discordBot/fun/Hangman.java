package com.samermc9.discordBot.fun;

import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.*;
public class Hangman extends ListenerAdapter {

    private static String underscore = "-";

    private static Random random = new Random();
    private static List<String> words = new ArrayList<>(Arrays.asList(
            "dog",
            "cat",
            "horse",
            "frog",
            "hat",
            "door",
            "bag",
            "pencil",
            "eraser",
            "marker",
            "drawing",
            "painting"));



    public static String changeToBlank(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(underscore);
        }

        return sb.toString();
    }




    public static String getWord() {
        Collections.shuffle(words);
        int randomIndex = random.nextInt(words.size());
        return words.get(randomIndex);
    }
}
