/**package com.baymax.discordBot.music;

import com.baymax.discordBot.commands.Commands;
import com.sedmelluq.discord.lavaplayer.player.AudioLoadResultHandler;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException;
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import net.dv8tion.jda.core.audio.AudioSendHandler;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.managers.AudioManager;

import java.awt.*;

public class MusicCommand extends Commands {

    private final String PREFIX = "&";
    private static final AudioPlayerManager manager = new DefaultAudioPlayerManager();

    @Override
    public String[] getUsage() {
        return new String[0];
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public void execute(GuildMessageReceivedEvent event) {
        AudioManager manager = event.getGuild().getAudioManager();
        AudioPlayer p = createPlayer(event.getGuild(), event);
        AudioHandler h = new AudioHandler(p);


        manager.openAudioConnection(event.getGuild().getVoiceChannels().get(0));
        manager.setSendingHandler(h);

        loadTrack(event, event.getMember(), manager);

    }

    public MusicCommand (GuildMessageReceivedEvent event) {
        super(event);
    }


    private void loadTrack (GuildMessageReceivedEvent event, Member author, AudioManager mng) {
        if (author.getVoiceState().getChannel() == null)
            event
                    .getChannel()
                    .sendMessage("**You are not in a voice channel!**")
                    .queue();

        else {
            manager.loadItemOrdered(mng, args[1], new AudioLoadResultHandler() {

                @Override
                public void trackLoaded (AudioTrack audioTrack) {
                    createPlayer(event.getGuild(), event).playTrack(audioTrack);
                }

                @Override
                public void playlistLoaded (AudioPlaylist audioPlaylist) {

                }

                @Override
                public void noMatches() {
                    event
                            .getChannel()
                            .sendMessage("**No matches found!, Try again**")
                            .queue();
                }

                @Override
                public void loadFailed (FriendlyException e) {
                    event
                            .getChannel()
                            .sendMessage(e.toString())
                            .queue();
                }
            });
        }
    }

    private AudioPlayer createPlayer (Guild guild, GuildMessageReceivedEvent event) {
        AudioPlayer player = manager.createPlayer();
        TrackManager manager = new TrackManager(player, event);
        player.addListener(manager);
        guild.getAudioManager().setSendingHandler(new AudioHandler(player));
        return player;
    }
}**/
