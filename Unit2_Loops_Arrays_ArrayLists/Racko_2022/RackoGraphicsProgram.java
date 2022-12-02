//Roshan Taneja
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class RackoGraphicsProgram extends GraphicsProgram
{
    // constants for graphics layout
    private static final int WINDOWSIZE = 500;
    private static final int OFFSET = 20;  // offset from all edges of screen
    private static final int CARDHEIGHT = 40;
    private static final int MINCARDWIDTH = 60;

    // these are all constants for the private instance variable gameState
    private static final int GAME_OVER = -1;
    private static final int PICK_DECK_OR_DISCARD = 0;
    private static final int PICK_CARD_FROM_HAND = 1;
    private static final int WAITING_FOR_COMPUTER_MOVE = 2; 

    // private instance variables
    private RackoGame game;
    private ComputerPlayer computer;
    private int gameState;  // Bro this is basiccally an enum wdym
    private JLabel status;  // use status.setText to provide updates of status of game
    private int replacementCardValue;  // the card drawn from either the discard pile or deck
    private GLabel deckLabel;
    private GImage card;

     public void run()
    {
        initWindow();
        initVariables();
        drawGraphics();
        boolean outcome = false;

        while (gameState != GAME_OVER){
            pause(5);

            if(game.computerWins()){
                gameState = GAME_OVER;

            }
            if (game.playerWins()){
                outcome = true;
                gameState = GAME_OVER;
            }

            if (gameState == WAITING_FOR_COMPUTER_MOVE){
                makeComputerMove();
            }

        }
        gameOver(outcome);

    }

    public void initVariables()
    {
        game = new RackoGame();
        gameState = PICK_DECK_OR_DISCARD;
        computer = new PrettyGoodComputerPlayer();
    }

    public void initWindow()
    {
        setSize(WINDOWSIZE, WINDOWSIZE);
        setTitle("Rack-o");
        status = new JLabel("Your move!  Click on deck or discard pile.");
        add(status, NORTH);
    }

    public void drawGraphics()
    {
        drawHand();
        drawDeck();
        drawDiscard();
    }

    public void drawHand(){
        int[] hand = game.getPlayerHand();
        for(int i=0; i<hand.length; i++){
            int value = hand[i];
            GImage card = getCardForValue(value);
            card.setLocation(WINDOWSIZE-OFFSET-100, OFFSET + (CARDHEIGHT + 5) * i);
            add(card);
        }
    }

    public void drawDeck()
    {
        deckLabel = new GLabel("Deck",10, 100);
        deckLabel.setFont("Times-Bold-24");
        deckLabel.setColor(Color.RED);
        add(deckLabel);

    }

    public void drawDiscard(){

        int value = game.peekAtTopCardFromDiscardPile();
        card = getCardForValue(value);
        card.setLocation(10, 200);
        card.setColor(Color.BLUE);
        add(card);
    }

    public void mouseClicked(MouseEvent event)
    {
        if (gameState == GAME_OVER) return;
        else if(gameState == WAITING_FOR_COMPUTER_MOVE) return;
        else if(gameState == PICK_DECK_OR_DISCARD){
            if(getElementAt(event.getX(), event.getY()) != null){
                
                if(getElementAt(event.getX(), event.getY()).getColor() == Color.BLUE){
                    replacementCardValue = game.removeTopCardFromDiscardPile();

                } else if (getElementAt(event.getX(), event.getY()).getColor() == Color.RED){
                    replacementCardValue = game.removeTopCardFromDeck();

                } else return;
                gameState = PICK_CARD_FROM_HAND;
                status.setText("Where do you want to put " + replacementCardValue + "? Click on that card in your hand.");
            }
        } else if (gameState == PICK_CARD_FROM_HAND){
            //status.setText("Here");
            int value;
            if(getElementAt(event.getX(), event.getY()) == null){
                return;
            } else {
                GObject object = getElementAt(event.getX(), event.getY()); 
                
                if(object.getColor() == Color.RED || object.getColor() == Color.BLUE){
                    return;
                }else{
                    value = getValueForCard(object);
                }
                int index = 0;

                for(int i=0; i<game.getPlayerHand().length; i++){
                    if(game.getPlayerHand()[i] == value){
                        index = i;

                    }
                }
                game.makeMove(replacementCardValue, index, game.getPlayerHand());
                removeAll();
                drawGraphics();
                status.setText("Waiting for computer to move...");
                gameState = WAITING_FOR_COMPUTER_MOVE;

            }
        }
    }

    private void makeComputerMove()
    {

        pause(1000);
        boolean discard = computer.shouldDrawFromDiscardPile(game.peekAtTopCardFromDiscardPile(), game.getComputerHand());

        if (!discard){
            replacementCardValue = game.removeTopCardFromDeck();
            status.setText("Computer picks " + replacementCardValue + " from the deck...");
        } else {
            replacementCardValue = game.removeTopCardFromDiscardPile();
            status.setText("Computer picks " + replacementCardValue + " from the discard pile...");
        } 

        pause(1000);
        
        int index = computer.getIndexForReplacementCard(replacementCardValue, game.getComputerHand());
        game.makeMove(replacementCardValue, index, game.getComputerHand());
        status.setText("Computer replaces card #" + index + " in hand...");
        
        removeAll();
        drawGraphics();           
        pause(1000);

        gameState = PICK_DECK_OR_DISCARD;
        status.setText("Your move! Click on deck or discard pile.");

    }

    public void gameOver(boolean hasWon){
        gameState = GAME_OVER;
        GLabel gameOverMessage;

        if(hasWon){
            gameOverMessage = new GLabel("Congrats! You have won.");
            gameOverMessage.setColor(Color.GREEN);

        } else {
            gameOverMessage = new GLabel("Sorry bro, you lost...");
            gameOverMessage.setColor(Color.RED);
        }

        gameOverMessage.setFont("*-*-24"); 
        gameOverMessage.setLocation(WINDOWSIZE/2-gameOverMessage.getWidth()/2 - 50, WINDOWSIZE/2 - gameOverMessage.getHeight()/2 - 40);
        add(gameOverMessage);
    }

    // helper methods I wrote for you
    private GImage getCardForValue(int cardValue)
    {
        return new GImage("card_"+cardValue+".png");
    }

    private int getValueForCard(GObject card)
    {
        return (int)(card.getWidth()-MINCARDWIDTH);
    }

}
