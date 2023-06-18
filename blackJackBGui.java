package bjFinal;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class blackJackBGui {
    private int y = 0;

    public boolean hitPerf;
    String fileName;



    private boolean audioStatus = false;
    private boolean hitStay = false;

    blackJackBGui(String fileName) {
        this.fileName = fileName;
        JPanel panel = new JPanel();
        JFrame bFrame = new JFrame();
        bFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        bFrame.setSize(1600, 215);
        bFrame.setLocation(0, 0);
        bFrame.setVisible(true);
        JButton play = new JButton("Play");
        JButton stay = new JButton("Stay");
        JButton hit = new JButton("Hit");
        JButton raise = new JButton("Raise");
        JButton test = new JButton();
        play.setBounds(0, 0, 520, 200);
        stay.setBounds(533, 0, 520, 200);
        hit.setBounds(1066, 0, 520, 200);
        test.setBounds(1500,0,0,0);
        test.setVisible(false);
        bFrame.add(play);
        bFrame.add(stay);
        bFrame.add(hit);
        bFrame.add(test);



        play.addActionListener(p ->{
            try {
                audioMain(fileName);
            } catch (UnsupportedAudioFileException ex) {
                throw new RuntimeException(ex);
            } catch (LineUnavailableException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            finally{
                play.setVisible(false);
                stay.setBounds(0,0,750,200);
                hit.setBounds(850,0,750,200);

            }

        });
        stay.addActionListener(q -> {
            stay();
        });
        hit.addActionListener(x -> {
            hit();
        });

    }


    public void hit() {
        hitStay = true;
        hitPerf = true;
    }

    public void stay() {
        hitStay = false;
    }

    public boolean hitStay(){
        return hitStay;
    }

    public boolean actionHit(){ return hitPerf; }

    public void setHit(){ hitPerf = false; }



    public static void audioMain(String fileName) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File( "audioFolder/"+fileName));
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
    }


}
