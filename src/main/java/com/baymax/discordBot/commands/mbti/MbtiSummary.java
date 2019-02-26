package com.baymax.discordBot.commands.mbti;

import com.baymax.discordBot.assets.mbti.ImageURL;
import com.baymax.discordBot.message.EmbedMessage;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.awt.*;

class MbtiSummary {
    MbtiSummary (GuildMessageReceivedEvent event) {
        event
                .getChannel()
                .sendMessage(EmbedMessage.create("Summary", "Myers-Briggs theory is an adaptation of the theory of psychological types " +
                                "produced by Carl Gustav Jung. It is based on 16 personality types. They act as useful reference points to understand " +
                                "your unique personality. At the heart of Myers Briggs theory are four preferences.\n\n" +
                                "`Do you prefer to deal with:`\n\n" +
                                ":white_small_square:" + "`People and things (Extraversion or \"E\"), or ideas and information (Introversion or \"I\")?`\n\n" +
                                ":white_small_square:" + "`Facts and reality (Sensing or \"S\"), or possibilities and potential (Intuition or \"N\")?`\n\n" +
                                ":white_small_square:" + "`Logic and truth (Thinking or \"T\"), or values and relationships (Feeling or \"F\")?`\n\n" +
                                ":white_small_square:" + "`A lifestyle that is well-structured (Judgment or \"J\"), or one that goes with the flow (Perception or \"P\")?`\n\n",
                        new Color(230, 0, 50), null, ImageURL.logo, null).addField(new MessageEmbed.Field("Learn more at: ", "https://www.16personalities.com/articles/our-theory", true)).build()).queue();
    }
}
