package com.samermc9.discordBot.fun;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.util.*;

public class EightBall {

        private static List<String> outputs = new ArrayList<>(Arrays.asList(
                "**Yes**",
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
                "Unlikely"
        ));

        private static Random random = new Random();


        public static String getRandomOutput() {
            Collections.shuffle(outputs);
            int randomIndex = random.nextInt(outputs.size());
            return outputs.get(0);
        }
    }

