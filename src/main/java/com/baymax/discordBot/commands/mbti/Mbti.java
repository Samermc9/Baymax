package com.baymax.discordBot.commands.mbti;


import com.baymax.discordBot.commands.Commands;
import com.baymax.discordBot.commands.mbti.meta.Type;
import com.baymax.discordBot.assets.mbti.ImageURL;
import com.baymax.discordBot.message.EmbedMessage;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class Mbti extends Commands {
    @Override
    public String[] getUsage() {
        return new String[] {
                "mbti - general overview",
                "mbti <type> - type description"};
    }

    @Override
    public String getDescription() {
        return "Gives an overview of MBTI theory and allows users to view each type";
    }

    @Override
    public void execute(GuildMessageReceivedEvent event) {
        if (args.length > 1) {
            switch (args[1]) {
                case "intp":
                    Type.intp();
                    break;
                case "infp":
                    Type.infp();
                    break;
                case "infj":
                    Type.infj();
                    break;
                case "intj":
                    Type.intj();
                    break;
                case "entj":
                    Type.entj();
                    break;
                case "enfj":
                    Type.enfj();
                    break;
                case "enfp":
                    Type.enfp();
                    break;
                case "entp":
                    Type.entp();
                    break;
                case "esfj":
                    Type.esfj();
                    break;
                case "estj":
                    Type.estj();
                    break;
                case "istj":
                    Type.istj();
                    break;
                case "isfj":
                    Type.isfj();
                    break;
                case "isfp":
                    Type.isfp();
                    break;
                case "istp":
                    Type.istp();
                    break;
                case "estp":
                    Type.estp();
                    break;
                case "esfp":
                    Type.esfp();
                    break;
                default:
                    event
                            .getChannel()
                            .sendMessage("**:x: Invalid MBTI type code!**")
                            .queue();
            }
        }

        if (args.length == 1) {
            new MbtiSummary(event);

        } else {

            if (Type.list.contains(args[1])) {
                Type.setFsDescription();

                event
                        .getChannel()
                        .sendMessage(EmbedMessage.create(Type.type, Type.letters
                                        + "\n```" + "Function Stack " + Type.functionStack + "```"
                                        + "\nRole: " + Type.role +
                                        "\n\nPopulation:\n" + Type.percentage + "\n" + "```" + Type.percentageBar + "```"
                                        + "\nDescription:\n\n" + "`" + Type.description + "`" + "\n"

                                , Type.color, null, Type.url, null).setFooter("16 Personalities",
                                ImageURL.logo).addField(new MessageEmbed.Field("`" + "Read more at" + "`", "https://www.16personalities.com" + "/" + Type.type.toLowerCase() + "-personality", true)).build())
                        .queue();
            } else {
                event
                        .getChannel()
                        .sendMessage(":x: Invalid usage! Unknown MBTI type! Use lowercase letters or use &mbti help for more info!****")
                        .queue();
            }
        }
    }


    public Mbti (GuildMessageReceivedEvent event) {
        super(event);
    }
}



