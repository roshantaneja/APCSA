
public class RandomPlayer implements McCoveyPlayer
{

    public boolean rollAgain(int myScore, int yourScore, int turnScore)
    {
        return Math.random() < 0.5;
    }

}
