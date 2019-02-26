package com.baymax.discordBot.message;

import net.dv8tion.jda.core.entities.User;
public class DirectMessage {
    public DirectMessage (String message, User user) {
        user.openPrivateChannel().queue((channel) ->
                channel.sendMessage(message).queue());
    }
}
