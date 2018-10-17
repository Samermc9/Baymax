package com.baymax.discordBot.message;

import com.baymax.discordBot.assets.GifURL;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class KillMessage {
    public KillMessage (GuildMessageReceivedEvent event) {
        String killGif = GifURL.getRandomKill();
        String member = event.getMessage().getMentionedMembers().get(0).getAsMention();
        event
                .getChannel()
                .sendMessage(event.getAuthor().getAsMention() + " kills " + member)
                .queue();

        event
                .getChannel()
                .sendMessage(killGif)
                .queue();
    }
}
