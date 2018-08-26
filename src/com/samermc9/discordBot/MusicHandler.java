package com.samermc9.discordBot;

import net.dv8tion.jda.core.entities.Channel;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class MusicHandler extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived (GuildMessageReceivedEvent event) {
        event
                .getGuild()
                .getVoiceChannelById("");
    }
}
