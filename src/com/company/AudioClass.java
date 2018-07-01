package com.company;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

class AudioClass {
    static Clip clip,clip2;
    static void AudioClassCreateClick(String str) {
        String soundName;
        soundName = "src/com/company/Audio/"+str;
        AudioInputStream audioInputStream = null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
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
    }
}
