package com.baymax.discordBot.commands;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.util.Arrays;

public abstract class Commands {

    //COMMAND ARGS
    public static String[] args;

    //ABSTRACT FUNCTIONS, called on super();
    public abstract String[] getUsage();

    public abstract String getDescription();

    public abstract void execute (GuildMessageReceivedEvent event);

    //super();
    public Commands (GuildMessageReceivedEvent event) {
        args = event
                .getMessage()
                .getContentRaw()
                .split(" ");

        getUsage();
        getDescription();
        execute(event);
    }

    //default constructor for child constructors with multiple parameters
    protected Commands() {
    }


    //ERROR MESSAGES
    protected void ARGS_OVER (GuildMessageReceivedEvent event) {
        event
                .getChannel()
                .sendMessage("**:x: Invalid usage! Too many [args]**")
                .queue();
    }

    protected void ARGS_UNDER (GuildMessageReceivedEvent event) {
        event
                .getChannel()
                .sendMessage("**:x: Invalid usage! Too few [args]**")
                .queue();
    }

    protected void DEVELOPER_ONLY (GuildMessageReceivedEvent event) {
        event
                .getChannel()
                .sendMessage("**:x: Command failed! Too bad you didn't code this bot**")
                .queue();
    }

    public static void UNKNOWN_COMMAND (GuildMessageReceivedEvent event) {
        event
                .getChannel()
                .sendMessage("**:x: Invalid command! Not available - contact @thesameritan or @Albus for more info**")
                .queue();
    }

    protected static void INSUFFICIENT_PERMS (GuildMessageReceivedEvent event) {
        event
                .getChannel()
                .sendMessage("**:x: You do not have the required permissions to carry out that command!**")
                .queue();
    }



    private static String[] userCommands = new String[]{
            "help",
            "online",
            "slap",
            "kill",
            "hug",
            "dice",
            "members",
            "delete",
            "info",
            "surrealmemes",
            "robloxmemes",
            "cursedimages",
            "match",
            "rps",
            "8ball",
            "profile",
            "dab",
            "whip",
            "invite",
            "zalgo",
            "helpdm",
            "ban",
            "kick"
    };

    private static String[] devCommands = new String[]{
            "sudo",
            "sudostop",
            "shutdown"
    };

    public static int getTotalLength() {
        return userCommands.length + devCommands.length;
    }

    public static String getUserCommands() {
        return Arrays.toString(userCommands);
    }

    public static String getDevCommands() {
        return Arrays.toString(devCommands);
    }

}
