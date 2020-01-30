package org.pz;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sounds {
    protected static final String AudioPlayer = null;

    private Clip pacBeginning = loadClip("/Sounds/pacman_beginning.wav");
    private Clip pacChomp = loadClip("/Sounds/pacman_chomp.wav");
    private Clip pacBigChomp = loadClip("/Sounds/pacman_bigchomp.wav");
    private Clip pacGhostEat = loadClip("/Sounds/pacman_eatghost.wav");
    private Clip pacDeath = loadClip("/Sounds/pacman_bigchomp.wav");
    private Clip pacFight = loadClip("/Sounds/pacman_fight.wav");

    public Sounds() {

    }

    private Clip loadClip(String filename) {
        Clip clip = null;

        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(getClass().getResource(filename));
            clip = AudioSystem.getClip();
            clip.open(audioIn);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (clip);

    }


    protected void playClip(int index) {

        if (index == 1) {
            stopClip(1);
            pacBeginning.start();
        } else if (index == 2) {
            if (!pacChomp.isRunning()) {
                stopClip(2);
                pacChomp.start();
            }
        } else if (index == 3) {
            if (!pacBigChomp.isRunning()) {
                pacBigChomp.start();
            }
            pacBigChomp.setFramePosition(0);

        } else if (index == 4) {
            if (!pacGhostEat.isRunning()) {
                stopClip(3);
                pacGhostEat.start();
            }
            pacGhostEat.setFramePosition(0);
        } else if (index == 5) {
            if (!pacDeath.isRunning()) {
                pacDeath.start();
            }
            pacDeath.setFramePosition(0);

        } else if (index == 6) {
            if (!pacFight.isRunning()) {
                pacFight.start();
            }
            pacFight.setFramePosition(0);

        }

    }

    private void stopClip(int index) {
        if (index == 1) {
            if (pacBeginning.isRunning())
                pacBeginning.stop();
            pacBeginning.setFramePosition(0);
        } else if (index == 2) {
            if (pacChomp.isRunning())
                pacChomp.stop();
            pacChomp.setFramePosition(0);
        }
    }

}
