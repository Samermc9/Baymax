package com.samermc9.discordBot;

import com.samermc9.discordBot.assets.GifURL;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class EventHandler extends ListenerAdapter {

    private final String PREFIX = "&";
    private Random random = new Random();


    private void deleteMessages(TextChannel channel, int amountOfMesssages) {
        MessageHistory history = new MessageHistory(channel);

        List<Message> msgs = history
                .retrievePast(amountOfMesssages)
                .complete();

        channel
                .deleteMessages(msgs)
                .queue();
    }

    public boolean checkArgs(int min, int max, int length) {
        return length < max && length > min;
    }

    private EmbedBuilder embedMessage(String title, String description, Color color, String footer, String imageURL) {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder
                .setTitle(title)
                .setColor(color)
                .setFooter(footer, null)
                .setThumbnail(imageURL)
                .setDescription(description);

        return embedBuilder;
    }


    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        String[] args = event.getMessage().getContentRaw().split(" ");

        StringBuilder sb = new StringBuilder();
        for (String s : args) {
            sb.append(s);
        }

        String msg = sb.toString();


        if (event.getAuthor().isBot()) {
            return;
        }

            //HELP COMMAND (!help) - GENERAL OUTLINE OF COMMANDS
            if (msg.startsWith(PREFIX + "help")) {

                if (args.length > 1) {
                    event
                            .getChannel()
                            .sendMessage("**:x: Invalid usage: too many [args]**")
                            .queue();

                } else {

                    event
                            .getChannel()
                            .sendMessage(embedMessage("Help Commands",
                                    "List of commands available: ```online, members, info, dice, delete, hug, kill, surrealmemes```",
                                    new Color(230, 0, 50), "Use all commands with prefix &", null).build())
                            .queue();
                }


                //HUG COMMAND (!hug user) - SENDS A HUG MESSAGE
            } else if (msg.startsWith(PREFIX + "hug")) {

                if (args.length < 2) {
                    event
                            .getChannel()
                            .sendMessage("**:x: Invalid usage, too few [args]**")
                            .queue();
                } else if (args.length > 2) {
                    event
                            .getChannel()
                            .sendMessage("**:x: Invalid usage, too many [args]**")
                            .queue();
                } else {
                    String member = event.getMessage().getMentionedMembers().get(0).getAsMention();
                    event
                            .getChannel()
                            .sendMessage(event.getAuthor().getAsMention() + " hugs " + member)
                            .queue();

                    event
                            .getChannel()
                            .sendMessage("https://cdn.discordapp.com/attachments/386194586285899781/483310567944355870/image0.gif")
                            .queue();
                }


                //SLAP COMMAND (!slap user) - SENDS A SLAP GIF AND A MESSAGE
            } else if (msg.startsWith(PREFIX + "slap")) {
                if (args.length < 2) {
                    event
                            .getChannel()
                            .sendMessage("**:x: Invalid usage, too few [args]**")
                            .queue();

                } else if (args.length > 2) {
                    event
                            .getChannel()
                            .sendMessage("**:x: Invalid usage, too many [args]**")
                            .queue();

                } else {

                    String slapGif = GifURL.getRndmSlap();

                    String member = event.getMessage().getMentionedMembers().get(0).getAsMention();
                        event
                                .getChannel()
                                .sendMessage( event.getAuthor().getAsMention() + (slapGif.equals(GifURL.SLAP1) ? " spiCy kImcHi SlaPs " : " slaps ")
                                        + member + "\n" + slapGif)
                                .queue();


                }


                //KILL COMMAND (!kill user) - SENDS A RANDOM KILL GIF AND MESSAGE
            } else if (msg.startsWith(PREFIX + "kill")) {
                if (args.length < 2) {
                    event
                            .getChannel()
                            .sendMessage("**:x: Invalid usage, too few [args]**")
                            .queue();
                } else if (args.length > 2) {
                    event
                            .getChannel()
                            .sendMessage("**:x: Invalid usage, too many [args]**")
                            .queue();
                } else {
                    String member = event.getMessage().getMentionedMembers().get(0).getAsMention();
                    event
                            .getChannel()
                            .sendMessage(event.getAuthor().getAsMention() + " kills " + member)
                            .queue();

                    event
                            .getChannel()
                            .sendMessage("https://im.ziffdavisinternational.com/ign_br/screenshot/default/tumblr-lvuou1kmwj1qgcvsy_f8xm.gif")
                            .queue();
                }
            } else if (msg.startsWith(PREFIX + "info")) {
                if (args.length > 2) {
                    event
                            .getChannel()
                            .sendMessage("**:x: Invalid usage, too many [args]**")
                            .queue();
                } else {
                    event
                            .getChannel()
                            .sendMessage(embedMessage("Bot Info",
                                    "Total commands : 10\nDate of" +
                                            " creation: 24 August 2018\nPrefix used: '&'\nStill under development... baYMax Is ComInG",
                                    new Color(230, 0, 50),
                                    "Created by @Albus and @Samermc9", "https://imgur.com/a/vDxdW4W").build())
                            .queue();
                }
            }


            //MEMBERS COMMAND (!members) - CHECKS TOTAL AMOUNT OF MEMBERS IN GIVEN SERVER.
            else if (msg.startsWith(PREFIX + "members")) {

                if (args.length > 1) {
                    event
                            .getChannel()
                            .sendMessage("**:x: Invalid usage, too many [args]**")
                            .queue();

                } else {
                    event
                            .getChannel()
                            .sendMessage("**There are** " + event.getGuild().getMembers().size() + " **members in this server!**")
                            .queue();
                }
            }


            //DELETE COMMAND (!delete [amount]) - DELETES MESSAGES BASED ON AMOUNT INPUT, REQUIRES ADMIN
            else if (msg.startsWith(PREFIX + "delete")) {
                if (args.length < 2) {
                    event
                            .getChannel()
                            .sendMessage("**:x: Invalid usage, too few [args]**")
                            .queue();

                } else if (args.length > 2) {
                    event
                            .getChannel()
                            .sendMessage("**:x: Invalid usage, too many [args]**")
                            .queue();

                } else {
                    deleteMessages(event.getChannel(), Integer.parseInt(args[1]));
                }
            }


            //ONLINE COMMAND (!online) - CHECKS FOR MEMBERS THAT ARE IN ONLINE STATUS
            else if (msg.startsWith(PREFIX + "online")) {

                if (args.length > 1) {
                    event
                            .getChannel()
                            .sendMessage("**:x: Invalid usage, Too many [args]")
                            .queue();
                    System.out.println(msg);

                } else {

                    int online = 0;
                    for (int i = 0; i < event.getGuild().getMembers().size(); i++) {

                        if (event
                                .getGuild()
                                .getMembers()
                                .get(i)
                                .getOnlineStatus() == OnlineStatus.ONLINE) {
                            online++;
                        }
                    }

                    event
                            .getChannel()
                            .sendMessage("**There are " + online + " members online!**")
                            .queue();
                }


            } else if (msg.startsWith(PREFIX + "kick")) {
                if (args.length < 2) {
                    event
                            .getChannel()
                            .sendMessage("**:x: Invalid usage, too few [args]**")
                            .queue();
                } else if (args.length > 2) {
                    event
                            .getChannel()
                            .sendMessage("**:x: Invalid usage, too many [args]**")
                            .queue();
                } else {
                    Member member = event.getMessage().getMentionedMembers().get(0);
                    event
                            .getGuild()
                            .getController()
                            .kick(member)
                            .complete();
                }
            }


            //DICE COMMAND (!dice) - ROLLS A DICE WITH BOUNDS OF 1 - 6.
            else if (msg.startsWith(PREFIX + "dice")) {

                if (args.length > 1) {
                    event
                            .getChannel()
                            .sendMessage("**Invalid usage, too many [args]**")
                            .queue();

                } else {

                    int dice = random.nextInt(6);
                    event
                            .getChannel()
                            .sendMessage("**Now rolling a dice....**")
                            .queue();

                    if (dice < 4) {
                        event
                                .getChannel()
                                .sendMessage("**You rolled a " + dice + " ... Not your lucky day is it, " + event.getAuthor().getAsMention() + "**")
                                .queueAfter(2, TimeUnit.SECONDS);
                    } else if (dice > 4) {
                        event
                                .getChannel()
                                .sendMessage("**You rolled a " + dice + ", great job :smile:**")
                                .queue();
                    }
                }


            } else {

                if (msg.startsWith(PREFIX)) {

                    event
                            .getChannel()
                            .sendMessage("**:x: Invalid command! Not available - contact @Samermc9 for more info**")
                            .queue();
                }
            }
        }
    }







