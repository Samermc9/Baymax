package com.baymax.discordBot.commands.general;

import com.baymax.discordBot.commands.Commands;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.HierarchyException;
import net.dv8tion.jda.core.utils.PermissionUtil;
import sun.plugin.dom.exception.HierarchyRequestException;

public class Kick extends Commands {
    @Override
    public String[] getUsage() {
        return new String[] {
                "kick <user> <reason>"};
    }

    @Override
    public String getDescription() {
        return "Kicks specified member from guild (reason sent)";
    }

    @Override
    public void execute(GuildMessageReceivedEvent event) {
        if (args.length < 3) {
            ARGS_UNDER(event);
        }

        else if (!event.getMember().hasPermission(Permission.KICK_MEMBERS)) {
            INSUFFICIENT_PERMS(event);
        }

        else {

            try {
                event
                        .getGuild()
                        .getController()
                        .kick(event.getMessage().getMentionedMembers().get(0))
                        .reason(args[2])
                        .complete();
            }

            catch (HierarchyException e) {
                event
                        .getChannel()
                        .sendMessage("** :x: You cannot modify a member with higher or equal highest role than yourself!**")
                        .queue();
            }
        }
    }
    public Kick (GuildMessageReceivedEvent event) {
        super(event);
    }
}
