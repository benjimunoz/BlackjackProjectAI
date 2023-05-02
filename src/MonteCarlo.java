import java.util.ArrayList;
import java.util.Arrays;

public class MonteCarlo {




    public double monteCarloSimulationHelper(ArrayList<Integer> mcHand, ArrayList<Integer> dealHand, double numtrials) {

        Cards cards = new Cards();
        for (int i = 0; i < mcHand.size(); i++) {
            cards.removespefCard(mcHand.get(i));
        }
        for (int i = 0; i < dealHand.size(); i++) {
            cards.removespefCard(dealHand.get(i));
        }
        double probability = mcHammer(mcHand, cards, numtrials);
        return probability;
    }


    //returns the probability of not busting whenever you hit divided by the total number of trials.
    public double mcHammer(ArrayList<Integer> mcHand, Cards cards, double numtrials) {
        double mcWINS = 0.0;
        int handTotal = 0;

        for (int i = 0; i < mcHand.size(); i++) {
            handTotal += mcHand.get(i);
        }

        for (int i = 0; i < numtrials; i++) {
            int tempTotal = handTotal + cards.onlygetRandomCard();
            if (tempTotal <= 21) {
                mcWINS++;
            }
        }

        return mcWINS / numtrials;

    }
}
