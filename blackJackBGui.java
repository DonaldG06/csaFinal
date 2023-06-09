import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class blackJackBGui {
    private int y = 0;



    private boolean audioStatus = false;
    private boolean hitStay = false;

    blackJackBGui() {
        JFrame bFrame = new JFrame();
        bFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        bFrame.setSize(1600, 215);
        bFrame.setLocation(0, 0);
        bFrame.setVisible(true);
        JButton play = new JButton("Play/Pause");
        JButton stay = new JButton("Stay");
        JButton hit = new JButton("Hit");
        JButton raise = new JButton("Raise");
        play.setBounds(0, 0, 350, 200);
        stay.setBounds(400, 0, 350, 200);
        hit.setBounds(800, 0, 350, 200);
        raise.setBounds(1280, 0, 350, 200);

        bFrame.add(play);
        bFrame.add(stay);
        bFrame.add(hit);
        bFrame.add(raise);



        play.addActionListener(p ->{
            play();

            try {
                audioMain(y);
                y++;
            } catch (UnsupportedAudioFileException ex) {
                throw new RuntimeException(ex);
            } catch (LineUnavailableException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            finally{
                play.setVisible(false);
                stay.setBounds(50,0,450,200);
                hit.setBounds(600,0,450,200);
                raise.setBounds(1150,0,450,200);
            }

        });
        stay.addActionListener(q -> {
            stay();
            hitStay();
        });
        hit.addActionListener(x -> {
            hit();
            hitStay();
        });

    }

    public void pause() {
        audioStatus = false;
    }

    public void play() {
        audioStatus = true;
    }

    public void hit() {
        hitStay = true;
    }

    public void stay() {
        hitStay = false;
    }

    public boolean hitStay() {
        return hitStay;
    }

    public static void audioMain(int y) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("wonder.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();


    }


}