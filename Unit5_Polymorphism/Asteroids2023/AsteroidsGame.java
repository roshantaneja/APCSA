
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.*;
import java.applet.AudioClip;
import acm.util.MediaTools;

public class AsteroidsGame extends GraphicsProgram
{
    // uncomment out the line below in version 0.4.1
    private ArrayList<Asteroid> asteroids;
    
    private boolean playing;
    
    private GLabel notificationLabel, scoreLabel;
    
    // uncomment out the line below in version 0.4.1
    private Ship ship;
    
    // uncomment out the line below in version 0.5.2
    // (and don't forget to write bullets = new ArrayList<Bullet>() in the initializeVariables method!)
    // private ArrayList<Bullet> bullets; 
    
    private int level;
    private int numLivesRemaining;
    private int score;
    private AudioClip thrustClip, fireClip, bigBangClip, mediumBangClip, smallBangClip;

    public void initializeVariables()
    {
        thrustClip = MediaTools.loadAudioClip("thrust.wav");   
        fireClip = MediaTools.loadAudioClip("fire.wav");   
        bigBangClip = MediaTools.loadAudioClip("bangLarge.wav");   
        mediumBangClip = MediaTools.loadAudioClip("bangMedium.wav");   
        smallBangClip = MediaTools.loadAudioClip("bangSmall.wav");   

        level = 0;
        numLivesRemaining = 3;
        score = 0;

        notificationLabel = new GLabel("(up) = thrust, (left) = rotate left, (right) = rotate right, (space) = fire. Click mouse to continue");
        notificationLabel.setColor(Color.WHITE);
        notificationLabel.setFont("Courier-Plain-12");
        notificationLabel.setLocation((getWidth()-notificationLabel.getWidth())/2, getHeight()/2-40);
        add(notificationLabel);

        scoreLabel = new GLabel("Score:"+score);
        scoreLabel.setColor(Color.WHITE);
        scoreLabel.setFont("Courier-Plain-10");
        scoreLabel.setLocation(16, 16);
        add(scoreLabel);
        
        // uncomment out the line below in version 0.3
        asteroids = new ArrayList<Asteroid>();
        makeAsteroids();
        
        ship = new Ship(getWidth(), getHeight());
        ship.setLocation(getWidth()/2, getHeight()/2);
        add(ship);

    }

    private void makeAsteroids()
    {
        // code for version 0.3.1 goes here
        for (int i = 0; i < level+3; i ++){
            Asteroid a = new Asteroid(getWidth(), getHeight());
            a.setLocation(Math.random() * getWidth(), Math.random()*getHeight());
            asteroids.add(a);
        }
        for (Asteroid a : asteroids){
            a.increaseVelocity(1);
            add(a);
        }
    }

    public void run()
    {
        // code for version 0.1.1 goes here
        initializeVariables(); 
        setBackground(Color.black);
        
        while(true){
            for (Asteroid a : asteroids){
                a.updatePosition();
                ship.updatePosition();
                pause(5);
            }
        }
        
    }
    
    public void keyPressed(KeyEvent e){
        if (e.getKeyCode()==KeyEvent.VK_RIGHT)
            ship.rotate(15); // rotate a bit clockwise
        if (e.getKeyCode()==KeyEvent.VK_LEFT)
            ship.rotate(-15);
        if (e.getKeyCode()==KeyEvent.VK_UP)
            ship.increaseVelocity(0.3);
        if (e.getKeyCode()==KeyEvent.VK_SPACE){
            Bullet b = ship.makeBullet();
            add(b);
        }
    }

    // uncomment out the line below in version 0.6
    /*
    private Asteroid checkForCollisions(GVectorPolygon obj)
    {
        for (Asteroid a:asteroids)
            if (a.getBounds().intersects(obj.getBounds()))
            {
                return a;
            }
        return null;       
    }
    */

}
