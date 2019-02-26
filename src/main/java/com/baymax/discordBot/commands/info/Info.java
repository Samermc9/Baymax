package com.baymax.discordBot.commands.info;

import com.baymax.discordBot.commands.Commands;
import com.baymax.discordBot.message.EmbedMessage;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.awt.*;

public class Info extends Commands {
    @Override
    public String[] getUsage() {
        return new String[]{
                "info"
        };
    }

    @Override
    public String getDescription() {
        return "Sends general information about the bot";
    }

    @Override
    public void execute(GuildMessageReceivedEvent event) {
        if (args.length > 1) {
            ARGS_OVER(event);
        }

        else {

            event
                    .getChannel()
                    .sendMessage(EmbedMessage.create("Bot Info",
                            "**Total commands : **" + Commands.getTotalLength() + "\n**Date of" +
                                    " creation:** 24 August 2018\n**Prefix used: '&'**\n**Still under development... baYMax Is ComInG**",
                            new Color(230, 0, 50),
                            "Created by @Albus and @Samermc9", null, null).build())
                    .queue();
        }
    }

    public Info (GuildMessageReceivedEvent event) {
       super(event);
    }
}
