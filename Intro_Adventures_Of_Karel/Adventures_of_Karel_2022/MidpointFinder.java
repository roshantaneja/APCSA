import stanford.karel.*;

public class MidpointFinder extends Karel
{

    public void run()
    {
        layRowOfBeepers(); //leave first and last space empty :)
        //you must start on a beeper
        while(beepersPresent()){
            pickUpLastBeeperAtOtherEnd(); //reposition so you are on a beeper
        }
        turnAround();
        move();
        turnAround();
    }
    public void layRowOfBeepers(){ //for laying row with first and last empty
        move();
        while(frontIsClear()){
            putBeeper();
            move();
        }
        turnAround();
        move();
    }
    public void turnAround(){ //turn around -_-
        turnLeft();
        turnLeft();
    }
    public void pickUpLastBeeperAtOtherEnd(){ // just move and run to "end of line" meaning there is empty space at the end
        while(beepersPresent() && frontIsClear()){
            move();
        }
        turnAround();
        move();
        pickBeeper();
        move();
    }
}