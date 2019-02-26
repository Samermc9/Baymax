package com.baymax.discordBot.commands.info;

import com.baymax.discordBot.commands.Commands;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class Online extends Commands {

    @Override
    public String[] getUsage() {
        return new String[]{"online"};
    }

    @Override
    public String getDescription() {
        return "Returns the total amount of members in the guild based on online status (DnD or Online only)";
    }

    @Override
    public void execute(GuildMessageReceivedEvent event) {
        int online = 0;
        for (int i = 0; i < event.getGuild().getMembers().size(); i++) {

            if (event

                    .getGuild()
                    .getMembers()
                    .get(i)
                    .getOnlineStatus() == OnlineStatus.ONLINE ||

                    event
                            .getGuild()
                            .getMembers()
                            .get(i)
                            .getOnlineStatus() == OnlineStatus.DO_NOT_DISTURB) {

                online++;
            }
        }

        event
                .getChannel()
                .sendMessage("**There are " + online + " members online!**")
                .queue();
    }

    public Online(GuildMessageReceivedEvent event) {
        super(event);
    }
}
