package com.samermc9.discordBot.assets;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ImageURL {
    public static List<String> surrealMemes = new ArrayList<String>(Arrays.asList(
            "https://i.redd.it/h99qvvk8hsk01.jpg",
            "https://i.redd.it/t9xy5qyqkpy01.png",
            "https://78.media.tumblr.com/24741e3b6b2defba6d8a037af69febed/tumblr_oyszyc2g1r1wvuif9o1_1280.jpg",
            "https://images7.memedroid.com/images/UPLOADED851/5aeac6577692d.jpeg",
            "https://i.chzbgr.com/full/9031082496/hD3AD1AD0/"));

    public static String getRandomSurrealMemes() {
        Collections.shuffle(surrealMemes);
        return surrealMemes.get(0);
    }

}
