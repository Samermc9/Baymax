package com.baymax.discordBot.handlers;

import com.baymax.discordBot.commands.info.HelpDirect;
import net.dv8tion.jda.core.events.ExceptionEvent;
import net.dv8tion.jda.core.events.ShutdownEvent;
import net.dv8tion.jda.core.events.guild.GuildJoinEvent;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.events.user.UserTypingEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.Objects;

public class EventHandler extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived (GuildMessageReceivedEvent event) {
        new CommandHandler(event);
    }

    @Override
    public void onGuildMemberJoin (GuildMemberJoinEvent event) {
        new HelpDirect(event.getUser());
    }

    @Override
    public void onGuildJoin (GuildJoinEvent event) {
            Objects.requireNonNull(event
                    .getGuild()
                    .getDefaultChannel())
                    .sendMessage("Yasssssss thank you for adding me yasssss")
                    .queue();
    }

    @Override
    public void onShutdown (ShutdownEvent event) {
        System.out.println("Forced shut down at " + event.getShutdownTime());
    }
}
