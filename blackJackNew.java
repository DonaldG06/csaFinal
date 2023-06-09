import java.io.IOException;
import java.util.ArrayList;

public class blackJackNew {

    blackJackTGui cardsNew = new blackJackTGui();
    ArrayList <String> cards = new ArrayList <> ();
    private int chips = 100;
    private int handVal = 0;
    private String[] cardArray = {"jack","queen","king","ace"};
    private String[] suits = {"clubs","diamonds","hearts","spades"};
    private String suit;
    blackJackNew(String name, String bet) throws IOException {
        chips -= Integer.parseInt(bet);
        for(int i=0;i<2;i++)
            hit();
    }

    public void hit(){
        int s = (int) (Math.random()*4);
        suit = suits[s];
        int x = (int) (Math.random()*13)+2;
        if(x > 10){
            faces(x);
        }
        else{
            handVal += x;
            cards.add(String.valueOf(x));
        }

    }

    public void stay(){

    }

    public void faces(int x){
        if(x == 14){
            ace();
        }
        else {
            x -= 11;
            cards.add(cardArray[x]);
            handVal += 10;
        }
    }

    public void ace(){
        if(handVal < 11){
            handVal++;
        }
        else{
            cardsNew.aceShow();
        }
    }

    public int getHandVal(){
        return handVal;
    }

}
