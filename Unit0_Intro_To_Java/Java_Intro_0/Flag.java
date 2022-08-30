// Roshan Taneja
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class Flag extends GraphicsProgram
{
    public void run()
    {
        //omg these methods are so long lmao
        createBlueSquares();
        createRedAndWhiteDiagonalStripes();
        createRedCross();
        createApology();
    }
    public void createBlueSquares(){
        GRect topLeftBlueSquare = new GRect(25, 25, 75, 33);
        GRect topRightBlueSquare = new GRect(150, 25, 75, 33);
        GRect bottomLeftBlueSquare = new GRect(25, 92, 75, 33);
        GRect bottomRightBlueSquare = new GRect(150, 92, 75, 33);
        
        topLeftBlueSquare.setColor(Color.blue);
        topRightBlueSquare.setColor(Color.blue);
        bottomRightBlueSquare.setColor(Color.blue);
        bottomLeftBlueSquare.setColor(Color.blue);
        
        topLeftBlueSquare.setFilled(true);
        topRightBlueSquare.setFilled(true);
        bottomLeftBlueSquare.setFilled(true);
        bottomRightBlueSquare.setFilled(true);
        
        
        add(bottomRightBlueSquare);
        add(bottomLeftBlueSquare);
        add(topLeftBlueSquare);
        add(topRightBlueSquare);
    }
    public void createRedCross(){
        GRect verticalRedStripe = new GRect(110, 25, 30, 100);
        GRect horizontalRedStripe = new GRect(25, 65, 200, 20);
        
        verticalRedStripe.setFilled(true);
        verticalRedStripe.setColor(Color.red);
        
        horizontalRedStripe.setFilled(true);
        horizontalRedStripe.setColor(Color.red);
        
        add(horizontalRedStripe);
        add(verticalRedStripe);
    }
    public void createRedAndWhiteDiagonalStripes(){
        GPolygon topLeftRedStripe = new GPolygon(25, 25);
        GPolygon topRightRedStripe = new GPolygon(225, 25);
        GPolygon bottomLeftRedStripe = new GPolygon(25, 125);
        GPolygon bottomRightRedStripe = new GPolygon (225, 125);
        
        topLeftRedStripe.addVertex(0,0);
        topLeftRedStripe.addVertex(2, 0);
        topLeftRedStripe.addVertex(75, 29);
        topLeftRedStripe.addVertex(75, 33);
        topLeftRedStripe.addVertex(65, 33);
        topLeftRedStripe.addVertex(0, 9);
        
        topRightRedStripe.addVertex(0,0);
        topRightRedStripe.addVertex(-2, 0);
        topRightRedStripe.addVertex(-75, 29);
        topRightRedStripe.addVertex(-75, 33);
        topRightRedStripe.addVertex(-65, 33);
        topRightRedStripe.addVertex(0, 9);
        
        bottomLeftRedStripe.addVertex(0,0);
        bottomLeftRedStripe.addVertex(2, 0);
        bottomLeftRedStripe.addVertex(75, -29);
        bottomLeftRedStripe.addVertex(75, -33);
        bottomLeftRedStripe.addVertex(65, -33);
        bottomLeftRedStripe.addVertex(0, -9);
        
        bottomRightRedStripe.addVertex(0,0);
        bottomRightRedStripe.addVertex(-2, 0);
        bottomRightRedStripe.addVertex(-75, -29);
        bottomRightRedStripe.addVertex(-75, -33);
        bottomRightRedStripe.addVertex(-65, -33);
        bottomRightRedStripe.addVertex(0, -9);
        
        topLeftRedStripe.setFilled(true);
        topLeftRedStripe.setColor(Color.red);
        
        topRightRedStripe.setFilled(true);
        topRightRedStripe.setColor(Color.red);
        
        bottomLeftRedStripe.setFilled(true);
        bottomLeftRedStripe.setColor(Color.red);
        
        bottomRightRedStripe.setFilled(true);
        bottomRightRedStripe.setColor(Color.red);
        
        add(topLeftRedStripe);
        add(topRightRedStripe);
        add(bottomLeftRedStripe);
        add(bottomRightRedStripe);
    }
    public void createApology(){
        GLabel apology = new GLabel("sorry i couldnt figure out how to make it look good", 25, 150);
        apology.setFont(new Font("Palatino", Font.BOLD, 24));
        add(apology);
    }
}