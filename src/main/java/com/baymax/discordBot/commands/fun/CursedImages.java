package com.baymax.discordBot.commands.fun;

import com.baymax.discordBot.assets.memes.ImageURL;
import com.baymax.discordBot.commands.Commands;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class CursedImages extends Commands
{
    @Override
    public String[] getUsage() {
        return new String[]{
                "cursedimages"
        };
    }

    @Override
    public String getDescription() {
        return "Sends a cursed image to the channel";
    }

    @Override
    public void execute (GuildMessageReceivedEvent event) {
        if (args.length > 1) {
            ARGS_OVER(event);
        } else {
            String cursedImage = ImageURL.getCursedImages();
            event
                    .getChannel()
                    .sendMessage(cursedImage)
                    .queue();
        }
    }

    public CursedImages (GuildMessageReceivedEvent event) {
        super(event);
    }
}
