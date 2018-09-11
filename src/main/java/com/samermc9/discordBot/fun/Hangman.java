package com.samermc9.discordBot.fun;

import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.*;

public class Hangman extends ListenerAdapter {

    private static String asterisk = "*";
    private boolean gameOn;
    private User member;
    private int counter = 6;

    private static final Random random = new Random();

    private static final List<String> words = new ArrayList<>(Arrays.asList(
            "dog",
            "cat",
            "horse",
            "frog",
            "hat",
            "door",
            "bag",
            "pencil",
            "eraser",
            "marker",
            "drawing",
            "painting"));

    private static final int randomIndex = random.nextInt(words.size());


    private static String changeToBlank(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(asterisk);
        }

        return sb.toString();
    }


    private static String getWord() {
        return words.get(randomIndex);
    }


    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        final String PREFIX = "&";
        String[] args = event.getMessage().getContentRaw().split(" ");
        final String displayWord = getWord();



        if (args[0].equalsIgnoreCase(PREFIX + "hangman")) {

            member = event.getMessage().getAuthor();
            event
                    .getChannel()
                    .sendMessage("**You have started a hangman game! Guess the word below.**")
                    .queue();

            final String hiddenWord = changeToBlank(displayWord);

            event
                    .getChannel()
                    .sendMessage("```" + hiddenWord + "```")
                    .queue();

            gameOn = true;
        }

        if (gameOn && member == event.getMessage().getAuthor()) {
            StringBuilder sb = new StringBuilder();

            List<Character> args2 = new ArrayList<>();

            for (char c : event.getMessage().getContentRaw().toCharArray()) {
                args2.add(c);
                sb.append(c);
            }

            if (args2.size() == 1) {
                System.out.println(args[0]);
                System.out.println(displayWord);

                if (displayWord.contains(args2.get(0).toString())) {
                    event
                            .getChannel()
                            .sendMessage("**You have successfully guessed a character!**")
                            .queue();

                }

                else {
                    counter -= 1;
                    event
                            .getChannel()
                            .sendMessage("**:x: Wrong! You have " + counter + " attempts left!**")
                            .queue();

                    if (counter == 0) {
                        event
                                .getChannel()
                                .sendMessage("**You have lost the game! The word was: " + "```" + displayWord + "```" + "**")
                                .queue();
                    }
                }

            } else if (args2.size() > 1) {
                event
                        .getChannel()
                        .sendMessage("Wrong input, please only enter 1 char")
                        .queue();

                System.out.println(sb.toString());
            }
        }
    }
}
