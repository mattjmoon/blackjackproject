
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Deck
{
    public static final int NUMCARDS = 52;
    public static String[] SUITS = "CLUBS HEARTS DIAMONDS SPADES".split(" ");
    private List<Card> cards;

    public Deck()
    {
        cards = new ArrayList<Card>();
    }

    public void initializeDeck() 
    {
        for(String suit: SUITS)
        {
            for(int i = 1; i<Card.FACES.length; i++)
            {
                cards.add(new Card(suit,i));
            }
        }        
    }

    public int size () 
    {        
        return cards.size ();
    }

    public Card dealCard()
    {        
        Card firstCard = null;
        firstCard = cards.get(cards.size()-1);
        cards.remove(cards.get(cards.size()-1));
        return firstCard;
    }

    public void addCard (Card c) 
    {
        cards.add (0,c);
    }

    public void shuffle()
    {
        Collections.shuffle(cards);
    }

    public int getSum()
    {
        int sum = 0;
        for(Card card : cards)
        {
            sum += card.getValue();
        }
        return sum;
    }

    public String toString()
    {
        return "Deck :" + cards;
    }

}