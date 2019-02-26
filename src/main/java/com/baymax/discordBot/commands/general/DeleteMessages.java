package com.baymax.discordBot.commands.general;
import com.baymax.discordBot.commands.Commands;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageHistory;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class DeleteMessages extends Commands {

    @Override
    public String[] getUsage() {
        return new String[]{"delete <amount_of_messages_>"};
    }

    @Override
    public String getDescription() {
        return "Deletes ";
    }

    @Override
    public void execute(GuildMessageReceivedEvent event) {
        if (args.length < 2) {
            ARGS_UNDER(event);
        }

        else if (args.length > 2) {
            ARGS_OVER(event);
        }

        else {
            deleteMessages(event.getChannel(), Integer.parseInt(args[1]));
        }
    }

    private void deleteMessages(TextChannel channel, int amountOfMesssages) {
        MessageHistory history = new MessageHistory(channel);

        List<Message> msgs = history
                .retrievePast(amountOfMesssages)
                .complete();

        channel
                .deleteMessages(msgs)
                .queue();
    }

    public DeleteMessages(GuildMessageReceivedEvent event) {
       super(event);
    }
}
