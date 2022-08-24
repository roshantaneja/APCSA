import stanford.karel.*;

public class SpringTime extends Karel
{

    public void run()
    {
        for (int i=0; i < 5; i++){
            encounterTree();
            ascendTree();
            plantPetals();
            move();
            descendTree();
        }
    }
    
    public void encounterTree() {
        while (frontIsClear()){
            move();
        }
    }
    
    public void ascendTree() {
        turnLeft();
        while(rightIsBlocked()){
            move();
        }
        turnRight();
    }
    
    public void descendTree() {
        turnRight();
        while (frontIsClear()){
            move();
        }
        turnLeft();
    }

    public void turnRight() {
        turnLeft();
        turnLeft();
        turnLeft();
    }
    
    public void plantPetals() {
        putBeeper();
        move();
        putBeeper();
        turnLeft();
        move();
        putBeeper();
        turnLeft();
        move();
        putBeeper();
        turnLeft();
        move();
        turnLeft();
        
    }
}
