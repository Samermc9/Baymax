package com.baymax.discordBot.music;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.event.AudioEventAdapter;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import com.sedmelluq.discord.lavaplayer.track.AudioTrackEndReason;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.VoiceChannel;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class TrackManager extends AudioEventAdapter {

    private final AudioPlayer player;
    private final Queue<AudioInfo> queue;
    private final GuildMessageReceivedEvent event;
    private static final AudioPlayerManager manager = new DefaultAudioPlayerManager();

    public TrackManager (AudioPlayer player, GuildMessageReceivedEvent event) {
        this.player = player;
        this.queue = new LinkedBlockingQueue<>();
        this.event = event;
    }

    @Override
    public void onTrackStart(AudioPlayer player, AudioTrack track) {
        AudioInfo info = queue.element();

        VoiceChannel voiceChannel = info
                .getAuthor()
                .getVoiceState()
                .getChannel();

        if (voiceChannel == null) {
            player.stopTrack();
            event
                    .getChannel()
                    .sendMessage("**Player has stopped because there are no members in the voice channel!**")
                    .queue();
        }

        else {
            info
                    .getAuthor()
                    .getGuild()
                    .getAudioManager()
                    .openAudioConnection(voiceChannel);
            event
                    .getChannel()
                    .sendMessage("Connected to: " + voiceChannel.getName())
                    .queue();
        }
    }

    @Override
    public void onTrackEnd(AudioPlayer player, AudioTrack track, AudioTrackEndReason endReason) {
        Guild guild = Objects.requireNonNull(queue.poll()).getAuthor().getGuild();

        if (queue.isEmpty()) {
            guild.getAudioManager().closeAudioConnection();
        }

        else {
            player.playTrack(queue.element().getTrack());
        }
    }
}
