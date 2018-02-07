import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Board extends JPanel implements ActionListener {

    Ball ball;
    Paddle player;
    Timer timer;

    Tile[][] board;

    public Board(){
        board = new Tile[1][1];
        setBackground(Color.YELLOW);
        setPreferredSize(new Dimension(805, 600));
        ball = new Ball();
        player = new Paddle();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
