

public class OddEven implements McCoveyPlayer
{

    public boolean rollAgain(int myScore, int yourScore, int turnScore)
    {
        if (myScore + turnScore >= 44) {
            return false;
        } else if (turnScore % 2 == 1) {
            return true;
        } else {
            return turnScore < 14;
        }
    }

}
