import stanford.karel.*;

public class RepairQuad extends Karel
{

    public void run()
    {
        while(frontIsClear()){
            fixColumn();
            moveToNextColumn();
        }
        fixColumn();
    }
    public void moveToNextColumn(){
        for(int i = 0; i <4; i++){
            move();
        }
    }
    public void fixColumn(){
        ascendColumnReplacingBeepersIfNeeded();
        turnAround();
        descendColumn();
    }
    public void turnRight(){
        for (int i=0; i<3 ; i++){
            turnLeft();
        }
    }
    public void turnAround() {
        turnLeft();
        turnLeft();
    }
    
    public void descendColumn() {
        while(frontIsClear()) {
            move();
        }
        turnLeft();
    }
    public void ascendColumnReplacingBeepersIfNeeded(){
        turnLeft();
        replaceBeeperIfNeeded();    
        while(frontIsClear()){
            
            move();
            replaceBeeperIfNeeded();
            
        }
        
    }
    public void replaceBeeperIfNeeded(){
        if (noBeepersPresent()){
            putBeeper();
        }
    }

}