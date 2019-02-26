package com.baymax.discordBot.commands.info;

import com.baymax.discordBot.message.DirectMessage;
import com.baymax.discordBot.message.EmbedMessage;
import net.dv8tion.jda.core.entities.User;

import java.awt.*;

public class HelpDirect {
    public HelpDirect (User user) {

        new DirectMessage(
                "**Hello there! Here is a list of commands I can use!**\n**:information_source: " +
                        "Information**\n```profile     info     online     members     invite```\n**:smiley: Fun**\n```match     8ball     rps (Rock/Paper/Scissors)" +
                        "     robloxmemes     surrealmemes     dice```\n**:speech_balloon: Chat**\n```dab     whip     kill     hug     slap    zalgo     cursedImages```\n" + "**Management:**\n```delete     ban     kick```"
                        + "**:computer: Developer ONLY**\n```sudo     sudostop     shutdown```", user);

        user.openPrivateChannel().queue((channel) ->
                channel.sendMessage(EmbedMessage.create(":warning: Attention!","**Remember to use all commands with & preceding the argument - eg** ```&[args]``` **and be sure to give the right amount of arguments!**",
                        new Color(255, 15, 50), null, null, null).build()).queue());

    }
}
