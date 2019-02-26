package com.baymax.discordBot.commands.dev;
import com.baymax.discordBot.commands.Commands;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.util.Scanner;

public class Sudo extends Commands {
    public static boolean isRunning;

    @Override
    public String[] getUsage() {
        return new String[]{
                "sudo <text_channel_ID>"
        };
    }

    @Override
    public String getDescription() {
        return "Allows user to chat through the bot if user is a developer and has access to native console";
    }

    @Override
    public void execute(GuildMessageReceivedEvent event) {
        if (args.length < 2) {
            ARGS_UNDER(event);
        }

        else if (args.length > 2) {
            ARGS_OVER(event);
        }

        else if (!event.getMessage().getAuthor().getDiscriminator().equals("0286")) {
            DEVELOPER_ONLY(event);
        }

        else {
            while (isRunning) {
                try {
                    Scanner sc = new Scanner(System.in);
                    String message = sc.nextLine();
                    TextChannel textChannel = event
                            .getGuild()
                            .getTextChannels().get(0);
                    textChannel.sendMessage(message).queue();
                    if (!isRunning) {
                        break;
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Empty message");
                }
            }
        }
    }

    public Sudo (GuildMessageReceivedEvent event) {
        super(event);
    }
}

