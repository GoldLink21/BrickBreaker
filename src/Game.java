import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JFrame implements KeyListener {

    private Board board;

    private boolean rightPressed,leftPressed;

    public Game(){
        setVisible(true);
        setResizable(false);
        setFocusable(true);
        setTitle("Brick Breaker");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        board = new Board(this);
        add(board);

        addKeyListener(this);

        pack();
        setLocationRelativeTo(null);
        board.gameStart();
    }

    public static void main(String[]args){
        new Game();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_RIGHT)
            rightPressed = true;
        if(e.getKeyCode()==KeyEvent.VK_LEFT)
            leftPressed = true;

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_RIGHT)
            rightPressed = false;
        if(e.getKeyCode()==KeyEvent.VK_LEFT)
            leftPressed = false;
    }

    public boolean isRightPressed(){return rightPressed;}
    public boolean isLeftPressed(){return leftPressed;}
}
