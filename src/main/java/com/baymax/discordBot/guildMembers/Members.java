package com.baymax.discordBot.guildMembers;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class Members {

    public Members (GuildMessageReceivedEvent event) {
        event
                .getChannel()
                .sendMessage("**There are** " + event.getGuild().getMembers().size() + " **members in this server!**")
                .queue();
    }
}
