package com.baymax.discordBot.fun;


import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.util.Random;

public class Match {

    public Match(GuildMessageReceivedEvent event) {
        Random random = new Random();
        String inputUser = event
                .getMessage()
                .getMentionedMembers()
                .get(0)
                .getAsMention();

        String mentionedUser = event
                .getMessage()
                .getMentionedMembers()
                .get(1)
                .getAsMention();

        if (event.getMessage().getAuthor().getAsMention().equals(inputUser)) {
            event
                    .getChannel()
                    .sendMessage("**:x: As sad as it can be, you can't match yourself!**")
                    .queue();
        }

        int friendshipMeter = random.nextInt(100);

        if (friendshipMeter <= 50) {

            event
                    .getChannel()
                    .sendMessage(inputUser + "** has a " + friendshipMeter + "% match with " + mentionedUser + " .Not the best pair are you?**")
                    .queue();
        } else {
            event
                    .getChannel()
                    .sendMessage(inputUser + "** has a " + friendshipMeter + "% match with " + mentionedUser + ". It's a match made in heaven!**")
                    .queue();
        }
    }
}
