package Classes;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class MusicPlayer {

    public static void musicPlayer(){
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("epic_battle_music_1-6275.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-10.0f); // Reduce volume by 10 decibels
            clip.start();
        } catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            System.out.println("Error with playing sound.");
        }
    }
}