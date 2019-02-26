package com.baymax.discordBot.commands.fun;

import com.baymax.discordBot.commands.Commands;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Dice extends Commands {

    @Override
    public String[] getUsage() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public void execute(GuildMessageReceivedEvent event) {
        if (args.length > 1) {
            ARGS_OVER(event);
        }

        else {
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

    public Dice (GuildMessageReceivedEvent event) {
       super(event);
    }
}
