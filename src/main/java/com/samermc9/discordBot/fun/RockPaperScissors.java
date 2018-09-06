package com.samermc9.discordBot.fun;

import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;


public class RockPaperScissors extends ListenerAdapter {

    private Member member;
    private String msg;
    private boolean gameOn;

    private String[] emotes = {"\uD83D\uDD90", "✊", "✌"};

    private String getRandomAnswer() {
        Collections.shuffle(Arrays.asList(emotes));
        return emotes[0];
    }

    private void sendMessage(GuildMessageReactionAddEvent event, String message) {
        event
                .getChannel()
                .sendMessage(message)
                .queue();
    }

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        final String PREFIX = "&";

        String[] args = event.getMessage().getContentRaw().split(" ");

        if(args[0].equalsIgnoreCase(PREFIX + "rps") || args[0].equalsIgnoreCase(PREFIX + "rockpaperscissors")) {
            event
                    .getChannel()
                    .sendMessage("**You have started a rock paper scissors game! Please choose an emote to confirm your option!**")
                    .queue(new Consumer<Message>() {
                        @Override
                        public void accept(Message message) {
                            message.addReaction("\uD83D\uDD90").queueAfter(1, TimeUnit.MILLISECONDS);
                            message.addReaction("✊").queueAfter(1, TimeUnit.MILLISECONDS);
                            message.addReaction("✌").queueAfter(1, TimeUnit.MILLISECONDS);
                            msg = message.getId();
                            gameOn = true;
                        }
                    });

            member = event.getMember();
        }
    }

    public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent event) {
        if (event.getMember().equals(member) && msg.equals(event.getMessageId()) && gameOn) {

            String emote = event.getReactionEmote().getName();
            if (emote.equals("\uD83D\uDD90")) {

                switch (getRandomAnswer()) {
                    case "\uD83D\uDD90":
                        sendMessage(event,"**You chose " + emote + ". I chose \uD83D\uDD90, It's a draw!**");
                        break;
                    case "✊":
                        sendMessage(event, "**You chose " + emote + ". I chose ✊, You win!**");
                        break;
                    case "✌":
                        sendMessage(event, "You chose " + emote + ". I chose ✌, You lose!**");
                        break;
                }

            } else if (emote.equals("✌")) {

                switch (getRandomAnswer()) {
                    case "\uD83D\uDD90":
                        sendMessage(event,"**You chose " + emote + ". I chose \uD83D\uDD90, You win!**");
                        break;
                    case "✊":
                        sendMessage(event, "**You chose " + emote + ". I chose ✊, You lose!");
                        break;
                    case "✌":
                        sendMessage(event, "**You chose " + emote + ". I chose ✌, You tied!**");
                        break;
                }

            } else if (emote.equals("✊")) {

                switch (getRandomAnswer()) {
                    case "\uD83D\uDD90":
                        sendMessage(event,"**You chose " + emote + ". I chose \uD83D\uDD90, You lose!**");
                        break;
                    case "✊":
                        sendMessage(event, "**You chose " + emote + ". I chose ✊, You tied!**");
                        break;
                    case "✌":
                        sendMessage(event, "**You chose " + emote + ". I chose ✌, You win!**");
                        break;
                }
            }
            gameOn = false;
        }
    }
}
