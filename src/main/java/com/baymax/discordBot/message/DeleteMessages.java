package com.baymax.discordBot.message;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageHistory;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class DeleteMessages {

    private void deleteMessages(TextChannel channel, int amountOfMesssages) {
        MessageHistory history = new MessageHistory(channel);

        List<Message> msgs = history
                .retrievePast(amountOfMesssages)
                .complete();

        channel
                .deleteMessages(msgs)
                .queue();
    }

    public DeleteMessages(GuildMessageReceivedEvent event, String args) {
        deleteMessages(event.getChannel(), Integer.parseInt(args));

    }
}
