package com.baymax.discordBot.commands.general;

import com.baymax.discordBot.commands.Commands;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class Ban extends Commands {

    @Override
    public String[] getUsage() {
        return new String[] {
                "ban <user> <amount_of_days> <reason>"
        };
    }

    @Override
    public String getDescription() {
        return "Bans specified user from the guild for a set amount of days.";
    }

    @Override
    public void execute(GuildMessageReceivedEvent event) {
        if (args.length < 4) {
            ARGS_UNDER(event);
        }

        else if (!event.getMember().hasPermission(Permission.BAN_MEMBERS)) {
            INSUFFICIENT_PERMS(event);
        }

        else {
            event
                    .getGuild()
                    .getController()
                    .ban(event.getMessage().getMentionedMembers().get(0), Integer.parseInt(args[2]))
                    .reason(args[3])
                    .complete();
        }
    }

    public Ban (GuildMessageReceivedEvent event) {
        super(event);
    }
}
