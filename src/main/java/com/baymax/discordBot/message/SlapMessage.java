package com.baymax.discordBot.message;

import com.baymax.discordBot.assets.GifURL;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class SlapMessage {

    public SlapMessage(GuildMessageReceivedEvent event, String args) {
        String slapGif = GifURL.getRandomSlap();

        String member = event.getMessage().getMentionedMembers().get(0).getAsMention();

        if (args.equalsIgnoreCase(event.getAuthor().getAsMention())) {

            event
                    .getChannel()
                    .sendMessage("**Well, you want to slap yourself I see... go ahead!**")
                    .queue();
            event
                    .getChannel()
                    .sendMessage(event.getAuthor().getAsMention() + (slapGif.equals(GifURL.kimchiSlap) ? " spiCy kImcHi SlaPs " : " slaps ")
                            + member + "\n" + slapGif)
                    .queue();
        } else {

            event
                    .getChannel()
                    .sendMessage(event.getAuthor().getAsMention() + (slapGif.equals(GifURL.kimchiSlap) ? " spiCy kImcHi SlaPs " : " slaps ")
                            + member + "\n" + slapGif)
                    .queue();
        }
    }
}
