package com.baymax.discordBot;

import com.baymax.discordBot.commands.Help;
import com.baymax.discordBot.fun.*;
import com.baymax.discordBot.message.KillMessage;
import com.baymax.discordBot.commands.Info;
import com.baymax.discordBot.guildMembers.Members;
import com.baymax.discordBot.guildMembers.Online;
import com.baymax.discordBot.message.DeleteMessages;
import com.baymax.discordBot.message.HugMessage;
import com.baymax.discordBot.message.SlapMessage;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;


public class EventHandler extends ListenerAdapter {

    private static final String PREFIX = "&";

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        String[] args = event.getMessage().getContentRaw().split(" ");

        StringBuilder sb = new StringBuilder();

        for (String s : args) {
            sb.append(s);
        }

        String msg = sb.toString();

        if (event.getAuthor().isBot()) {
            return;
        }

        if (args[0].equalsIgnoreCase(PREFIX + "help")) {

            if (args.length > 1) {
                event
                        .getChannel()
                        .sendMessage("**:x: Invalid usage: too many [args]**")
                        .queue();

            } else {
                new Help(event);
            }

        } else if (args[0].equalsIgnoreCase(PREFIX + "surrealmemes")) {

            if (args.length > 1) {
                event
                        .getChannel()
                        .sendMessage("**:x: Invalid usage: too many [args]**")
                        .queue();
            } else {
                new SurrealMemes(event);
            }

        } else if (args[0].equalsIgnoreCase(PREFIX + "hug")) {

            if (args.length < 2) {
                event
                        .getChannel()
                        .sendMessage("**:x: Invalid usage, too few [args]**")
                        .queue();
            } else if (args.length > 2) {
                event
                        .getChannel()
                        .sendMessage("**:x: Invalid usage, too many [args]**")
                        .queue();
            } else {
                new HugMessage(event);
            }

        } else if (args[0].equalsIgnoreCase(PREFIX + "slap")) {
            if (args.length < 2) {
                event
                        .getChannel()
                        .sendMessage("**:x: Invalid usage, too few [args]**")
                        .queue();

            } else if (args.length > 2) {
                event
                        .getChannel()
                        .sendMessage("**:x: Invalid usage, too many [args]**")
                        .queue();

            } else {
                new SlapMessage(event, args[1]);
            }

        } else if (args[0].equalsIgnoreCase(PREFIX + "hangman")) {
            //hangman called


        } else if (args[0].equalsIgnoreCase(PREFIX + "kill")) {
            if (args.length < 2) {
                event
                        .getChannel()
                        .sendMessage("**:x: Invalid usage, too few [args]**")
                        .queue();
            } else if (args.length > 2) {
                event
                        .getChannel()
                        .sendMessage("**:x: Invalid usage, too many [args]**")
                        .queue();
            } else {
                new KillMessage(event);
            }


        } else if (args[0].equalsIgnoreCase(PREFIX + "match")) {
            if (args.length < 3) {
                event
                        .getChannel()
                        .sendMessage("**:x: Invalid usage, too few [args]**")
                        .queue();
            } else if (args.length > 3) {
                event
                        .getChannel()
                        .sendMessage("**:x: Invalid usage, too many [args]**")
                        .queue();
            } else {
                new Match(event);
            }


        } else if (args[0].equalsIgnoreCase(PREFIX + "info")) {
            if (args.length > 2) {
                event
                        .getChannel()
                        .sendMessage("**:x: Invalid usage, too many [args]**")
                        .queue();
            } else {
                new Info(event);
            }
        }


        else if (args[0].equalsIgnoreCase(PREFIX + "members")) {

            if (args.length > 1) {
                event
                        .getChannel()
                        .sendMessage("**:x: Invalid usage, too many [args]**")
                        .queue();

            } else {
                new Members(event);
            }



        } else if (args[0].equalsIgnoreCase(PREFIX + "robloxmemes")) {
            if (args.length > 1) {
                event
                        .getChannel()
                        .sendMessage("**:x: Invalid usage, too few [args]**")
                        .queue();
            } else {
                new RobloxMemes(event);
            }
        }



        //DELETE
        else if (args[0].equalsIgnoreCase(PREFIX + "delete")) {
            if (args.length < 2) {
                event
                        .getChannel()
                        .sendMessage("**:x: Invalid usage, too few [args]**")
                        .queue();

            } else if (args.length > 2) {
                event
                        .getChannel()
                        .sendMessage("**:x: Invalid usage, too many [args]**")
                        .queue();

            } else {
                new DeleteMessages(event, args[1]);
            }
        }

        else if (args[0].equalsIgnoreCase(PREFIX + "online")) {

            if (args.length > 1) {
                event
                        .getChannel()
                        .sendMessage("**:x: Invalid usage, Too many [args]")
                        .queue();
                System.out.println(msg);

            } else {
                new Online(event);
            }

        } else if (args[0].equalsIgnoreCase(PREFIX + "8ball")) {

            if (args.length < 2) {
                event
                        .getChannel()
                        .sendMessage("**:x: Invalid usage, too few [args]**")
                        .queue();
            } else {
                String eightBallOutput = EightBall.getRandomOutput();
                event
                        .getChannel()
                        .sendMessage(eightBallOutput)
                        .queue();
            }



            //KICK
        } else if (args[0].equalsIgnoreCase(PREFIX + "kick")) {
            if (args.length < 2) {
                event
                        .getChannel()
                        .sendMessage("**:x: Invalid usage, too few [args]**")
                        .queue();
            } else if (args.length > 2) {
                event
                        .getChannel()
                        .sendMessage("**:x: Invalid usage, too many [args]**")
                        .queue();
            } else {
                Member member = event.getMessage().getMentionedMembers().get(0);
                event
                        .getGuild()
                        .getController()
                        .kick(member)
                        .complete();
            }

        }

        else if (args[0].equalsIgnoreCase(PREFIX + "dice")) {

            if (args.length > 1) {
                event
                        .getChannel()
                        .sendMessage("**Invalid usage, too many [args]**")
                        .queue();

            } else {
                new Dice(event);
            }

        } else if (args[0].equalsIgnoreCase(PREFIX + "rps") || args[0].equalsIgnoreCase(PREFIX + "rockpaperscissors")) {
            //listener called at main

        } else {

            if (msg.startsWith(PREFIX)) {
                event
                        .getChannel()
                        .sendMessage("**:x: Invalid command! Not available - contact @Samermc9 or @Albus for more info**")
                        .queue();
            }
        }
    }
}
