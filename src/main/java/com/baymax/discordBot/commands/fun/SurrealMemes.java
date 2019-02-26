package com.baymax.discordBot.commands.fun;

import com.baymax.discordBot.assets.memes.ImageURL;
import com.baymax.discordBot.commands.Commands;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class SurrealMemes extends Commands {
    @Override
    public String[] getUsage() {
        return new String[] {"surrealmemes"};
    }

    @Override
    public String getDescription() {
        return "Sends a random surreal meme on the server";
    }

    @Override
    public void execute(GuildMessageReceivedEvent event) {
        if (args.length > 1) {
            ARGS_OVER(event);
        } else {
            event
                    .getChannel()
                    .sendMessage(ImageURL.getRandomSurrealMemes())
                    .queue();
        }
    }

    public SurrealMemes (GuildMessageReceivedEvent event) {
        super(event);
    }
}
