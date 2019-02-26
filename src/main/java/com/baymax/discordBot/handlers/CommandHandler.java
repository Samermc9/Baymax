package com.baymax.discordBot.handlers;

import com.baymax.discordBot.Main;
import com.baymax.discordBot.commands.Commands;
import com.baymax.discordBot.commands.fun.*;
import com.baymax.discordBot.commands.general.Ban;
import com.baymax.discordBot.commands.general.Kick;
import com.baymax.discordBot.commands.info.*;
import com.baymax.discordBot.devUtils.ConsoleLog;
import com.baymax.discordBot.commands.dev.Sudo;
import com.baymax.discordBot.commands.info.Invite;
import com.baymax.discordBot.commands.mbti.Mbti;
import com.baymax.discordBot.commands.general.DeleteMessages;
import com.baymax.discordBot.commands.fun.HugMessage;
import com.baymax.discordBot.commands.fun.KillMessage;
import com.baymax.discordBot.commands.fun.SlapMessage;
import com.baymax.discordBot.commands.info.UserProfile;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class CommandHandler {
    private static final String PREFIX = "&";
    public static String[] args;

    CommandHandler (GuildMessageReceivedEvent event) {
        args = event
                .getMessage()
                .getContentRaw()
                .split(" ");

        if (event.getAuthor().isBot()) {
            return;
        }

        new ConsoleLog(event);

        switch (PREFIX + args[0]) {
            case PREFIX + "help":
                new Help(event);
                break;

            case PREFIX + "sudo":
                Sudo.isRunning = true;
                new Thread(() -> new Sudo(event)).start();
                break;

            case PREFIX + "roles":
                new Roles(event);
                break;

            case PREFIX + "shutdown":
                Main.jda.shutdownNow();
                break;

            case PREFIX + "kick":
                new Kick(event);
                break;

            case PREFIX + "ban":
                new Ban(event);
                break;

            case PREFIX + "sudostop":
                Sudo.isRunning = false;
                event
                        .getChannel()
                        .sendMessage("**Sudo deactivated! :stuck_out_tongue:**").queue();
                break;

            case PREFIX + "surrealmemes":
                new SurrealMemes(event);
                break;

            case PREFIX + "dab":
                new Dab(event);
                break;

            case PREFIX + "mbti":
                new Mbti(event);
                break;

            case PREFIX + "profile":
                new UserProfile(event);
                break;

            case PREFIX + "whip":
                new Whip(event);
                break;

            case PREFIX + "hug":
                new HugMessage(event);
                break;

            case PREFIX + "slap":
                new SlapMessage(event);
                break;

            case PREFIX + "kill":
                new KillMessage(event);
                break;

            case PREFIX + "match":
                new Match(event);
                break;

            case PREFIX + "info":
                new Info(event);
                break;

            case PREFIX + "members":
                new Members(event);
                break;

            case PREFIX + "zalgo":
                new Zalgo(event);
                break;

            case PREFIX + "robloxmemes":
                new RobloxMemes(event);
                break;

            case PREFIX + "invite":
                new Invite(event);
                break;

            case PREFIX + "delete":
                new DeleteMessages(event);
                break;

            case PREFIX + "online":
                new Online(event);
                break;

            case PREFIX + "dice":
                new Dice(event);
                break;

            case PREFIX + "helpdm":
                new HelpDirect(event.getAuthor());
                break;

            case PREFIX + "8ball":
                new EightBall(event);
                break;

            case PREFIX + "rps":
                break;

            case PREFIX + "rockpaperscissors":
                break;

            case PREFIX + "labyrnith":
                break;

                default:
                    Commands.UNKNOWN_COMMAND(event);
        }
    }
}
