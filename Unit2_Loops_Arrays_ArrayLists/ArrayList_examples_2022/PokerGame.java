
import acm.program.*;
import java.util.ArrayList;

public class PokerGame extends ConsoleProgram
{
    
    public void run()
    {
        ArrayList<Card> deck = new ArrayList<Card>();
        for (int i = 0; i < 52; i++){
            int suit = i % 4;
            int rank = i % 13;
            Card card = new Card(rank, suit);
            deck.add(card);
        }
        for (int i = 0; i < 52; i++){
            //int index = (int)(Math.random() * deck.size());
            
            //println(deck.get(index).toString());
            //deck.remove(index);
            
            println(deck.get(i).toString());
        }
    }
}
