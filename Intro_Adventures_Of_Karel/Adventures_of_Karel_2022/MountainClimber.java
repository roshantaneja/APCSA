import stanford.karel.*;

public class MountainClimber extends Karel
{
    public void run()
    {
        moveToWall();
        climbMountain();
        moveToWall();
    }
    public void turnRight(){
        for (int i = 0; i < 3; i++){
            turnLeft();
        }
    }
    public void moveToWall() {
        while (frontIsClear()){
            move();
        }
    }
    public void climbMountain() {
        ascendMountain();
        putBeeper();
        descendMountain();
        
    }
    
    public void ascendMountain() {
        while (frontIsBlocked()){
            goUpOneStep();
        }
    }
    public void goUpOneStep() {
        turnLeft();
        move();
        turnRight();
        move();
    }
    public void descendMountain() {
        move();
        while (rightIsClear()){
            goDownOneStep();
        }
    }
    public void goDownOneStep(){
        turnRight();
        move();
        turnLeft();
        move();
    }
}