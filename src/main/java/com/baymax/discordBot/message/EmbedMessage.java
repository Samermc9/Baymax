package com.baymax.discordBot.message;

import net.dv8tion.jda.core.EmbedBuilder;

import java.awt.*;

public class EmbedMessage {
    public static EmbedBuilder create (String title, String description, Color color, String footer, String thumbnailURL, String imageURL) {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder
                .setTitle(title)
                .setColor(color)
                .setFooter(footer, null)
                .setThumbnail(thumbnailURL)
                .setImage(imageURL)
                .setDescription(description);


        return embedBuilder;
    }
}
