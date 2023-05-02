import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
public class Cards {
    Random random = new Random();
    int ace0fHearts = 1;
    int aceOfClubs = 1;
    int aceOfSpades = 1;
    int aceOfDiamonds = 1;

    int twoOfHearts = 2;
    int twoOfClubs = 2;
    int twoOfSpades = 2;
    int twoOfDiamonds = 2;

    int threeOfHearts = 3;
    int threeOfClubs = 3;
    int threeOfSpades = 3;
    int threeOfDiamonds = 3;

    int fourOfHearts = 4;
    int fourOfClubs = 4;
    int fourOfSpades = 4;
    int fourOfDiamonds = 4;

    int fiveOfHearts = 5;
    int fiveOfClubs = 5;
    int fiveOfSpades = 5;
    int fiveOfDiamonds = 5;

    int sixOfHearts = 6;
    int sixOfClubs = 6;
    int sixOfSpades = 6;
    int sixOfDiamonds = 6;

    int sevenOfHearts = 7;
    int sevenOfClubs = 7;
    int sevenOfSpades = 7;
    int sevenOfDiamonds = 7;

    int eightOfHearts = 8;
    int eightOfClubs = 8;
    int eightOfSpades = 8;
    int eightOfDiamonds = 8;

    int nineOfHearts = 9;
    int nineOfClubs = 9;
    int nineOfSpades = 9;
    int nineOfDiamonds = 9;

    int tenOfHearts = 10;
    int tenOfClubs = 10;
    int tenOfSpades = 10;
    int tenOfDiamonds = 10;

    int queenOfHearts = 10;
    int queenOfClubs = 10;
    int queenOfSpades = 10;
    int queenOfDiamonds = 10;

    int kingOfHearts = 10;
    int kingOfClubs = 10;
    int kingOfSpades = 10;
    int kingOfDiamonds = 10;

    int[] originalDeck = {aceOfDiamonds,ace0fHearts,aceOfClubs,aceOfSpades, twoOfClubs,twoOfDiamonds,twoOfHearts,twoOfSpades, threeOfClubs,threeOfDiamonds,threeOfHearts,threeOfSpades, fourOfClubs,fourOfDiamonds,fourOfHearts,fourOfSpades, fiveOfHearts,fiveOfSpades,fiveOfDiamonds,fiveOfClubs, sixOfClubs,sixOfDiamonds,sixOfHearts,sixOfSpades, sevenOfClubs,sevenOfDiamonds,sevenOfHearts,sevenOfSpades, eightOfClubs,eightOfDiamonds,eightOfHearts,eightOfSpades, nineOfClubs, nineOfDiamonds, nineOfHearts,nineOfSpades, queenOfClubs,queenOfDiamonds,queenOfHearts,queenOfSpades, kingOfClubs, kingOfDiamonds,kingOfHearts, kingOfSpades,  tenOfClubs, tenOfSpades, tenOfDiamonds, tenOfHearts};
    int[] Deck = originalDeck;
    int[] actualDeck = originalDeck;

    ArrayList<Integer> hand = new ArrayList<>();
    ArrayList <Integer> dealHand = new ArrayList<>();

public Cards() {
}

    public int getRandomCard(){

        int random = new Random().nextInt(actualDeck.length);
        int card = actualDeck[random];
        removeCard(random);
        hand.add(card);
        return card;
    }

    public int onlygetRandomCard(){

        int random = new Random().nextInt(actualDeck.length);
        int card = actualDeck[random];
        return card;
    }


    //removes the specific card with the given value, rather than then index, from the deck.
    public void removespefCard(int j){
    for(int i=0, k=0;i<Deck.length;i++){
        if(Deck[i]==j){
            k =1;
            removeCard(i);
            break;

        }
    }
    }

    public void removeCard(int j){
        int[] deck_new = new int[Deck.length-1];
        for(int i=0, k=0; i<Deck.length; i++) {
            if(i!=j){
                deck_new[k]=Deck[i];
                k++;
            }
        }
        Deck = deck_new;

        int[] newDeck = new int[actualDeck.length-1];
        for(int i=0, k=0; i<actualDeck.length; i++) {
            if(i!=j){
                newDeck[k]=actualDeck[i];
                k++;
            }
        }
        actualDeck = newDeck;
    }
    public int dealerCard(){
        int random = new Random().nextInt(Deck.length);
        int card = Deck[random];
        dealerRemoveCard(card);
        dealHand.add(card);
        return card;
    }
    private void dealerRemoveCard(int j){
        int[] deck_new = new int[actualDeck.length-1];
        for(int i=0, k=0; i<actualDeck.length; i++) {
            if(i!=j){
                deck_new[k]=actualDeck[i];
                k++;
            }
        }
        actualDeck = deck_new;
    }
    
    public int faceCard(){
        int random = new Random().nextInt(Deck.length);
        int card = Deck[random];
        removeCard(card);
        dealHand.add(card);
        return card;
    }
    

    public int[] getDeck(){
        return Deck;
    }


    public int getTotal(){
        int total = 0;
        for (int i = 0; i < hand.size(); i++){
            total += hand.get(i);
        }
        return total;
    }

    public double getProb(int val){
    //find out how often this value occurs within the remaining deck
        //find the frequenecy, divide by the total number of cards in remaining deck
        int freq =0;
        for(int i=0;i<Deck.length;i++){
            if(Deck[i]==val){
                freq++;
            }



        }
        double prob =freq/Deck.length;
        return prob;
    }

    }

