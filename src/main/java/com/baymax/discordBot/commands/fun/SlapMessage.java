package com.baymax.discordBot.commands.fun;

import com.baymax.discordBot.assets.memes.MessageGifURL;
import com.baymax.discordBot.commands.Commands;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class SlapMessage extends Commands {

    @Override
    public String[] getUsage() {
        return new String[]{
                "slap <user>"
        };
    }

    @Override
    public String getDescription() {
        return "Sends a slap gif to the specified user on the channel ";
    }

    @Override
    public void execute(GuildMessageReceivedEvent event) {
        if (args.length > 2) {
            ARGS_OVER(event);
        }

        else if (args.length < 2) {
            ARGS_UNDER(event);

        }

        else {
            String slapGif = MessageGifURL.getRandomSlap();

            String member = event.getMessage().getMentionedMembers().get(0).getAsMention();

            if (args[1].equalsIgnoreCase(event.getAuthor().getAsMention())) {

                event
                        .getChannel()
                        .sendMessage("**Well, you want to slap yourself I see... go ahead!**")
                        .queue();
                event
                        .getChannel()
                        .sendMessage(event.getAuthor().getAsMention() + (slapGif.equals(MessageGifURL.kimchiSlap) ? " spiCy kImcHi SlaPs " : " slaps ")
                                + member + "\n" + slapGif)
                        .queue();
            } else {

                event
                        .getChannel()
                        .sendMessage(event.getAuthor().getAsMention() + (slapGif.equals(MessageGifURL.kimchiSlap) ? " spiCy kImcHi SlaPs " : " slaps ")
                                + member + "\n" + slapGif)
                        .queue();
            }
        }
    }

    public SlapMessage(GuildMessageReceivedEvent event) {
        super(event);
    }
}
