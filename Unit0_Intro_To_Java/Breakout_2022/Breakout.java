//Roshan Taneja

import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram 
{

    /** Width and height of application window in pixels */
    public static final int APPLICATION_WIDTH = 400;
    public static final int APPLICATION_HEIGHT = 600;

    /** Dimensions of game board in pixels (usually the same) */
    private static final int WIDTH = APPLICATION_WIDTH;
    private static final int HEIGHT = APPLICATION_HEIGHT;

    /** Dimensions of the paddle */
    private static final int PADDLE_WIDTH = 60;
    private static final int PADDLE_HEIGHT = 10;

    /** Offset of the paddle up from the bottom */
    private static final int PADDLE_Y_OFFSET = 30;

    /** Number of bricks per row */
    private static final int NBRICKS_PER_ROW = 10;

    /** Number of rows of bricks */
    private static final int NBRICK_ROWS = 10;

    /** Separation between bricks */
    private static final int BRICK_SEP = 4;

    /** Width of a brick */
    private static final int BRICK_WIDTH =
        (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

    /** Height of a brick */
    private static final int BRICK_HEIGHT = 8;

    /** Radius of the ball in pixels */
    private static final int BALL_RADIUS = 10;

    /** Offset of the top brick row from the top */
    private static final int BRICK_Y_OFFSET = 70;
    /** Number of "lives" (balls) before the player loses */
    private static final int NUM_LIVES = 3;

    /** Global variables declared here.  You should feel free to add others as needed. */
    GRect paddle;
    GOval ball;
    GLabel lives;
    GLabel startButton;
    GLabel restartButton;
    AudioClip bounceClip = MediaTools.loadAudioClip("bounce.au");
    double vx;
    double vy;
    int bricksLeft;
    int currLives;
    int PADDLE_Y = HEIGHT-PADDLE_HEIGHT-PADDLE_Y_OFFSET;
    STATE s;

    public enum STATE { //use so that no more loops outside of game and also while using constants it kinda broke lmao
        START, GAME, END
    }

    /** Runs the Breakout program. */
    public void run() 
    {
        setupStartButton();
        s = STATE.START;
        while (true){
            pause(5);
            if (s == STATE.GAME){
                animationLoop();
            }
        }

    }

    public void initGame(){
        setupBricks();
        setupPaddle();
        setupBall();
        currLives = NUM_LIVES;
        setupLives();
    }

    public void setupBricks(){
        for (int i=0; i<NBRICK_ROWS; i++){
            for(int j=0; j<NBRICKS_PER_ROW; j++){
                GRect block = new GRect((BRICK_WIDTH+BRICK_SEP)*j, (BRICK_HEIGHT+BRICK_SEP)*i + BRICK_Y_OFFSET, BRICK_WIDTH, BRICK_HEIGHT);
                block.setFilled(true);
                switch(i){ //idk if we allowed to use this because we havent learned this yet
                    case 0:
                    case 1:
                        block.setColor(Color.red);
                        break;
                    case 2:
                    case 3:
                        block.setColor(Color.orange);
                        break;
                    case 4:
                    case 5:
                        block.setColor(Color.yellow);
                        break;
                    case 6:
                    case 7:
                        block.setColor(Color.green);
                        break;
                    case 8:
                    case 9:
                        block.setColor(Color.cyan);
                        break;
                }
                add(block);
                bricksLeft++;
            }
        }
    }

    public void setupBall(){
        vx = Math.random()*2 + 1;
        vy = -(Math.random()*2 + 1);
        ball = new GOval(WIDTH/2, HEIGHT/2, BALL_RADIUS * 2, BALL_RADIUS * 2);
        ball.setFilled(true);
        add(ball);
    }

    public void setupPaddle()
    {
        paddle = new GRect(WIDTH/2 - PADDLE_WIDTH/2, HEIGHT - PADDLE_Y_OFFSET - PADDLE_HEIGHT, PADDLE_WIDTH, PADDLE_HEIGHT);
        paddle.setFilled(true);
        add(paddle);
    }

    public void setupLives(){
        lives = new GLabel ("Lives: " + currLives, 10, HEIGHT - 40);
        lives.setFont("TimesNewRoman-Bold-20");
        add(lives);
    }

    public void setupStartButton(){
        GLabel titleText = new GLabel("Breakout by Roshan");
        titleText.setFont("TimesNewRoman-Bold-36");
        titleText.setLocation(WIDTH/2 - titleText.getWidth()/2, HEIGHT/2 - 100);
        add(titleText);
        
        
        startButton = new GLabel("Click to Start");
        startButton.setFont("TimesNewRoman-Bold-20");
        startButton.setLocation(WIDTH/2 - startButton.getWidth()/2, HEIGHT/2);
        add(startButton);
    }
    
    public void setupRestartButton(){
        restartButton = new GLabel("Click to Restart!");
        restartButton.setFont("TimesNewRoman-Plain-24");
        restartButton.setLocation(WIDTH/2 - restartButton.getWidth()/2, HEIGHT/2);
        add(restartButton);
    }

    public void mouseMoved(MouseEvent event){
        if (s == STATE.START){
            if(getElementAt(event.getX(), event.getY()) == startButton){ //if cursor on target, turn pink else, turn black
                startButton.setColor(Color.pink);
            } else {
                startButton.setColor(Color.black);
            }
        }
        if (s == STATE.GAME){
            paddle.setLocation(event.getX() - PADDLE_WIDTH/2, APPLICATION_HEIGHT - PADDLE_Y_OFFSET - PADDLE_HEIGHT);
            if(paddle.getX()<0){
                paddle.setLocation(0, PADDLE_Y);
            }
            if(paddle.getX()> WIDTH-PADDLE_WIDTH){
                paddle.setLocation(WIDTH-PADDLE_WIDTH, PADDLE_Y);
            }
        }
        if (s == STATE.END){
            if(getElementAt(event.getX(), event.getY()) == startButton){ //if cursor on target, turn pink else, turn black
                startButton.setColor(Color.pink);
            } else {
                startButton.setColor(Color.black);
            }
        }
    }

    public void mouseClicked(MouseEvent event){
        if (s == STATE.START){
            if(getElementAt(event.getX(), event.getY()) == startButton) {
                removeAll();
                initGame();
                pause(300);
                s = STATE.GAME;
            }
        }
        if (s == STATE.END){
            if(getElementAt(event.getX(), event.getY()) == restartButton) {
                removeAll();
                initGame();
                pause(300);
                s = STATE.GAME;
            }
        }
    }

    public void updateBall(){
        if(ball.getY() <0){
            vy = -vy;
        }
        if (ball.getY() > HEIGHT - BALL_RADIUS*2){
            currLives--;
            lives.setText("Lives: " + currLives);
            if (currLives > 0){
                vx = Math.random()*2;
                vy = -(Math.random()*2);
                setupBall();
                pause(1000);
            } else {
                initEndGame(false);
            }
        }
        if(ball.getX() < 0 || ball.getX() > WIDTH - BALL_RADIUS*2){
            vx = -vx;
        }
        ball.move(vx, vy);
    }

    public void checkForCollisions(){
        GObject obj;
        GOval oval = ball;
        if(oval == null){
            return;
        }
        if(getElementAt(oval.getX(), oval.getY()) != null){
            obj = getElementAt(oval.getX(), oval.getY());
        } else if (getElementAt(oval.getX() + BALL_RADIUS*2, oval.getY()) != null){
            obj = getElementAt(oval.getX() + BALL_RADIUS*2, oval.getY());
        } else if (getElementAt(oval.getX(), oval.getY() + BALL_RADIUS*2) != null){
            obj = getElementAt(oval.getX(), oval.getY() + BALL_RADIUS*2);
        } else if (getElementAt(oval.getX() + BALL_RADIUS*2, oval.getY() + BALL_RADIUS*2) != null){
            obj = getElementAt(oval.getX() + BALL_RADIUS*2, oval.getY() + BALL_RADIUS*2);
        } else {
            obj = null;
        }
        if(obj == paddle){
            vx = vx * 1.02;
            vy = vy * 1.02;
            vy = -Math.abs(vy);
            bounceClip.play();
        } else if (obj instanceof GRect){
            remove(obj);
            bricksLeft--;
            bounceClip.play();
            if(bricksLeft == 0){
                //add endgame function here
                initEndGame(true);
                s = STATE.END;
            }
            vy = -vy;
        }
    }

    public void animationLoop(){
        updateBall();
        checkForCollisions();
    }

    public void initEndGame(boolean isVictory){
        removeAll();
        
        GLabel gameOver;
        gameOver = new GLabel("Game Over!");
        gameOver.setFont("TimesNewRoman-Bold-24");
        gameOver.setLocation(WIDTH/2-gameOver.getWidth()/2, 100);
        add(gameOver);
        
        GLabel endMessage;
        if(isVictory){
            endMessage = new GLabel("You won! You had " + currLives + " lives left.");
            endMessage.setColor(Color.green);
        } else {
            endMessage = new GLabel("You lost! You had " + bricksLeft + " bricks left.");
            endMessage.setColor(Color.red);
        }

        endMessage.setFont("TimesNewRoman-Plain-18");
        endMessage.setLocation(WIDTH/2-endMessage.getWidth()/2, 130);
        add(endMessage);
        
        setupRestartButton();
        
        s = STATE.END;
    }
}