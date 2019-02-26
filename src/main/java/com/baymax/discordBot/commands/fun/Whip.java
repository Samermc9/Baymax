package com.baymax.discordBot.commands.fun;

import com.baymax.discordBot.assets.memes.ImageURL;
import com.baymax.discordBot.commands.Commands;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class Whip extends Commands {
    @Override
    public String[] getUsage() {
        return new String[]{
                "whip"
        };
    }

    @Override
    public String getDescription() {
        return "Sends a random whip gif/image on the channel";
    }

    @Override
    public void execute(GuildMessageReceivedEvent event) {
        if (args.length > 1) {
            ARGS_OVER(event);
        }

        event
                .getChannel()
                .sendMessage(ImageURL.getWhipPictures())
                .queue();
    }

    public Whip (GuildMessageReceivedEvent event) {
        super(event);
    }
}
