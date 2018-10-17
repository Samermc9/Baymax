package com.baymax.discordBot.commands;

import com.baymax.discordBot.message.EmbedMessage;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.awt.*;

public class Help {
    public Help (GuildMessageReceivedEvent event) {
        event
                .getChannel()
                .sendMessage(EmbedMessage.embedMessage("Help Commands",
                        "List of commands available:\n" + "```" + CommandsList.getCommands() + "```",
                        new Color(230, 0, 50),
                        "Use all commmands with prefix '&'",
                        null)
                        .build())
                .queue();
    }
}
