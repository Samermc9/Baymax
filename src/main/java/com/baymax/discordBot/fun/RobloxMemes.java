package com.baymax.discordBot.fun;

import com.baymax.discordBot.assets.ImageURL;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class RobloxMemes {
    public RobloxMemes (GuildMessageReceivedEvent event) {
        String robloxmeme = ImageURL.getRobloxMemes();
        event
                .getChannel()
                .sendMessage(robloxmeme)
                .queue();
    }
}
