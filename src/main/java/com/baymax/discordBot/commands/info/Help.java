package com.baymax.discordBot.commands.info;

import com.baymax.discordBot.commands.Commands;
import com.baymax.discordBot.commands.fun.Dab;
import com.baymax.discordBot.handlers.CommandHandler;
import com.baymax.discordBot.message.EmbedMessage;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.awt.*;

public class Help extends Commands {
    @Override
    public String[] getUsage() {
        return new String[] {
                "help",
                "help <command>"};
    }

    @Override
    public String getDescription() {
        return "Returns the list of user commands and developer only commands, if command is specified - returns help and information for the given command";
    }

    @Override
    public void execute(GuildMessageReceivedEvent event) {
        if (args.length == 1) {
            event
                    .getChannel()
                    .sendMessage(EmbedMessage.create("Help Commands",
                            "List of commands available:" + "```User commands : " +
                                    Commands.getUserCommands() + "\n\nDeveloper commands : " + Commands.getDevCommands() + "```",
                            new Color(230, 0, 50),
                            "Use all commands with prefix '&'",
                            null, null)
                            .build())
                    .queue();
        }

        else if (args.length == 2) {
            //call getDescription() and getUsage() on args[1] command
        }
    }

    public Help (GuildMessageReceivedEvent event) {
        super(event);
    }
}
