package com.baymax.discordBot.commands;

import com.baymax.discordBot.message.EmbedMessage;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.awt.*;

public class Info {
    public Info (GuildMessageReceivedEvent event) {
        event
                .getChannel()
                .sendMessage(EmbedMessage.embedMessage("Bot Info",
                        "**Total commands : **" + CommandsList.getLength() + "\n**Date of" +
                                " creation:** 24 August 2018\n**Prefix used: '&'**\n**Still under development... baYMax Is ComInG**",
                        new Color(230, 0, 50),
                        "Created by @Albus and @Samermc9", null).build())
                .queue();
    }
}
