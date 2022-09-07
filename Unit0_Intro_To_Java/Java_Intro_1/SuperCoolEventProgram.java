// Roshan Taneja

import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;

public class SuperCoolEventProgram extends GraphicsProgram
{
    GOval pointer;
    GRect target1;
    GRect target2;
    GRect target3;
    GRect target4;
    GLabel instructions;
    GLabel reset;
    
    public void run()
    {
        //gun lazer
        pointer = new GOval(50, 50, 30, 30);
        pointer.setFilled(true);
        pointer.setColor(Color.red);
        add(pointer);
        //instructions to run program
        instructions = new GLabel("use the pointer to hit the sqares!", 300, 100);
        add(instructions);
        //reset button
        reset = new GLabel("Click to reset", 300, 200);
        reset.setColor(Color.black);
        reset.setFont("Times-Bold-36");
        add(reset);
        //initialize target positions
        target1 = new GRect(20, 140, 50, 50);
        target2 = new GRect(100, 140,50, 50);
        target3 = new GRect(20, 50, 50, 50 );
        target4 = new GRect(100, 50,50, 50);
        //fill targets
        target1.setFilled(true);
        target2.setFilled(true);
        target3.setFilled(true);
        target4.setFilled(true);
        //targets
        add(target1);
        add(target2);
        add(target3);
        add(target4);

    }
    
    public void resetBoard(){
        //set random locations of targets using Math.random
        target1.setLocation((int)Math.floor(Math.random()*(getWidth() - 30)), (int)Math.floor(Math.random()*(getHeight()-30)));
        target2.setLocation((int)Math.floor(Math.random()*(getWidth() - 30)), (int)Math.floor(Math.random()*(getHeight()-30)));
        target3.setLocation((int)Math.floor(Math.random()*(getWidth() - 30)), (int)Math.floor(Math.random()*(getHeight()-30)));
        target4.setLocation((int)Math.floor(Math.random()*(getWidth() - 30)), (int)Math.floor(Math.random()*(getHeight()-30)));
        //make targets visible again
        target1.setVisible(true);
        target2.setVisible(true);
        target3.setVisible(true);
        target4.setVisible(true);
    }

    public void mouseMoved(MouseEvent e){
        pointer.setLocation(e.getX()-15, e.getY()-15);
        if(getElementAt(e.getX(), e.getY()) == target1){ //if cursor on target, turn black
            target1.setColor(Color.black);
        } else {
            target1.setColor(Color.orange);
        }
        if(getElementAt(e.getX(), e.getY()) == target2){ //if cursor on target, turn black
            target2.setColor(Color.black);
        } else {
            target2.setColor(Color.orange);
        }
        if(getElementAt(e.getX(), e.getY()) == target3){ //if cursor on target, turn black
            target3.setColor(Color.black);
        } else {
            target3.setColor(Color.orange);
        }
        if(getElementAt(e.getX(), e.getY()) == target4){ //if cursor on target, turn black
            target4.setColor(Color.black);
        } else {
            target4.setColor(Color.orange);
        }
        if(getElementAt(e.getX(), e.getY()) == reset){ //if cursor on button, turn purple
            reset.setColor(Color.magenta);
        } else {
            reset.setColor(Color.black);
        }
    }

    public void mouseClicked(MouseEvent e){ //if shooting a target, make it invisible
        if(getElementAt(e.getX(), e.getY()) == target1){
            target1.setVisible(false);
        }
        if(getElementAt(e.getX(), e.getY()) == target2){
            target2.setVisible(false);
        }
        if(getElementAt(e.getX(), e.getY()) == target3){
            target3.setVisible(false);
        }
        if(getElementAt(e.getX(), e.getY()) == target4){
            target4.setVisible(false);
        }
        if(getElementAt(e.getX(), e.getY()) == reset){ //reset board called when button clicked
            resetBoard();
        }
    }

}