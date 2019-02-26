package com.baymax.discordBot.devUtils;
import com.baymax.discordBot.handlers.CommandHandler;
import com.baymax.discordBot.handlers.EventHandler;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import java.time.format.DateTimeFormatter;

public class ConsoleLog {

    public ConsoleLog(GuildMessageReceivedEvent event) {
        if (CommandHandler.args[0].charAt(0) == '&') {
            System.out.println("Command [" +
                    CommandHandler.args[0] + "]" + " used by [" +

                    event
                            .getMessage()
                            .getAuthor() + "]" + " at server " +

                    event
                            .getGuild() + " at channel [" +

                    event
                            .getChannel()
                            .getId() + "]" + " at " +

                    event
                            .getMessage()
                            .getCreationTime().format(DateTimeFormatter.RFC_1123_DATE_TIME));
        }
    }
}
