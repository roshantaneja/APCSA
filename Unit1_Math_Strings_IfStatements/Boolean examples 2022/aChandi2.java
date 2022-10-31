

public class aChandi2 implements McCoveyPlayer
{
    int score = 13;
    int initScore = score;
    boolean checkFirst = true;
    boolean isFirst = false;
    
    public boolean rollAgain(int myScore, int yourScore, int turnScore)
    {

        if (myScore + turnScore >= 44)
            return false;
        return determineChoice(myScore, yourScore, turnScore);
    }
    
    public boolean determineChoice(int myScore, int yourScore, int turnScore)
    {
        if (myScore+turnScore>32)
        {
            return true;
        }

        else if (yourScore>29)
        {
            return true;
        }
        else if (yourScore>24)//change around number (20, 26)
        {
            return (turnScore<18);
        }
        if (myScore+turnScore<yourScore)
        {
            return(turnScore<score+2);
        }
        else if (myScore+turnScore<yourScore-10)
        {
            return(turnScore<score+3);
        }
        else if (myScore+turnScore<yourScore-15)
        {
            return(turnScore<score+4);
        }
        else /*if (myScore+turnScore>27)
        {
            return (turnScore<score-2);
        }*/
        return (turnScore<score);
    }

}
