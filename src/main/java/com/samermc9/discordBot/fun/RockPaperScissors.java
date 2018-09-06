package com.samermc9.discordBot.fun;

import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.Arrays;
import java.util.Collections;
import java.util.function.Consumer;


public class RockPaperScissors extends ListenerAdapter {

    private Member member;
    private String msg;

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
                    .sendMessage("You have started a rock paper scissors! Please choose an emote")
                    .queue(new Consumer<Message>() {
                        @Override
                        public void accept(Message message) {
                            message.addReaction("\uD83D\uDD90");
                            message.addReaction("✊");
                            message.addReaction("✌");
                            msg = message.getId();
                        }
                    });

            member = event.getMember();
        }
    }

    public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent event) {
        if (event.getMember().equals(member) && msg.equals(event.getMessageId())) {
            String[] emotes = {"\uD83D\uDD90", "✊", "✌"};

            Collections.shuffle(Arrays.asList(emotes));

            if (event.getReactionEmote().getEmote().equals(event.getGuild().getEmoteById("\uD83D\uDD90"))) {

                switch (emotes[0]) {
                    case "\uD83D\uDD90":
                        sendMessage(event,"You tied!");
                        break;
                    case "✊":
                        sendMessage(event, "You win!");
                        break;
                    case "✌":
                        sendMessage(event, "You loose!");
                        break;
                }

            } else if (event.getReactionEmote().getEmote().equals(event.getGuild().getEmoteById("✌"))) {

                switch (emotes[0]) {
                    case "\uD83D\uDD90":
                        sendMessage(event,"You win!");
                        break;
                    case "✊":
                        sendMessage(event, "You loose!");
                        break;
                    case "✌":
                        sendMessage(event, "You tied!");
                        break;
                }

            } else if (event.getReactionEmote().getEmote().equals(event.getGuild().getEmoteById("✊"))) {

                switch (emotes[0]) {
                    case "\uD83D\uDD90":
                        sendMessage(event,"You loose!");
                        break;
                    case "✊":
                        sendMessage(event, "You tied!");
                        break;
                    case "✌":
                        sendMessage(event, "You win!");
                        break;
                }
            }
        }
    }
}
