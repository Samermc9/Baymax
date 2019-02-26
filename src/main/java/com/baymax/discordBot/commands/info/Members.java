package com.baymax.discordBot.commands.info;

import com.baymax.discordBot.commands.Commands;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class Members extends Commands
{

    @Override
    public String[] getUsage() {
        return new String[]{"members"};
    }

    @Override
    public String getDescription() {
        return "Returns total amount of members in the guild (regardless of online status)";
    }

    @Override
    public void execute(GuildMessageReceivedEvent event) {
        if (args.length > 1) {
            ARGS_OVER(event);
        }

        event
                .getChannel()
                .sendMessage("**There are** " + event.getGuild().getMembers().size() + " **members in this server!**")
                .queue();
    }

    public Members (GuildMessageReceivedEvent event) {
        super(event);
    }
}
