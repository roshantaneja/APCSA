
public class Card
{
    private int suit; // [0 - 3]
    private int rank; // [0 - 12]

    public Card(int suit_, int rank_) {
        suit = suit_;
        rank = rank_;
    }
    
    public String getSuit() {
        if (suit == 0){
            return("spades");
        } else if (suit == 1) {
            return("hearts");
        } else if (suit == 2) {
            return("diamonds");
        } else {
            return ("clubs");
        }
    }
    
    public String getRank() {
        if (rank == 0) {
            return("Ace");
        } else if (rank < 10) {
            return String.valueOf(rank);
        } else if (rank == 10) {
            return ("Jack");
        } else if (rank == 11) {
            return ("Queen");
        } else {
            return ("King");
        }
    }
    
    public String toString() {
        return (getRank() + " of " + getSuit());
    }
    


}
