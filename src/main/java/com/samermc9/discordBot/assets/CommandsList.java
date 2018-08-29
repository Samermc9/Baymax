package com.samermc9.discordBot.assets;

import java.util.Arrays;

public class CommandsList {
    private static String[] commands = new String[]{"help", "online", "slap", "kill", "hug", "dice", "members", "delete", "info", "surrealmemes", "robloxmemes"};

    public static int getLength() {
        return commands.length;
    }

    public static String getCommands() {
        return Arrays.toString(commands);
    }
}
