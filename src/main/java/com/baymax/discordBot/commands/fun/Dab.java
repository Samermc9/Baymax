package com.baymax.discordBot.commands.fun;

import com.baymax.discordBot.assets.memes.ImageURL;
import com.baymax.discordBot.commands.Commands;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class Dab extends Commands {

    @Override
    public String[] getUsage() {
        return new String[]{"dab"};
    }

    @Override
    public String getDescription() {
        return "Sends a dab image to the channel";
    }

    @Override
    public void execute(GuildMessageReceivedEvent event) {
        if (args.length > 1) {
            ARGS_OVER(event);
        }

        else {
            String dabImage = ImageURL.getDabPictures();
            if (dabImage.equalsIgnoreCase("https://i.ytimg.com/vi/H3ztJs4uSDY/hqdefault.jpg")) {
                event
                        .getChannel()
                        .sendMessage("**White dad dabeu activateu**")
                        .queue();
                event
                        .getChannel()
                        .sendMessage(dabImage)
                        .queue();
            } else if (dabImage.equalsIgnoreCase("https://scontent-atl3-1.cdninstagram.com/vp/3ce0c5ec315aedfa4a21dffbb52ee682/5C4661F6/t51.2885-15/e35/38626126_2171367539767391_4091908689718411264_n.jpg")) {
                event
                        .getChannel()
                        .sendMessage("**Spell b a d in reversere **")
                        .queue();
                event
                        .getChannel()
                        .sendMessage(dabImage)
                        .queue();
            } else {
                event
                        .getChannel()
                        .sendMessage(dabImage)
                        .queue();
            }
        }
    }


    public Dab(GuildMessageReceivedEvent event) {
        super(event);
    }
}
