package com.baymax.discordBot.commands;

import java.util.Arrays;

class CommandsList {
    private static String[] commands = new String[]{
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
            "match",
            "rps",
            "8ball"
    };

    static int getLength() {
        return commands.length;
    }

    static String getCommands() {
        return Arrays.toString(commands);
    }
}
