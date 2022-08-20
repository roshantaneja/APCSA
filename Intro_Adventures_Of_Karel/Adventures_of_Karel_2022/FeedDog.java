import stanford.karel.*;

public class FeedDog extends Karel {

    public void run() {
        moveMore(2);
        turnLeft();
        move();
        turnRight();
        move();
        turnLeft();
        moveMore(2);
        turnRight();
        moveMore(2);
        turnRight();
        move();
        putBeeper();
        turnAround();
        move();
        turnLeft();
        moveMore(2);
        turnLeft();
        moveMore(2);
        turnRight();
        moveMore(3);
        turnLeft();
        move();
        turnLeft();
    }
    
    public void turnRight() {
        turnLeft();
        turnLeft();
        turnLeft();
    }
    
    public void turnAround() {
        turnLeft();
        turnLeft();
    }
    
    public void moveMore(int num){
        for (int i=0; i<num; i++){
            move();
        }
    }

}
