package com.company;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

class AudioClass {
    /*static Clip clip,clip2;
    static void AudioClassCreateClick(String str) {
        String soundName;
        soundName = "src/com/company/Audio/"+str;
        AudioInputStream audioInputStream = null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File(String.valueOf(AudioClass.class.getResourceAsStream("/com/company/Audio/click.wav"))));
            BufferedInputStream buff = new BufferedInputStream(audioInputStream);
            audioInputStream = new AudioInputStream(buff,audioInputStream.getFormat(),audioInputStream.getFrameLength());
            //File sound_ = new File(String.valueOf(AudioClass.class.getResourceAsStream("/com/company/Audio/click.wav")));
            //System.out.println(sound_.getPath());
            //audioInputStream = AudioSystem.getAudioInputStream(buff);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        clip2 = null;
        try {
            clip2 = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        try {
            clip2.open(audioInputStream);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        clip2.start();
    }*/
}
