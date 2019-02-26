package com.baymax.discordBot.commands.info;

import com.baymax.discordBot.commands.Commands;
import com.baymax.discordBot.message.EmbedMessage;
import net.dv8tion.jda.client.entities.Application;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Invite extends Commands {
    @Override
    public String[] getUsage() {
        return new String[]{
                "invite"
        };
    }

    @Override
    public String getDescription() {
        return "Generates an invite link to the channel where it was called (Expires in 5 minutes and is one time use only)";
    }

    @Override
    public void execute(GuildMessageReceivedEvent event) {
        String link = event
                .getChannel()
                .createInvite()
                .setMaxAge((long) 5, TimeUnit.MINUTES)
                .setTemporary(true)
                .complete()
                .toString()
                .replace("Invite", "")
                .replace("(", "")
                .replace(")", "");
        event
                .getChannel()
                .sendMessage(
                        EmbedMessage.create("**Guild invite!**",
                                "https://discord.gg/" + link + "\n```Copy and use this link to invite members to this channel!```", new Color(211, 255, 86),
                                "Expires in 5 minutes and is for single use only",
                                "https://cdn.discordapp.com/avatars/481780525099646977/fa4749b2147b0375033283f75184a151.webp?size=256", null
                        ).build())
                .queue();
    }

    public Invite (GuildMessageReceivedEvent event) {
       super(event);
    }
}
