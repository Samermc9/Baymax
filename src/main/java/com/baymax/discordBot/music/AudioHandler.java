package com.baymax.discordBot.music;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.track.playback.AudioFrame;
import net.dv8tion.jda.core.audio.AudioSendHandler;

public class AudioHandler implements AudioSendHandler {

    private final AudioPlayer player;
    private AudioFrame frame;

    public AudioHandler (AudioPlayer player) { //iniitialise player;
        this.player = player;
    }

    @Override
    public boolean canProvide() {
        if (frame == null) {
            frame = player.provide();
        }

        return frame != null;
    }

    @Override
    public byte[] provide20MsAudio() {
        if (frame == null) {
            frame = player.provide();
        }

        byte[] data = frame != null ? frame.getData() : null;
        frame = null;
        return data;
    }

    @Override
    public boolean isOpus() {
        return true;
    }
}
