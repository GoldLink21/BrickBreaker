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
        if(Data.isPlay()) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT)
                rightPressed = true;
            if (e.getKeyCode() == KeyEvent.VK_LEFT)
                leftPressed = true;
            if(e.getKeyCode() == KeyEvent.VK_P)
                Data.togglePause();
            if(e.getKeyCode()==KeyEvent.VK_K&&Data.DEBUG())
                board.DEBUG_KILL();
        }else if(Data.isMenu()){
            if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                Data.toggleMenu();
                board.resetGame();
            }
        }else if(Data.isPause()){
            if(e.getKeyCode() == KeyEvent.VK_P)
                Data.togglePause();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(Data.isPlay()) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT)
                rightPressed = false;
            if (e.getKeyCode() == KeyEvent.VK_LEFT)
                leftPressed = false;
        }else if(Data.isEnd()){
            if(e.getKeyCode() == KeyEvent.VK_SPACE)
                Data.toggleEnd();
        }
    }

    public boolean isRightPressed(){return rightPressed;}
    public boolean isLeftPressed(){return leftPressed;}
}
