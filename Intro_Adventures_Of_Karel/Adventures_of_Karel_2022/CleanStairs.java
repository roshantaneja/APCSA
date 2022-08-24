import stanford.karel.*;

public class CleanStairs extends Karel
{
    public void run()
    {
        while (!frontIsClear()) {
            cleanStep();
        }
    }
    
    public void turnRight(){
        for (int i=0; i<3;i++){
            turnLeft();
        }
    }
    
    public void cleanStep(){
        ascendStep();
        pickBeeper();
    }
    
    public void ascendStep(){
        turnLeft();
        move();
        turnRight();
        move();
    }
}