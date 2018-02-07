import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JFrame implements KeyListener {

    Board board;

    public Game(){
        setVisible(true);
        setResizable(false);
        setFocusable(true);
        setTitle("Brick Breaker");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //With a gap of 5, and a size of 20 this allows 32 blocks horizontally
        //and 12 vertically which leaves the player half the screen
        board = new Board();
        add(board);
        addKeyListener(this);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[]args){
        new Game();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
