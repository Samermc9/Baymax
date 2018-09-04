package com.samermc9.discordBot.assets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GifURL {
    public static final String kimchiSlap = "https://giphy.com/gifs/slap-kimchi-13dRJkj5wgKq9q";

    private static List<String> slapList = new ArrayList<String>(Arrays.asList(kimchiSlap,
            "http://78.media.tumblr.com/tumblr_m1nsxc3jUu1qdjfd8o1_400.gif",
            "http://gifimage.net/wp-content/uploads/2017/07/anime-slap-gif-12.gif",
            "https://i.kym-cdn.com/photos/images/original/001/264/655/379.gif"
            ));

    private static List<String> hugList = new ArrayList<String>(Arrays.asList(
            "https://cdn.discordapp.com/attachments/386194586285899781/483310567944355870/image0.gif",
            "https://cdn.discordapp.com/attachments/386194586285899781/483310567944355870/image0.gif",
            "https://cdn.discordapp.com/attachments/386194586285899781/483310567944355870/image0.gif"));


    private static List<String> killList = new ArrayList<String>(Arrays.asList(
            "https://im.ziffdavisinternational.com/ign_br/screenshot/default/tumblr-lvuou1kmwj1qgcvsy_f8xm.gif",
            "http://gifimage.net/wp-content/uploads/2017/09/anime-kill-gif.gif",
            "https://cdn.discordapp.com/attachments/386194586285899781/483310567944355870/image0.gif"));


    public static String getRandomSlap() {
        Collections.shuffle(slapList);

        return slapList.get(0);
    }

    public static String getRandomHug() {
        Collections.shuffle(hugList);

        return hugList.get(0);
    }

    public static String getRandomKill() {
        Collections.shuffle(killList);

        return killList.get(0);
    }
}
