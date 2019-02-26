package com.baymax.discordBot.commands.fun;
import com.baymax.discordBot.commands.Commands;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.util.*;

public class EightBall extends Commands {

    @Override
    public String[] getUsage() {
        return new String[]{
                "8ball <question>"
        };
    }

    @Override
    public String getDescription() {
        return "Generates a random response based on the question asked";
    }

    @Override
    public void execute(GuildMessageReceivedEvent event) {
        if (args.length < 2) {
            event
                    .getChannel()
                    .sendMessage("**Do you expect me to give you a reply without asking a question beforehand?**")
                    .queue();
        }

        else {
            event
                    .getChannel()
                    .sendMessage(getRandomOutput())
                    .queue();
        }
    }


    private static List<String> outputs = new ArrayList<>(Arrays.asList("**Yes**",
            "**No**",
            "**Maybe**",
            "**Perhaps**",
            "**It is certain**",
            "**It is decidedly so**",
            "**Without a doubt.**",
            "**There is a good outlook.**",
            "**Reply hazy, try again later**",
            "**Better not tell you now**",
            "**No u**",
            "**Cannot predict right now**",
            "**Concentrate and ask again**",
            "**My reply is a no**",
            "**Very doubtful**",
            "**Unlikely**"
    ));

    private static Random random = new Random();

    private static String getRandomOutput() {
        Collections.shuffle(outputs);
        int randomIndex = random.nextInt(outputs.size());
        return outputs.get(randomIndex);
    }


    public EightBall(GuildMessageReceivedEvent event) {
        super(event);
    }

}

