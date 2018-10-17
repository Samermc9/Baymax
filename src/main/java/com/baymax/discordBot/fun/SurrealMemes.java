package com.baymax.discordBot.fun;

import com.baymax.discordBot.assets.ImageURL;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class SurrealMemes {
    public SurrealMemes (GuildMessageReceivedEvent event) {
        String surrealmeme = ImageURL.getRandomSurrealMemes();
        event
                .getChannel()
                .sendMessage(surrealmeme)
                .queue();
    }
}
