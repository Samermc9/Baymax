package com.samermc9.discordBot.assets;


import java.util.*;

public class ImageURL {
    private static Random random = new Random();
    public static List<String> surrealMemes = new ArrayList<String>(Arrays.asList(
            "https://i.redd.it/h99qvvk8hsk01.jpg",
            "https://i.redd.it/t9xy5qyqkpy01.png",
            "https://78.media.tumblr.com/24741e3b6b2defba6d8a037af69febed/tumblr_oyszyc2g1r1wvuif9o1_1280.jpg",
            "https://images7.memedroid.com/images/UPLOADED851/5aeac6577692d.jpeg",
            "https://i.chzbgr.com/full/9031082496/hD3AD1AD0/",
            "https://i.chzbgr.com/full/9031087360/h93A92E0C/",
            "https://i.chzbgr.com/full/9031103232/hDE1E675A/",
            "https://78.media.tumblr.com/9f19910f01b8c7ada73a45819fd093c2/tumblr_oy8razxO8E1wvuif9o1_1280.png",
            "https://cdn130.picsart.com/266717044028201.jpg?r1024x1024",
            "https://pbs.twimg.com/media/DXgMXPuVQAA-Qv4.jpg:large",
            "https://pics.me.me/is-this-a-surreal-meme-%3Cp%3E-%3Ca-href-https-www-reddit-com-r-surrealmemes-comments-8je8eu-the-inspectors-are-pondering-our-values-%3Esrc%3C-a%3E-%3C-p%3E-33027917.png",
            "https://i.imgur.com/ai9Ve2d.jpg",
            "https://i.redd.it/1xofgfuon3jz.jpg",
            "https://i.pinimg.com/236x/4e/5e/bd/4e5ebdea14e8f5ac582d3acc395aba34.jpg",
            "https://i.pinimg.com/736x/8f/c8/01/8fc8010241f537a242ddb91d35dee1ad.jpg",
            "https://78.media.tumblr.com/c276d90fd0627ba86584c42792404073/tumblr_ov1nreuLA61wvuif9o1_1280.png",
            "https://i.kym-cdn.com/photos/images/newsfeed/001/247/636/52c.png",
            "https://i.pinimg.com/originals/a1/24/dd/a124dde95693a9d7b7ae6ccae10c18c4.png",
            "https://i.pinimg.com/236x/9c/46/57/9c46570c9df57fef15184a81cd4dfcf0.jpg",
            "http://dailylolpics.lolpics.com/wp-content/uploads/2017/12/orang.jpg"
            ));



    public static List<String> robloxMemes = new ArrayList<String>(Arrays.asList(
            "https://i.kym-cdn.com/photos/images/original/001/342/713/3df.png",
            "https://scontent-lhr3-1.cdninstagram.com/vp/f2122a9a9c9627ec49b578f7cc51b9ee/5C02AB34/t51.2885-15/e35/36148834_497894390667924_2744019657265512448_n.jpg?ig_cache_key=MTgyMjE2Nzc3MTk5NjY5MTk4OQ%3D%3D.2",
            "https://i.imgur.com/GUhWI2j.png",
            "https://forum.vashta.io/uploads/default/original/2X/c/c84b5c94be89e16e9f6eb20cf1de16a0bb8ee36c.jpg",
            "http://gathrnews.com/wp-content/uploads/2018/06/unique-dank-meme-compilation-just-a-random-roblox-meme-pilation-pls-dont-be-offended-this-is.jpg",
            "https://vignette.wikia.nocookie.net/rgocommitdie-l-o-r-e/images/1/1e/W9whkx9ein911.png/revision/latest?cb=20180713151137",
            "https://scontent-a-sea.cdninstagram.com/vp/84ca1e15ad06d13c6bcbc3dda21b7941/5BF8D5B2/t51.2885-15/sh0.08/e35/c38.0.643.643/s640x640/39134868_234309807186912_4776380194409676800_n.jpg",
            "https://scontent.cdninstagram.com/vp/7f634fa6e79642364f95e56fe88a4b61/5C0282A1/t51.2885-15/e35/38868635_457606458055459_658755435251105792_n.jpg",
            "https://scontent.cdninstagram.com/vp/b77b8f363d44a5721a04dcc15b7c0da9/5C1A77F3/t51.2885-15/e35/37963400_255158148653877_1927794941233201152_n.jpg",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSjYrAyi8-feJmSfLmdNI1iHO36-yv2jhY98q5n4OYasoY66kokhA",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4hTPate-3Dh6wPGqJiKH7e3jza58trUGaXqmt70zqziBIp7YmyA",
            "https://scontent.cdninstagram.com/vp/c1f943cb89a0e97c18c41e7f0ab77c7e/5BD65ED8/t51.2885-15/sh0.08/e35/s640x640/37123350_188701902002514_4009688301115015168_n.jpg"
    ));

    public static String getRandomSurrealMemes() {
        int randomIndex = random.nextInt(surrealMemes.size());
        Collections.shuffle(surrealMemes);
        return surrealMemes.get(randomIndex);
    }

    public static String getRobloxMemes() {
        int randomIndex = random.nextInt(robloxMemes.size());
        Collections.shuffle(robloxMemes);
        return robloxMemes.get(randomIndex);
    }

}
