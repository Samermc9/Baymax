package com.samermc9.discordBot;

import com.samermc9.discordBot.fun.Hangman;
import com.samermc9.discordBot.fun.RockPaperScissors;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

public class Main {

    public static void main(String[] args) throws Exception {
        JDA jda = new JDABuilder(AccountType.BOT)
                .setToken("NDgxNzgwNTI1MDk5NjQ2OTc3.Dl7U0w.6rdCWo5bfRYMEVWuKkiaOj3M89U")
                .setAutoReconnect(true)
                .buildBlocking();
        jda.addEventListener(new EventHandler());
        jda.addEventListener(new RockPaperScissors());
        jda.addEventListener(new Hangman());
    }
}
