package com.samermc9.discordBot.assets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GifURL {
    public static final String SLAP1 = "https://giphy.com/gifs/slap-kimchi-13dRJkj5wgKq9q";
    public static final String SLAP2 = "http://78.media.tumblr.com/tumblr_m1nsxc3jUu1qdjfd8o1_400.gif";
    public static final String SLAP3 = "https://www.deviantart.com/paranoxias/art/Golden-Time-Flower-Slap-gif-417991111";

    public static List<String> list = new ArrayList<String>(Arrays.asList(SLAP1, SLAP2, SLAP3));

    public static final String HUG1 = "https://cdn.discordapp.com/attachments/386194586285899781/483310567944355870/image0.gif";

    public static String getRndmSlap() {
        Collections.shuffle(list);

        return list.get(0);
    }
}
