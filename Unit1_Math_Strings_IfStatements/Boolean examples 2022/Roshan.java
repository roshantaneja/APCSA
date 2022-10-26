

public class Roshan implements McCoveyPlayer
{   
    public boolean rollAgain(int myScore, int yourScore, int turnScore)
    {
        if (myScore + turnScore >= 44) {
            return false;
        } else if (myScore + turnScore > 30) {
            return true;
        } else if (myScore > 30) {
            return true;
        } else if (yourScore > 30) {
            return true;
        } else if (yourScore > 25) {
            return turnScore > 15;
        } else {
            return (turnScore < 14);
        }
    }
}
