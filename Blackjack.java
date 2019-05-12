import java.util.*;
public class Blackjack
{   
    Deck originalDeck;
    Deck yourDeck;
    Deck computerDeck;

    public Blackjack()
    {   
        originalDeck = new Deck();
        yourDeck = new Deck();
        computerDeck = new Deck();
    }

    public void distribute () 
    {
        yourDeck.addCard(originalDeck.dealCard());
        computerDeck.addCard(originalDeck.dealCard());
    }

    public void initializeGame () {
        originalDeck.initializeDeck(); 
        originalDeck.shuffle();
        distribute();
        System.out.println("Computer " + computerDeck+"(2nd card is not shown)");
        distribute();
        System.out.println("Player " + yourDeck);
    }

    public void playTurn () {
        System.out.println("what do you want to do? (please type hit or stay)");
        Scanner keyboard = new Scanner(System.in);
        if(keyboard.nextLine().equals("hit")) {
            yourDeck.addCard(originalDeck.dealCard());
            System.out.println(yourDeck);
            if(yourDeck.getSum() > 21)
            {
                System.out.println("Computer: "+computerDeck.getSum() + " You: "+yourDeck.getSum());
                System.out.println("BUSTED! You Lose!");
            }
            else if (yourDeck.getSum()==21)
            {
                System.out.println("Computer: "+computerDeck.getSum() + " You: "+yourDeck.getSum());
                System.out.println("BLACKJACK! You Win!");
            }
            else
            {
                playTurn();
            }
        } else {
            while (computerDeck.getSum() < 17)
            {
                computerDeck.addCard(originalDeck.dealCard());
            }
            if(computerDeck.getSum() > 21)
            {
                System.out.println("Computer: "+computerDeck.getSum() + " You: "+yourDeck.getSum());
                System.out.println("COMPUTER BUSTED! You Win!");
            } else {
                if (yourDeck.getSum() > computerDeck.getSum())
                {
                    System.out.println("Computer: "+computerDeck.getSum() + " You: "+yourDeck.getSum());
                    System.out.println("You Win!");
                } 
                else if(yourDeck.getSum() < computerDeck.getSum())
                {
                    System.out.println("Computer: "+computerDeck.getSum() + " You: "+yourDeck.getSum());
                    if(computerDeck.getSum() == 21)
                    {
                        System.out.println ("Computer gets a Blackjack!");
                    }
                    System.out.println("Computer Wins!");
                }
                else
                {
                    System.out.println("Computer: "+computerDeck.getSum() + " You: "+yourDeck.getSum());
                    System.out.println("Tie!");
                }
            }
        }
    }

    public void playGame () 
    {
        playTurn();
        System.out.println ("Your "+yourDeck);
        System.out.println ("Computer's "+computerDeck);           
    }

    public void start ()
    {
        initializeGame();
        playGame();
    }
}
