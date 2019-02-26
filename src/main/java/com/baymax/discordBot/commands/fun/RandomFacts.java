package com.baymax.discordBot.commands.fun;

import com.baymax.discordBot.commands.Commands;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class RandomFacts extends Commands {
    private Random random = new Random();
    private ArrayList<String> randomFacts = new ArrayList<>(Arrays.asList(
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    ));


    @Override
    public String[] getUsage() {
        return new String[]{
                "randomfacts",
                "randomfacts <category>",
                "randomfacts add <fact>"
        };
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public void execute(GuildMessageReceivedEvent event) {
        switch (args.length) {
            case 1:
                String randomFact = randomFacts.get(random.nextInt(randomFacts.size()));
                event
                        .getChannel()
                        .sendMessage(randomFact)
                        .queue();
                break;

            case 2:
                switch(args[1]) {
                    case "science":
                        break;
                    case "world":
                        break;
                    case "psychology":
                        break;
                    case "languages":
                        break;
                    case "animals":
                        break;
                        default:
                            event
                                    .getChannel()
                                    .sendMessage("**Huh, what category is that?")
                }

            case 3:

        }

    }
}
