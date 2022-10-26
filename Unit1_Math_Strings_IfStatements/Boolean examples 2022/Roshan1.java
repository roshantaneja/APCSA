

public class Roshan1 implements McCoveyPlayer
{

    public boolean rollAgain(int myScore, int yourScore, int turnScore)
    {
        if (myScore + turnScore >= 44)
            return false;
        if (yourScore > 40) {
            return true;
        }
        return (turnScore < 15);
    }

}
