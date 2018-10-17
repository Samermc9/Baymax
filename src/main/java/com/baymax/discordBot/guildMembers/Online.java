package com.baymax.discordBot.guildMembers;

import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class Online {

    public Online (GuildMessageReceivedEvent event) {
        int online = 0;
        for (int i = 0; i < event.getGuild().getMembers().size(); i++) {

            if (event
                    .getGuild()
                    .getMembers()
                    .get(i)
                    .getOnlineStatus() == OnlineStatus.ONLINE) {
                online++;
            }
        }

        event
                .getChannel()
                .sendMessage("**There are " + online + " members online!**")
                .queue();
    }
}
