package com.baymax.discordBot.commands.info;

import com.baymax.discordBot.commands.Commands;
import com.baymax.discordBot.message.EmbedMessage;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import java.awt.*;
import java.time.format.DateTimeFormatter;

public class UserProfile extends Commands {
    @Override
    public String[] getUsage() {
        return new String[]{
                "profile - for message author",
                "profile <user> - for mentioned user"};
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public void execute(GuildMessageReceivedEvent event) {
        if (args.length == 2) {
            User mentionedUser = event
                    .getMessage()
                    .getMentionedMembers()
                    .get(0)
                    .getUser();


            String username = mentionedUser.getName();
            String userProfileURL = mentionedUser.getAvatarUrl();
            String userDiscordTag = mentionedUser.getDiscriminator();
            String userCreationTime = mentionedUser.getCreationTime().format(DateTimeFormatter.RFC_1123_DATE_TIME);

            event
                    .getChannel()
                    .sendMessage(EmbedMessage
                            .create("User profile:",
                                    "Username: " +
                                            "**" + username +
                                            "**\n" + " Discord Tag:```" +
                                            username + "#" + userDiscordTag +
                                            "```" + " Creation Date and Time:\n" +
                                            "**" + userCreationTime + "**",
                                    new Color(8, 233, 207),
                                    null, userProfileURL, null)
                            .build())
                    .queue();


        } else if (args.length == 1) {

            User user = event
                    .getMessage()
                    .getAuthor();

            String username = user.getName();
            String userProfileURL = user.getAvatarUrl();
            String userDiscordTag = user.getDiscriminator();
            String userCreationTime = user.getCreationTime().format(DateTimeFormatter.RFC_1123_DATE_TIME);

            event
                    .getChannel()
                    .sendMessage(EmbedMessage
                            .create("User profile:",
                                    "Username: " +
                                            "**" + username + "**\n" +
                                            " Discord Tag:```" + username +
                                            "#" + userDiscordTag + "```" +
                                            " Creation Date and Time:\n" + "**" +
                                            userCreationTime + "**",
                                    new Color(8, 233, 207),
                                    null, userProfileURL, null)
                            .build())
                    .queue();
        }

        else {
            ARGS_OVER(event);
        }
    }


    public UserProfile(GuildMessageReceivedEvent event) {
        super(event);
    }
}

