//Roshan Taneja

import acm.program.*;
import acm.graphics.*;

import java.awt.Color;
import java.awt.event.*;

public class HangmanGraphicsProgram extends GraphicsProgram {
    /**
     * Width and height of application window in pixels
     */
    public static final int APPLICATION_WIDTH = 800;
    public static final int APPLICATION_HEIGHT = 500;
    private static final int WIDTH = APPLICATION_WIDTH;
    private static final int HEIGHT = APPLICATION_HEIGHT;

    private static final int PUZZLE_Y_OFFSET = 100;
    private static final int GUESSED_LETTERS_X_OFFSET = 50;
    private static final int GUESSED_LETTERS_Y_OFFSET = 300;

    // task #0 - familiarize yourself with the private instance variables below
    private GLabel puzzleLabel;
    private GLabel lettersGuessedLabel;
    private HangmanGame game;
    private boolean isPlaying;

    /*hangman images, too many of them to i just mad them
    h0-h1-h2 etc, hopefully this still counts as readable*/
    private GImage h0;
    private GImage h1;
    private GImage h2;
    private GImage h3;
    private GImage h4;
    private GImage h5;
    private GImage h6;
    private GImage h7;
    private GImage h8;
    private GImage h9;
    private GImage h10;


    public void run() {
        initMenu();

        while (true) {
            playGame();
        }
    }

    public void initMenu() {
        GLabel title = new GLabel("HANG-MAN");
        title.setFont("TimesNewRoman-Bold-30");
        title.setLocation(WIDTH / 2 - title.getWidth() / 2, 60);

        add(title);

        GLabel byWho = new GLabel("By: Roshan Taneja");
        byWho.setFont("TimesNewRoman-Plain-18");
        byWho.setLocation(WIDTH / 2 - byWho.getWidth() / 2, 100);

        add(byWho);

        GLabel playButton = new GLabel("Click to Play");
        playButton.setFont("TimesNewRoman-Bold-20");
        playButton.setLocation(WIDTH / 2 - playButton.getWidth() / 2, HEIGHT / 2 - playButton.getHeight() / 2);

        add(playButton);

        waitForClick();
        removeAll();
    }

    public void playGame() {
        game = new HangmanGame();
        isPlaying = true;
        initPuzzle();
        initLettersGuessedLabel();
        initHangmanGraphic();

        while (isPlaying) {
            pause(10);
            if (game.getPuzzle().equals(game.getActualAnswer())) isPlaying = false;
        }

        if (game.getGuessesLeft() == 0) {
            endGame(false);
        } else {
            endGame(true);
        }
    }

    public void initPuzzle() {
        puzzleLabel = new GLabel(game.getPuzzle());
        int fontSize = 64;
        puzzleLabel.setFont("Monospaced-plain-" + fontSize);
        // the while loop below makes the puzzle as large as possible so that it fits
        while (puzzleLabel.getWidth() > WIDTH) {
            fontSize--;
            puzzleLabel.setFont("*-*-" + fontSize);
        }
        puzzleLabel.setLocation((WIDTH - puzzleLabel.getWidth()) / 2, PUZZLE_Y_OFFSET);
        add(puzzleLabel);
    }

    public void initLettersGuessedLabel() {
        lettersGuessedLabel = new GLabel("Letters guessed: ", GUESSED_LETTERS_X_OFFSET, GUESSED_LETTERS_Y_OFFSET);
        lettersGuessedLabel.setFont("Sansserif-Plain-18");
        lettersGuessedLabel.setColor(Color.red);
        add(lettersGuessedLabel);
    }

    public void initHangmanGraphic() {
        /*i know this method is kinda overkill
        i wanted to do an array of image objects instead
        i didnt get to that point to manipulate the
        GImage objects because i ran out of time*/

        h0 = new GImage("0.jpg");
        h1 = new GImage("1.jpg");
        h2 = new GImage("2.jpg");
        h3 = new GImage("3.jpg");
        h4 = new GImage("4.jpg");
        h5 = new GImage("5.jpg");
        h6 = new GImage("6.jpg");
        h7 = new GImage("7.jpg");
        h8 = new GImage("8.jpg");
        h9 = new GImage("9.jpg");
        h10 = new GImage("10.jpg");

        setImageLocation(h0);
        setImageLocation(h1);
        setImageLocation(h2);
        setImageLocation(h3);
        setImageLocation(h4);
        setImageLocation(h5);
        setImageLocation(h6);
        setImageLocation(h7);
        setImageLocation(h8);
        setImageLocation(h9);
        setImageLocation(h10);

        add(h0);
    }

    public void setImageLocation(GImage image) {
        //image.scale(0.5, 0.5);
        image.setBounds(WIDTH - image.getWidth() - 30, 100, image.getWidth(), image.getHeight());
    }

    public void drawBodyPart() {
        int lives = game.getGuessesLeft();
        if (isPlaying) {
            if (lives == 9) {
                remove(h0);
                add(h1);
            } else if (lives == 8) {
                remove(h1);
                add(h2);
            } else if (lives == 7) {
                remove(h2);
                add(h3);
            } else if (lives == 6) {
                remove(h3);
                add(h4);
            } else if (lives == 5) {
                remove(h4);
                add(h5);
            } else if (lives == 4) {
                remove(h5);
                add(h6);
            } else if (lives == 3) {
                remove(h6);
                add(h7);
            } else if (lives == 2) {
                remove(h7);
                add(h8);
            } else if (lives == 1) {
                remove(h8);
                add(h9);
            } else {
                remove(h9);
                add(h10);
                isPlaying = false;
            }
        }
    }

    public void keyPressed(KeyEvent event) {
        String letter = KeyEvent.getKeyText(event.getKeyCode()).toUpperCase();
        // add code here to finish task #1
        
        if (game.makeGuess(letter)) {
            puzzleLabel.setText(game.getPuzzle());
        } else {
            drawBodyPart();
        }

        lettersGuessedLabel.setText("Letters guessed: " + game.getLettersGuessed());
    }

    public void endGame(boolean hasWon) {
        removeAll();

        GLabel gameOverMessage;

        if (hasWon) {
            gameOverMessage = new GLabel("You won! the word was: " + game.getActualAnswer() + ".");
            gameOverMessage.setColor(Color.GREEN);
        } else {
            gameOverMessage = new GLabel("You Lost! the word was: " + game.getActualAnswer() + ".");
            gameOverMessage.setColor(Color.RED);
        }

        gameOverMessage.setFont("TimesNewRoman-Bold-24");
        gameOverMessage.setLocation(WIDTH / 2 - gameOverMessage.getWidth() / 2, 50);
        add(gameOverMessage);
        pause(50);

        GLabel playAgain = new GLabel("Click to Play Again.");
        playAgain.setFont("TimesNewRoman-Bold-20");
        playAgain.setLocation(WIDTH / 2 - playAgain.getWidth() / 2, HEIGHT / 2 - playAgain.getHeight() / 2);
        add(playAgain);
        waitForClick();
        removeAll();
    }

}
