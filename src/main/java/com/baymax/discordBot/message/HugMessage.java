package com.baymax.discordBot.message;

import com.baymax.discordBot.assets.GifURL;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class HugMessage {

    public HugMessage (GuildMessageReceivedEvent event) {
        String hugGif = GifURL.getRandomHug();
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
