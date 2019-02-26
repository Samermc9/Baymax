package com.baymax.discordBot.commands.info;

import com.baymax.discordBot.commands.Commands;
import com.baymax.discordBot.message.EmbedMessage;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import javax.management.relation.RoleNotFoundException;
import java.awt.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Roles extends Commands {

    @Override
    public String[] getUsage() {
        return new String[]{
                "roles",
                "roles <user>",
                "roles set <role> <user>",
                "roles remove <role> <user>",
                "roles create <name> <colour> -- (as RGB eg 100,55,10)"
        };
    }

    @Override
    public String getDescription() {
        return "Views the mentioned user's/ author's permissions and roles within the guild. Also allows users to add, remove and create new roles";
    }

    @Override
    public void execute(GuildMessageReceivedEvent event) {



        if (args.length == 1) {
            event
                    .getChannel()
                    .sendMessage(EmbedMessage.create("**Role information!**",
                            "**Roles in Guild:**" + "```" + getRoles(event, event.getMember())
                                    + "```" + "\n" + "**Permissions within channel:**"
                                    + "```" + getPermissions(event, event.getMember()) + "```"
                            , new Color(255, 29, 19), null,
                            event.getMessage().getAuthor().getAvatarUrl(), null).build())
                    .queue();
        }

        else if (args.length == 2) {
            Member mentionedMember = event
                    .getMessage()
                    .getMentionedMembers()
                    .get(0);
                    event
                        .getChannel()
                        .sendMessage(EmbedMessage.create("**Role information!**",
                                "**Roles in Guild:**" + "```" +
                                        getRoles(event, mentionedMember) + "```" + "\n" + "**Permissions within channel:**"
                                        + "```" + getPermissions(event, event.getMessage().getMentionedMembers().get(0)) + "```"
                                , new Color(255, 29, 19), null,
                                mentionedMember.getUser().getAvatarUrl(), null).build())
                        .queue();
            }


        else if (args.length == 4) {
            switch (args[1]) {
                case "set":
                    event
                            .getMessage()
                            .getMentionedMembers()
                            .get(0)
                            .getRoles()
                            .add( event
                                    .getMessage()
                                    .getMentionedRoles()
                                    .get(0));

                    event
                            .getChannel()
                            .sendMessage(event.getMessage().getMentionedMembers().get(0).getAsMention() + " has been added to the " +  event
                                    .getMessage()
                                    .getMentionedRoles()
                                    .get(0) + " role!")
                            .queue();

                    break;

                    case "remove":
                    event.getGuild().getController().removeSingleRoleFromMember(
                            event.getMessage().getMentionedMembers().get(0),
                            event.getMessage()
                                    .getMentionedMembers()
                                    .get(0)
                                    .getRoles().get(0)
                    ).complete();
                    event
                            .getChannel()
                            .sendMessage(event.getMessage().getMentionedMembers().get(0).getAsMention() + " has been removed from the " +  event
                                    .getMessage()
                                    .getMentionedRoles()
                                    .get(0) + " role!")
                            .queue();
                    break;


                case "create":
                    event
                            .getGuild()
                            .getController()
                            .createRole()
                            .setName(args[2])
                            .setColor(Color.CYAN)
                            .complete();

                    break;


                    default:
                        UNKNOWN_COMMAND(event);
            }
        }

        else {
            ARGS_OVER(event);
        }
    }

    private String getRoles(GuildMessageReceivedEvent event, Member member) {
        List<Role> roles = event.getMember().getRoles();
        if (roles.isEmpty()) {
            return "The specified user has no roles in this server!";

        }

        return Arrays.toString(roles.toArray());
    }

    private List<Permission> getPermissions(GuildMessageReceivedEvent event, Member member) {
        return event.getMember().getPermissions(event.getChannel());
    }

    public Roles(GuildMessageReceivedEvent event) {
        super(event);
    }
}
