import java.util.ArrayList;

public class RackoGame
{
    // private instance variables
    private ArrayList<Integer> deck;
    private ArrayList<Integer> discardPile;
    private int[] playerHand;
    private int[] computerHand;
    private int deckSize;

    public RackoGame()
    {
        deckSize = 60;
        deck = new ArrayList<Integer>();
        discardPile = new ArrayList<Integer>();
        playerHand = new int [10];
        computerHand = new int [10];
        createDeck(deck, deckSize);
        for(int i=0; i<10; i++){
            playerHand[i] = deck.remove(0);
            computerHand[i] = deck.remove(0);
        }
        discardPile.add(deck.remove(0));
    }
    
    public void makeMove(int newCardValue, int handIndex, int[] hand)
    {
        int discard = hand[handIndex];
        hand[handIndex] = newCardValue;
        discardPile.add(discard);
        if (deck.size() == 1){
            resetDiscardPileAndReshuffle();
        }
    }
    
    public boolean playerWins()
    {
        for (int i = 0; i < playerHand.length - 1; i++){
            if (playerHand[i] > playerHand[i + 1]) {
                return (false);
            }
        }
        return (true);
    }
    
    public boolean computerWins()
    {
        for (int i = 0; i < computerHand.length - 1; i++){
            if (computerHand[i] > computerHand[i + 1]) {
                return (false);
            }
        }
        return (true);
    }
    
    public int removeTopCardFromDeck()
    {
        return (deck.remove(0));
    }
    
    public int removeTopCardFromDiscardPile()
    {
        return (discardPile.remove(0));
    }
    
    public int peekAtTopCardFromDiscardPile()
    {
        return (discardPile.get(0));
    }
    
    public int[] getPlayerHand()
    {
        return (playerHand);
    }
    
    public int[] getComputerHand()
    {
        return (computerHand);
    }

    public void resetDiscardPileAndReshuffle(){
        for (int i = 0; i < discardPile.size() - 1; i++){
            deck.add(discardPile.remove(i));
        }
        shuffleDeck();
    }

    public void createDeck(ArrayList<Integer> deck, int deckSize) {
        for (int i = 1; i < deckSize + 1; i++) {
            deck.add(i);
        }
        shuffleDeck();
    }
    
    public void shuffleDeck (){
        for(int i=0; i<deck.size(); i++)
        {
            int position = (int)(Math.random() * 60);
            int placeholder = deck.get(position);
            deck.set(position, deck.get(i));
            deck.set(i, placeholder);
        }
    }
}
