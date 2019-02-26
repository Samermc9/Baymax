package com.baymax.discordBot;
import com.baymax.discordBot.commands.fun.RockPaperScissors;
import com.baymax.discordBot.handlers.EventHandler;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;


public class Main {

    public static JDA jda;

    public static void main(String[] args) throws Exception {

        jda = new JDABuilder(AccountType.BOT)
                .setToken("NDgxNzgwNTI1MDk5NjQ2OTc3.Dl7U0w.6rdCWo5bfRYMEVWuKkiaOj3M89U")
                .setAutoReconnect(true)
                .build();

        jda
                .getPresence()
                .setPresence(Game.of(Game.GameType.WATCHING, "out for errors!"), true);

        try {
            jda.addEventListener(new EventHandler());
            jda.addEventListener(new RockPaperScissors());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
