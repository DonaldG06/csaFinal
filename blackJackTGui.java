import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.*;
import java.sql.Array;
import java.util.ArrayList;


public class blackJackTGui extends JFrame {
    int y = 0;
    int x = 0;
    JButton one = new JButton("1");
    JButton eleven = new JButton("11");

    ArrayList<File> handFile = new ArrayList<>();
    ArrayList<BufferedImage> handBuff = new ArrayList<>();
    ArrayList<ImageIcon> handIcon = new ArrayList<>();
    ArrayList<JLabel> hand = new ArrayList<>();
    ArrayList<File> houseFile = new ArrayList<>();
    ArrayList<BufferedImage> houseBuff = new ArrayList<>();
    ArrayList<ImageIcon> houseIcon = new ArrayList<>();
    ArrayList<JLabel> house = new ArrayList<>();
    JFrame frameH = new JFrame("Hand");
    JFrame frameHouse = new JFrame("House");

    public blackJackTGui() throws IOException {

        frameH.setLocation(0, 300);
        frameH.setSize(750, 600);
        frameH.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frameH.setLocation(0, 0);
        frameH.setVisible(true);
        one.setVisible(false);
        eleven.setVisible(false);
        frameH.add(one);
        frameH.add(eleven);


        frameHouse.setLocation(800, 300);
        frameHouse.setSize(750, 600);
        frameHouse.setVisible(true);
        frameHouse.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void newCard(String card, String suit) throws IOException {
        handFile.add(new File("gui/cards/" + suit + "/" + card));
        handBuff.add(ImageIO.read(handFile.get(x)));
        handIcon.add(new ImageIcon(handBuff.get(x)));
        hand.add(new JLabel(handIcon.get(x)));
        frameH.add(hand.get(x));
        x++;
    }

    public void houseCards(String card, String suit) throws IOException {
        houseFile.add(new File("gui/cards/" + suit + "/" + card));
        houseBuff.add(ImageIO.read(houseFile.get(y)));
        houseIcon.add(new ImageIcon(houseBuff.get(y)));
        house.add(new JLabel(houseIcon.get(y)));
        frameHouse.add(house.get(y));
        y++;
    }

    public boolean aceShow() {
        final boolean[] ace = new boolean[1];
        one.setBounds(0,0,200,50);  
        eleven.setBounds(100,0,200,50);
        one.setVisible(true);
        eleven.setVisible(true);
        one.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ace[0] = false;
            }
        });
        eleven.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ace[0] = true;
            }
        });
        return ace[0];
    }
}