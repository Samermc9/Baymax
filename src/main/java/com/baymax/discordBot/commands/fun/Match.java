package com.baymax.discordBot.commands.fun;


import com.baymax.discordBot.commands.Commands;
import com.baymax.discordBot.handlers.CommandHandler;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.util.Random;

public class Match extends Commands {

    @Override
    public String[] getUsage() {
        return new String[]{
                "match <user1> <user2>"
        };
    }

    @Override
    public String getDescription() {
        return "Matches the two specified users, giving a compatibility meter from 0 to 100";
    }

    @Override
    public void execute(GuildMessageReceivedEvent event) {
        if (args.length < 3) {
            ARGS_UNDER(event);
        }

        else if (args.length > 3) {
            ARGS_OVER(event);
        }

        else {
            if (args[1].equals(args[2])) {
                event
                        .getChannel()
                        .sendMessage("**:x: As sad as it can be, you can't match yourself!**")
                        .queue();
            } else {

                Random random = new Random();
                String inputUser = event
                        .getMessage()
                        .getMentionedMembers()
                        .get(0)
                        .getAsMention();

                String mentionedUser = event
                        .getMessage()
                        .getMentionedMembers()
                        .get(1)
                        .getAsMention();

                int friendshipMeter = random.nextInt(100);

                if (friendshipMeter <= 50) {

                    event
                            .getChannel()
                            .sendMessage(inputUser + "** has a " + friendshipMeter + "% match with " + mentionedUser + " .  Not the best pair are you?** :pensive: :broken_heart:")
                            .queue();
                } else {
                    event
                            .getChannel()
                            .sendMessage(inputUser + "** has a " + friendshipMeter + "% match with " + mentionedUser + ".  It's a match made in heaven! :smile:**")
                            .queue();
                }
            }
        }
    }

    public Match (GuildMessageReceivedEvent event) {
        super(event);
    }
}
