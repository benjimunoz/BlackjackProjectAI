# BlackjackProjectAI
This program runs a game of Blackjack. The instances of the Blackjack game depends on the user input when the UI is presented. 

Initial UI
The initial UI presents the user with the rules of Blackjack, and basic instructions on how to use our program. The entirety of the game is ran by entering 
then numbers for choices displayed at any point user input is given. 


Home Page
The home page will always be displayed. Unless the number 4 is entered in the console, the code will always be ran back to this homepage.

Deck
The deck contains every card that would usually be used in Blackjack(everything except for Jacks)
* ACE IS ASSUMED TO ALWAYS BE A VALUE OF 1.

**********
THE DECK WILL BE SHUFFLED BEFORE EVERY GAME
**********

Dealer
The dealer will always play. The dealer draws from our Card() class' Deck[], which is an array list of every card in blackjack. 
The player (or algorithm) will be able to "hit" until it busts (value greater than 21). If the player does not exceed 21 and chooses to "stay", the dealer will hit until it either busts or has a value greater than the players. If the dealer gets to a hand value higher than the
player, then the dealer wins. If the player busts, the dealer does not even get to make a move, as the player is automatically assigned a loss. 
* In any case, THE DEALER WILL CONTINUE TO HIT UNTIL A WIN OR LOSS IS ASSIGNNED TO THE PLAYER.

1. Play()
If the user decides to play, the user will be presented with two initial cards. The player will now play a game of Blackjack against a dealer.
The player is presented with the choices Stay(0), or hit(1).

2. Expectiminimax()
The Expectiminimax option will run a Blackjack game against a dealer using our Expectiminimax() class. The expectiminimax class will determine an expected
value, which is a potential card. That potential card will determine the algorithm's decision of staying(0) or hitting(1). The algorithm will only hit if
that expected value will get them to a value less than or equal to 21. The game then runs by itself, showing the user the cards and hand values of the
algorithm and the dealer along as the game is played until a winner is decided.

3. MonteCarlo()
The Monte Carlo option will run a Blackjack game against a dealer using our MonteCarlo() class. The Monte Carlo class will take the cards within the
player's hand to the algorithm, and run a simulation of a Blackjack game with those cards where it will hit a given amount of times(100). Based on how
many times it won by adding a card to the player's hand, the algorithm will then decide if its wise to hit(1) or to stay(2). The agorithm will continue
to run as long as it keeps hitting(1), or if it chooses to stay(2) or busts.

4. Quit()
The quit option will display a "Thank you for playing!" message before finishing the code.

5. Displayrules()
This option will allow the player to see the rules of our game again. This class is called at the beginning of the program to display the rules
before any game is chosen to be played.

6. test()
This option will run through 200 games of Blackjack. 100 games using the Expectiminimax algorithm, and 100 games using the MonteCarlo algorithm.
The test() function will then display the winning percentage out of those 100 times for each algorithm. The user will then be able to compare those two
winning percentages to determine which algorithm gives a better chance of winning.
