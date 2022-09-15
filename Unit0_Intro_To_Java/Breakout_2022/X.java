//Roshan Taneja

import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class X extends GraphicsProgram 
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
    private static final int PADDLE_Y_OFFSET = 50;

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
    GLabel title;
    GLabel subtitle;
    GLabel playButton;
    GLabel lives;
    GLabel gameOver;
    GLabel endMessage;
    GLabel returnButton;
    Boolean isCountingDown;
    double speedMultiplier;
    GOval[] Balls;
    double[] Vx;
    double[] Vy;
    double initVy;
    boolean[] isIn;
    boolean ballsLeft;
    State s;
    int PADDLE_Y;
    int currLives;
    int bricksLeft;
    AudioClip bounceClip;

    public enum State {
        MENU, GAME, END;
    } 
    /** Runs the Breakout program. */
    public void run() 
    {
        initMenu();
        while(true){
            pause(5);
            if(s == State.GAME){
                if(isCountingDown){
                    countDown();
                    isCountingDown = false;
                }
                updateBalls();
                checkForCollisions();
            }
        }

    }

    public void checkBalls(){
        ballsLeft = false;
        for(int i=0; i< isIn.length; i++){
            if(isIn[i]){
                ballsLeft = true;
                break;
            }
        }
    }

    public void updateBalls(){ 
        if(bricksLeft <= 10){
            speedMultiplier = 1.75;
            for(int j=0; j<Vy.length; j++){

                if(Vy[j] < 0){
                    Vy[j] = -initVy * speedMultiplier;
                } else if (Vy[j] > 0){
                    Vy[j] = initVy * speedMultiplier;
                }

            }

        } else if (bricksLeft <= 50){
            speedMultiplier = 1.6;
            for(int j=0; j<Vy.length; j++){

                if(Vy[j] < 0){
                    Vy[j] = -initVy * speedMultiplier;
                } else if (Vy[j] > 0){
                    Vy[j] = initVy * speedMultiplier;
                }

            }
        } else if (bricksLeft <= 90){
            speedMultiplier = 1.5;
            for(int j=0; j<Vy.length; j++){

                if(Vy[j] < 0){
                    Vy[j] = -initVy * speedMultiplier;
                } else if (Vy[j] > 0){
                    Vy[j] = initVy * speedMultiplier;
                }

            }
        }
        for(int i=0; i<Balls.length; i++){
            if(Balls[i] != null){
                updateBall(i);
            }
        }
    }

    public void addBall(){
        GOval newBall = new GOval(paddle.getX() + PADDLE_WIDTH/2 - BALL_RADIUS, paddle.getY() - BALL_RADIUS*2, BALL_RADIUS*2, BALL_RADIUS *2);
        newBall.setFilled(true);
        add(newBall);
        int ballIndex = 99;
        for(int i=0; i<Balls.length; i++){
            if(Balls[i] == null){
                ballIndex = i;
                break;
            }
        }
        Balls[ballIndex] = newBall;
        isIn[ballIndex] = true;
        Vy[ballIndex] = initVy;
        Vy[ballIndex] = -Vy[ballIndex];
        Vx[ballIndex] = 1+Math.random()*2;
        if(Math.random()>0.5){
            Vx[ballIndex] = -Vx[ballIndex];
        }
    }

    public void initGameOver(Boolean hasWon){
        s = State.END;
        removeAll();
        gameOver = new GLabel("Game Over!");
        gameOver.setFont("TimesNewRoman-Bold-24");
        gameOver.setLocation(WIDTH/2-gameOver.getWidth()/2, 100);
        add(gameOver);

        if(hasWon){
            endMessage = new GLabel("You won! You had " + currLives + " lives left.");
            endMessage.setColor(Color.green);
        } else {
            endMessage = new GLabel("You lost! You had " + bricksLeft + " bricks left.");
            endMessage.setColor(Color.red);
        }

        endMessage.setFont("TimesNewRoman-Plain-18");
        endMessage.setLocation(WIDTH/2-endMessage.getWidth()/2, 130);
        add(endMessage);

        returnButton = new GLabel("Return to Main Menu");
        returnButton.setFont("TimesNewRoman-Bold-18");
        returnButton.setLocation(WIDTH/2-returnButton.getWidth()/2, 300);

        add(returnButton);

    }

    public void initMenu(){
        s = State.MENU;
        
        title = new GLabel("Breakout");
        title.setFont("TimesNewRoman-Bold-24");
        title.setLocation(WIDTH/2-title.getWidth()/2, 100);

        add(title);

        subtitle = new GLabel("");
        subtitle.setFont("TimesNewRoman-Plain-18");
        subtitle.setLocation(WIDTH/2-subtitle.getWidth()/2, 130);

        add(subtitle);

        playButton = new GLabel("Play");
        playButton.setFont("TimesNewRoman-Bold-18");
        playButton.setLocation(WIDTH/2-playButton.getWidth()/2, 300);

        add(playButton);
    }

    public void playGame(){
        removeMenu();
        initGame();
    }

    public void countDown(){
        GLabel countdown = new GLabel("3");
        countdown.setFont("TimesNewRoman-Bold-36");
        countdown.setColor(Color.red);
        countdown.setLocation(WIDTH/2-countdown.getWidth()/2, 300);
        add(countdown);
        pause(1000);

        countdown.setText("2");
        countdown.setColor(Color.orange);
        pause(1000);
        countdown.setText("1");
        countdown.setColor(Color.green);
        pause(1000);
        remove(countdown);
    }

    public void removeMenu(){
        remove(title);
        remove(subtitle);
        remove(playButton);
    }

    public void removeEndMenu(){
        remove(gameOver);
        remove(endMessage);
        remove(returnButton);
    }

    public void initGame(){
        PADDLE_Y = HEIGHT-PADDLE_HEIGHT-PADDLE_Y_OFFSET;
        currLives = NUM_LIVES;
        bricksLeft= NBRICK_ROWS * NBRICKS_PER_ROW;
        bounceClip = MediaTools.loadAudioClip("bounce.au");
        isCountingDown = true;
        initVy = 2;
        Balls = null;
        Vx = null;
        Vy = null;
        isIn = null;
        Balls = new GOval[13];
        Vy = new double[13];
        Vx = new double[13];
        isIn = new boolean[13];
        
        speedMultiplier = 1;
        
        int[] specialBricks;
        specialBricks = new int[NBRICK_ROWS];
        for(int i=0; i<NBRICK_ROWS; i++){
            specialBricks[i] = (int)(Math.random()*10);
        }
        initBricks(specialBricks);
        initPaddle();
        initBall();
        initLabel();
    }

    public void initLabel(){
        lives = new GLabel("Lives: " + currLives);
        lives.setLocation(10, 20);
        lives.setColor(Color.red);
        lives.setFont("TimesNewRoman-Plain-18");
        add(lives);
    }

    public void initBricks(int[] specials){
        for (int i=0; i<NBRICK_ROWS; i++){
            for(int j=0; j<NBRICKS_PER_ROW; j++){
                GRect block = new GRect((BRICK_WIDTH+BRICK_SEP)*j, (BRICK_HEIGHT+BRICK_SEP)*i + BRICK_Y_OFFSET, BRICK_WIDTH, BRICK_HEIGHT);
                block.setFilled(true);
                switch(i){
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
                if(specials[i] == j){
                    block.setColor(Color.magenta);
                }
                add(block);
            }
        }
    }

    public void initPaddle(){
        paddle = new GRect(WIDTH/2-PADDLE_WIDTH/2, PADDLE_Y, PADDLE_WIDTH, PADDLE_HEIGHT);
        paddle.setFilled(true);
        add(paddle);
    }

    public void keyPressed(KeyEvent e){
        if(s == State.GAME){
            switch(e.getKeyCode()){
                case 39: //right
                paddle.move(20, 0);
                if(paddle.getX()<0){
                    paddle.setLocation(0, PADDLE_Y);
                }
                if(paddle.getX()> WIDTH-PADDLE_WIDTH){
                    paddle.setLocation(WIDTH-PADDLE_WIDTH, PADDLE_Y);
                }
                break;
                case 37: //left
                paddle.move(-20, 0);
                if(paddle.getX()<0){
                    paddle.setLocation(0, PADDLE_Y);
                }
                if(paddle.getX()> WIDTH-PADDLE_WIDTH){
                    paddle.setLocation(WIDTH-PADDLE_WIDTH, PADDLE_Y);
                }
                break;

            }

        }
    }

    public void mouseMoved(MouseEvent e){
        switch(s){
            case GAME:
            paddle.setLocation(e.getX()-PADDLE_WIDTH/2, PADDLE_Y);
            if(paddle.getX()<0){
                paddle.setLocation(0, PADDLE_Y);
            }
            if(paddle.getX()> WIDTH-PADDLE_WIDTH){
                paddle.setLocation(WIDTH-PADDLE_WIDTH, PADDLE_Y);
            }
            break;

            case MENU:
            if(getElementAt(e.getX(), e.getY())== playButton){
                playButton.setColor(Color.green);
            } else {
                playButton.setColor(Color.black);
            }
            break;

            case END:
            if(getElementAt(e.getX(), e.getY())== returnButton){
                returnButton.setColor(Color.green);
            } else {
                returnButton.setColor(Color.black);
            }
            break;
        }

    }

    public void mouseClicked(MouseEvent e){
        if(s == State.MENU){
            if(getElementAt(e.getX(), e.getY()) == playButton){
                playGame();
                s = State.GAME;
            }
        }
        if(s == State.END){
            if(getElementAt(e.getX(), e.getY()) == returnButton){
                s = State.MENU;
                removeEndMenu();
                initMenu();
            }
        }

    }

    public void initBall(){
        GOval ball = new GOval(paddle.getX() + PADDLE_WIDTH/2 - BALL_RADIUS, paddle.getY() - BALL_RADIUS*2, BALL_RADIUS*2, BALL_RADIUS*2);
        ball.setFilled(true);
        add(ball);

        int ballIndex = 99;
        for(int i=0; i<Balls.length; i++){
            if(Balls[i] == null){
                ballIndex = i;
                break;
            }
        }
        Balls[ballIndex] = ball;
        isIn[0] = true;
        Vy[0] = initVy;
        Vy[0] = -Vy[0];
        Vx[0] = 1+Math.random()*2;
        if(Math.random()>0.5){
            Vx[0] = -Vx[0];
        }
    }

    public void updateBall(int index){

        double localVy = Vy[index];
        double localVx = Vx[index];

        GOval currBall = Balls[index];

        if(isIn[index]){
            if(currBall.getY() <0){
                localVy = -localVy;
            }
            if(currBall.getY() > HEIGHT-BALL_RADIUS*2){
                isIn[index] = false;
                checkBalls();
                if(ballsLeft != true){
                    currLives--;
                    lives.setText("Lives: " + currLives);
                    if(currLives == 0){

                        initGameOver(false);
                    } else {
                        addBall(); 
                        pause(1000);
                    }

                } else {
                    remove(currBall);
                    isIn[index] = false;
                }

            }
            if(currBall.getX() < 0 || currBall.getX() > WIDTH-BALL_RADIUS*2){
                localVx=-localVx;
            }

            Vx[index] = localVx;
            Vy[index] = localVy;  

            currBall.move(localVx, localVy);
        }

    }

    public void checkForCollisions(){
        GObject obj;

        for (int i=0; i<Balls.length; i++){
            GOval oval = Balls[i];
            if(oval == null){
                continue;
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
                
                Vy[i] = -Math.abs(Vy[i]);
            } else if (obj instanceof GRect){
                if(obj.getColor() == Color.magenta){
                    addBall();
                }
                remove(obj);
                bounceClip.play();
                bricksLeft--;
                if(bricksLeft == 0){
                    initGameOver(true);
                }
                Vy[i] = -Vy[i];

            }
        }
    }
}
