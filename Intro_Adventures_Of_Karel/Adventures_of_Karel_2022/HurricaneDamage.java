import stanford.karel.*;

public class HurricaneDamage extends Karel
{
    public void run()
    {
        for(int i =0; i <3; i ++){ //is findRubble oversimplified?
            findRubble();
            buildHouse();
        }
    }    
    public void findRubble(){
        while (noBeepersPresent()&&frontIsClear()){ //very tricky!
            move();
        }
        pickBeeper();
    }
    public void buildHouse(){
        move();
        turnLeft();
        buildThree(); //build right wall
        turnLeft();
        move();
        turnLeft();
        move();
        turnLeft();
        turnLeft();
        buildThree(); //build roof
        turnLeft();
        move();
        turnLeft();
        move();
        buildThree(); //build left wall
        turnLeft();
        move();
        move();// at the end of the house
        if(frontIsClear()){ //need this otherwise the program recognizes house as rubble
            move(); // because it doesnt leave the house unless its open outside
        }
    }
    public void turnRight(){
        for (int i = 0; i <3; i++){
            turnLeft();
        }
    }
    public void buildThree(){
        for(int i = 0; i <2; i++){
            putBeeper();
            move();
        }
        putBeeper();
    }
}