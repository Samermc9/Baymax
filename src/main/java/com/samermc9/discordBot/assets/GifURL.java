package com.samermc9.discordBot.assets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GifURL {
    public static final String SLAP1 = "https://giphy.com/gifs/slap-kimchi-13dRJkj5wgKq9q";
    public static final String SLAP2 = "http://78.media.tumblr.com/tumblr_m1nsxc3jUu1qdjfd8o1_400.gif";
    public static final String SLAP3 = "https://www.deviantart.com/paranoxias/art/Golden-Time-Flower-Slap-gif-417991111";

    public static List<String> slapList = new ArrayList<String>(Arrays.asList(SLAP1, SLAP2, SLAP3));

    public static final String HUG1 = "https://cdn.discordapp.com/attachments/386194586285899781/483310567944355870/image0.gif";
    public static final String HUG2 = "";
    public static final String HUG3 = "";

    private static List<String> hugList = new ArrayList<String>(Arrays.asList(HUG1, HUG2, HUG3));

    public static final String KILL1 = "https://im.ziffdavisinternational.com/ign_br/screenshot/default/tumblr-lvuou1kmwj1qgcvsy_f8xm.gif";
    public static final String KILL2 = "http://gifimage.net/wp-content/uploads/2017/09/anime-kill-gif.gif";
    public static final String KILL3 = "https://cdn.discordapp.com/attachments/386194586285899781/483310567944355870/image0.gif";

    private static List<String> killList = new ArrayList<String>(Arrays.asList(KILL1, KILL2, KILL3));


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
