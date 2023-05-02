import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.LinkedList;

public class Expectiminimax {


//returns whether or not the player will win, given their hand and the number of careds remianinng in the deck.
// the dealer's results in the game will be the ecact opposite of this result.
    public boolean buildPlayerTree (ArrayList<Integer> emHand, ArrayList<Integer> dealHand) {
        //total val must be updated everytime a node is traversed within the tree.

        Cards cards = new Cards();
        //The buildPlayerTree builds the tree for it to be used in main
        //If the boolean returns False, then it is a terminal node.
        //If the boolean returns True, then it is not a terminal node.
        //This formula is used in the Main class, and the Excpetiminimax algorithm is completed there.
        //Every time a card is removed from the Deck, the probability changes (based off the Cards class).

        for(int i=0;i<emHand.size();i++){
            cards.removespefCard(emHand.get(i));
        }

        for(int i=0;i<dealHand.size();i++){
            cards.removespefCard(dealHand.get(i));
        }

        double ans = 0.0;

        int totalval = 0;
        for (int i=0;i<emHand.size();i++) {
            totalval += emHand.get(i);
        }
        LinkedList<Integer> num = new LinkedList<>();
        num.add(totalval);
        nodes node = new nodes (totalval);

        //totalval is the root node.

        if (totalval>21) {
            //you bustm, stop here
            //player loses, return false
            ans = (double) totalval;
            return false;

        }
        else if (totalval==21) {
//you win, you don't have to congtinue to run the code, stop here, lead node
            //player wins
            ans = totalval;
            return false;

        }
        else {
            //decide whether to hit or stand
            //look at the expev yed value of the net card.
            int expval=0;
            for (int i=0;i<cards.getDeck().length;i++) {

                double prob = cards.getProb(cards.getDeck()[i]);

                expval+=cards.getDeck()[i]*prob;

            }
            int finalval =totalval+expval;


            if((totalval+expval)<=21) {
                //hit here
                //create new child node
                nodes child = new nodes(totalval+expval);
                child.setPrev(node);
                node.setNext(child);
                //emHand.add(cards.getRandomCard());
                return true;


            }
            else {
                //the resulting card will most likely force a bust, do not hit, stand.

                ans = totalval+expval;
                return false;

        }
            }
    }


    //if player is 0, represents that it is the players tunr, if 1, it represents the dealer's turn.
    // depth will either be 0 or 1. if 0, it represents that the node is at a terminal node, if 1, there are children.




    }




