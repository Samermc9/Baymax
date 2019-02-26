package com.baymax.discordBot.commands.fun;

import com.baymax.discordBot.assets.memes.ImageURL;
import com.baymax.discordBot.commands.Commands;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class RobloxMemes extends Commands {

    @Override
    public String[] getUsage() {
        return new String[]{
                "robloxmemes"
        };
    }

    @Override
    public String getDescription() {
        return "Sends a random roblox meme over to the channel";
    }

    @Override
    public void execute(GuildMessageReceivedEvent event) {
        if (args.length > 1) {
            ARGS_OVER(event);
        }

        event
                .getChannel()
                .sendMessage(ImageURL.getRobloxMemes())
                .queue();
    }

    public RobloxMemes (GuildMessageReceivedEvent event) {
        super(event);
    }
}
