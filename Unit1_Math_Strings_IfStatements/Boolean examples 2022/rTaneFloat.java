
public class rTaneFloat implements McCoveyPlayer
{

    public boolean rollAgain(int myScore, int yourScore, int turnScore)
    {
        if (myScore + turnScore >= 44) {
            return false;
        } else {
            if (myScore > yourScore) {
                if (myScore + turnScore > 32) { // spend time
                    return true;
                } else if (myScore > 30) {
                    return true;
                } else if (yourScore > 30) {
                    return true;
                } else if (yourScore > 24) {
                    return turnScore < 18;
                } else if (myScore + turnScore < yourScore) {
                    return turnScore < 15;
                } else if (myScore + turnScore < yourScore - 10) { // spend time
                    return turnScore < 16;
                } else if (myScore + turnScore < yourScore - 15) {
                    return turnScore < 15;
                } else if (myScore + turnScore < yourScore - 17) { // spend time
                    return turnScore < 19;
                } else if (myScore + turnScore > 27) {
                    return turnScore < 10;
                } else {
                    return turnScore < 13;
                }
            } else {
                if (myScore + turnScore > 32) { // spend time
                    return true;
                } else if (myScore > 30) {
                    return true;
                } else if (yourScore > 30) {
                    return true;
                } else if (yourScore > 24) {
                    return turnScore < 17;
                } else if (myScore + turnScore < yourScore) {
                    return turnScore < 14;
                } else if (myScore + turnScore < yourScore - 11) { // spend time
                    return turnScore < 15;
                } else if (myScore + turnScore < yourScore - 15) {
                    return turnScore < 12;
                } else if (myScore + turnScore < yourScore - 17) { // spend time
                    return turnScore < 13;
                } else if (myScore + turnScore > 27) {
                    return turnScore < 11;
                } else {
                    return turnScore < 15;
                }
            }
        }

    }
}
