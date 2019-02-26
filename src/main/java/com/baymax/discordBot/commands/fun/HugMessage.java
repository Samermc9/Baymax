package com.baymax.discordBot.commands.fun;

import com.baymax.discordBot.assets.memes.MessageGifURL;
import com.baymax.discordBot.commands.Commands;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class HugMessage extends Commands {

    @Override
    public String[] getUsage() {
        return new String[]{"hug <user>"};
    }

    @Override
    public String getDescription() {
        return "Sends a hug gif to the specified user on the channel";
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
            String hugGif = MessageGifURL.getRandomHug();
            String member = event.getMessage().getMentionedMembers().get(0).getAsMention();
            event
                    .getChannel()
                    .sendMessage(event.getAuthor().getAsMention() + " hugs " + member)
                    .queue();

            event
                    .getChannel()
                    .sendMessage(hugGif)
                    .queue();
        }
    }

    public HugMessage (GuildMessageReceivedEvent event) {
        super(event);
    }
}
