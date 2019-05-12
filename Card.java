public class Card implements Comparable
{
    public static final String FACES[] = {"NOT USED","ACE","TWO","THREE","FOUR","FIVE","SIX","SEVEN","EIGHT","NINE","TEN","JACK","QUEEN","KING"};
    private String suit;
    private int face;
    public Card( String s, int f)
    {
        suit = s;
        face = f;
    }

    public void setFace( int f)
    {
        face = f;
    }

    public void setSuit( String s)
    {
        suit = s;
    }

    public String getSuit()
    {
        return suit;
    }

    public int getFace()
    {
        return face;
    }

    public int getValue()
    {
        if( getFace() == 1 )
        {
            return 1;
        }
        if(getFace() > 10)
        {
            return 10;
        }
        return getFace();
    }

    public int compareTo(Object o) {
        Card other = (Card) o;
        return this.getValue() - other.getValue();
    }

    public String toString()
    {
        return FACES[face] + " of " + suit;
    }
}