package bjFinal;

import java.io.IOException;

public class blackJackNew {
    int z = 0;

    blackJackTGui cardsNew = new blackJackTGui();
    private int chips = 100;
    private int handVal = 0;
    private String[] cardArray = {"jack","queen","king","ace"};
    private String[] suits = {"clubs","diamonds","hearts","spades"};
    private String suit;
    blackJackNew(String name, String bet) throws IOException {
        chips -= Integer.parseInt(bet);
        //for(int i=0;i<2;i++)
            //hit();
    }

    public void hit() throws IOException {
        int s = (int) (Math.random()*4);
        suit = suits[s];
        int x = (int) (Math.random()*13)+2;
        if(x > 10){
            faces(x);
        }
        else{
            handVal += x;
            cardsNew.newCard(String.valueOf(x),suit,handVal,z);
        }
        z++;
    }

    public void stay(){

    }

    public void faces(int x) throws IOException{

        if(x == 14){ ace(); }

        x-=11;

        if(x!= 14){ handVal += 10; }

        cardsNew.newCard(cardArray[x],suit,handVal,z);


    }

    public void ace() throws IOException {
        if(handVal < 11){ handVal++; }
        else {
            if (cardsNew.aceShow()) {
                handVal += 11;
            } else if (!(cardsNew.aceShow()))   {
                handVal++;
            }
        }
    }

    public int getHandVal(){ return handVal; }

}
