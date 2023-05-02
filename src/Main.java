
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Cards cards = new Cards();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Blackjack!");
        System.out.println("Here are the rules. Don't worry, it's a simple game:");
        DisplayRules();
        System.out.println("");
        System.out.println("Now you will choose whether you want to try your luck playing against the dealer, have a expectiminimax algorithm play against our dealer, or");
        System.out.println("have our Monte Carlo algorithm play against the dealer.");

        int MenuChoice = 0;
        while (MenuChoice != 4) {
            System.out.println("What would you like to do?");
            System.out.println("1. Play against the dealer.");
            System.out.println("2. Play with our Expectiminax algorithm.");
            System.out.println("3. Play with our Monte Carlo Algorithm.");
            System.out.println("4. Quit the game :(");
            System.out.println("5. Display the rules again.");
            System.out.println("6. Here are our tests for running each algorithm 100x");
            MenuChoice = scanner.nextInt();
            if (MenuChoice == 1) {
                int result = Play();
                if (result == 1){
                    System.out.println("Congrats! you have won!");
                }
                else if(result ==0){

                    System.out.println("You lost!");
                }
            }
            if (MenuChoice == 2) {
                double ans = Expectiminmax();
                if (ans == 1) {
                    System.out.println("Congratulations! The Expectiminimax algorithm won!");
                } else if (ans == 2) {
                    System.out.println("You tied with the dealer");
                } else {
                    System.out.println("Oof! You lost :(");
                }
            }
            if (MenuChoice == 3) {
                int ans = MonteCarlo();
                if(ans==1){
                    System.out.println("Congrats! The algorithm won on your behalf");
                }
                else{
                    System.out.println("Oof! You lost!");
                }
            }
            if(MenuChoice ==5){
                DisplayRules();
            }
            if(MenuChoice ==6){
                test();
            }
            else if (MenuChoice != 1 && MenuChoice != 2 && MenuChoice != 3 && MenuChoice != 4 && MenuChoice != 5 && MenuChoice !=6) {
                System.out.println("Please only enter from the options below.");
            }
        }
        System.out.print("Thanks for playing!");
    }

    // Method DisplayRules() describes the rules for generic blackjack
    public static void DisplayRules() {
        System.out.println("1. Dealer will hand you 2 cards. These cards can range from a value of 1 (A)");
        System.out.println("   all the way to a value of 10");
        System.out.println("2. The player, then, will decide if you would like to HIT (obtain another card) ");
        System.out.println("   or STAY (keep your cards).)");
        System.out.println("3. The dealer (our little bot) will then count up your cards. The player closest to 21 wins!");
        System.out.println("   (If you go over 21 with your sum of cards, you automatically lose!)");
        System.out.println("");
    }

    // If user chooses option2, this method is called for the epectiminimax algorith to play against dealer
    public static double Expectiminmax(){
        Cards emCards = new Cards();
        //Cards dealCards = new Cards();
        ArrayList<Integer> emHand = new ArrayList<>();
        ArrayList<Integer> dealHand = new ArrayList<>();
        dealHand.add(emCards.getRandomCard());
        emHand.add(emCards.getRandomCard());
        dealHand.add(emCards.dealerCard());
        emHand.add(emCards.getRandomCard());
        Expectiminimax expectiminimax = new Expectiminimax();

        int emHandval=0;
        for(int i=0;i<emHand.size();i++){
            emHandval+=emHand.get(i);
        }
        int dealHandval=0;

        for(int i=0;i<dealHand.size();i++){
            dealHandval+=dealHand.get(i);
        }
        boolean expectiminimaxChoice = expectiminimax.buildPlayerTree(emHand, dealHand);

            while(expectiminimaxChoice){

                if(emHandval==21){
                    expectiminimaxChoice=false;
                    return 1;
                }
                else if(emHandval>21){
                    expectiminimaxChoice=false;
                    return 0;
                }
                else{

                    int emrand = emCards.onlygetRandomCard();
                    emHand.add(emrand);

                    if(expectiminimax.buildPlayerTree(emHand, dealHand)==false){
                        //the user busts if they decide to ht. THerefore, they stay.
                        emHand.remove(emHand.size()-1);
                        expectiminimaxChoice=false;

                    }
                    else {
                        //we decide to hit here.
                       // emHand.add(emrand);
                        emHandval += emrand;
                        expectiminimaxChoice = expectiminimax.buildPlayerTree(emHand, dealHand);
                    }
                }
                System.out.println("EMHAND VAL"+emHandval);

            }
            while(dealHandval<emCards.getTotal()&&dealHandval<=21){

                //add a card to deal cards
                int rand = emCards.getRandomCard();

                System.out.println("DealHand: "+dealHandval);

                if(dealHandval>emHandval&&dealHandval<=21){
                    //dealHand is bigger, dealer wins, player loses.
                    return 0;
                }
                dealHand.add(rand);
                dealHandval+=rand;

                System.out.println("DealHand: "+dealHandval);
                if(dealHandval>emHandval&&dealHandval<=21){
                    //dealHand is bigger, dealer wins, player loses.
                    return 0;
                }

            }

            System.out.println("The deal hand value is "+ dealHandval);
            System.out.println("The player hand value is " + emHandval);
            if(dealHandval>emHandval&&dealHandval<=21) {
                return 0;
            }
            else{
                return 1;
            }
        }

        // Method MonteCarlo() plays automatically between the built monte carlo algorithm against the dealer
        public static int MonteCarlo() {
            MonteCarlo monteCarlo = new MonteCarlo();
            boolean monteCarloChoice = true;
            Cards mcCards = new Cards();

            ArrayList<Integer> mcHand = new ArrayList<>();
            ArrayList<Integer> dealHand = new ArrayList<>();
            dealHand.add(mcCards.getRandomCard());
            mcHand.add(mcCards.getRandomCard());
            dealHand.add(mcCards.dealerCard());
            mcHand.add(mcCards.getRandomCard());

            int mcHandval = 0;
            for (int i = 0; i < mcHand.size(); i++) {
                mcHandval += mcHand.get(i);
            }

            int dealHandval = 0;

            for (int i = 0; i < dealHand.size(); i++) {
                dealHandval += dealHand.get(i);
            }
            while (monteCarloChoice) {
                if (mcHandval == 21) {
                    return 1;
                } else if (mcHandval > 21) {
                    monteCarloChoice = false;
                    return 0;
                } else {
                    int trialsMC = 100;
                    while (monteCarloChoice) {
                        if (monteCarlo.monteCarloSimulationHelper(mcHand, dealHand, trialsMC) >= .5) {
                            //this means we want to hit.
                            int rand = mcCards.getRandomCard();
                            mcHand.add(rand);

                            mcHandval+=rand;
                            if(mcHandval<21) {
                                monteCarloChoice = true;

                            }
                            else{
                                monteCarloChoice = false;
                            }
                        } else {
                            //this means we do not want to hit. we want o stay
                            monteCarloChoice = false;
                            //System.out.println("The montecarlo simnulation says we should stay");
                        }
                    }
                }
            }

            while(dealHandval<=mcHandval){
                int rand = mcCards.getRandomCard();
                System.out.println("The dealer hand value is "+ dealHandval);

                dealHand.add(rand);
                dealHandval+=rand;
            }
            System.out.println("The dealer hand value is "+ dealHandval);
            System.out.println("The player hand value is "+ mcHandval);
            if(dealHandval>21){
                return 1;
            }
            else if(dealHandval>mcHandval){
                //deal hand busts
                return 0;
            }
            else{
                return 1;
            }

        }


    // Method Play() allows the user to play against the dealer, no AIs are involved
    public static int Play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You will now play against the dealer.");
        System.out.println("Good luck!");
        System.out.println("You are handed two cards:");
        Cards playerCards = new Cards();
        int firstPCard = playerCards.getRandomCard();
        int secondPCard = playerCards.getRandomCard();
        int handTotal = 0;
        System.out.println("The dealer handed you a " + firstPCard + ", and a " + secondPCard + ".");
        handTotal = firstPCard + secondPCard;
        System.out.println("The dealer will now draw two cards, but one of them will not be revealed to you.");
        int firstDCard = playerCards.faceCard();
        int secondDCard = playerCards.dealerCard();
        System.out.println("The dealer drew a " + firstDCard + ", and an additional card that is facing down.");
        int playerChoice = 100;
        while (playerChoice != 0){
            System.out.println("Your card total is now: " + handTotal);
            System.out.println("Now, would you like to hit(1), or stay(0)?");
            playerChoice = scanner.nextInt();
            if (playerChoice == 1){
                int newCard = playerCards.getRandomCard();
                System.out.println("The dealer drew you the card: "+ newCard);
                handTotal += newCard;
            }
            if (handTotal > 21){
                System.out.println("You busted :(");
                return 0;
            }
            else if(handTotal == 21){
                System.out.println("YOU HIT A BLACKJACK!!!");
                return 1;
            }
        }
        System.out.println("Now the dealer will reveal his cards and try to beat you.");
        System.out.println("The dealers cards were: " + firstDCard + " and " + secondDCard + "(the hidden card.)");
        int dealerTotal = firstDCard + secondDCard;
        while(dealerTotal <= handTotal){
            System.out.println("The dealer's total is now " + dealerTotal);
            System.out.println("The dealer will now hit.)");
            int newDealerCard = playerCards.faceCard();
            dealerTotal += newDealerCard;
            System.out.println("The dealer drew the card: "+ newDealerCard);
        }
        if (dealerTotal ==21){
            System.out.println("The dealer hit a blackjack!");
            return 0;
        }
        else if(dealerTotal > 21){
            System.out.println("The dealer busted!");
            return 1;
        }
        else if(dealerTotal > handTotal){
            System.out.println("The dealer's hand value is greater than yours! The dealer's hand is " + dealerTotal +", yours is "+ handTotal);
            return 0;
        }
        else{
            return 0;
        }
    }




        // test() is used to compare both AIs when both AIs play 100 times
        public static void test(){
        double num =100;//100 tests
            double winsEC =0;
            double winsMC =0;
            for(int i=0;i<num;i++){
                winsEC+=Expectiminmax();
               winsMC+=MonteCarlo();
            }


         System.out.println("Winning percentage for Exp: "+ winsEC/num);
        System.out.println("Winning percentage for Monte Carlo: "+(double) winsMC/num);
        }


    }
