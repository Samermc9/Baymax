package com.baymax.discordBot.fun;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Dice {
    public Dice (GuildMessageReceivedEvent event) {
        Random random = new Random();
        int dice = random.nextInt(6);
        event
                .getChannel()
                .sendMessage("**Now rolling a dice....**")
                .queue();

        if (dice < 4) {
            event
                    .getChannel()
                    .sendMessage("**You rolled a " + dice + " ... Not your lucky day is it, " + event.getAuthor().getAsMention() + "**")
                    .queueAfter(2, TimeUnit.SECONDS);
        } else if (dice > 4) {
            event
                    .getChannel()
                    .sendMessage("**You rolled a " + dice + ", great job :smile:**")
                    .queue();
        }
    }
}
