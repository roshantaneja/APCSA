import stanford.karel.*;

public class DoubleBeepers extends Karel
{

    public void run()
    {
        move();
        doubleEntirePileOfBeepers();
        moveBackward();
    }
    
    public void moveBackward(){
        turnAround();
        move();
        turnAround();
    }
    
    public void turnAround(){
        turnLeft();
        turnLeft();
    }
    
    public void doubleEntirePileOfBeepers() {
        makePileTwiceAsBigNextDoor();
        movePileInFrontBack();        
    }
    
    public void makePileTwiceAsBigNextDoor() {
        while (beepersPresent()){
            pickBeeper();
            move();
            putBeeper();
            putBeeper();
            moveBackward();
        }
    }
    
    public void movePileInFrontBack(){
        move();
        while(beepersPresent()){
            pickBeeper();
            moveBackward();
            putBeeper();
            move();
        }
        moveBackward();
    }

}
