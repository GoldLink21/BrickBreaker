import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Board extends JPanel implements ActionListener {

    private final int BOARD_WIDTH = 795,BOARD_HEIGHT = 600,PADDLE_Y = BOARD_HEIGHT-20;

    Ball ball;
    Paddle player;
    Timer timer;
    Ground ground;

    public Board(Game game){
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
        //With a gap of 7, and a width of 40 this allows 17
        //blocks horizontally and however many vertically
        ball = new Ball(this);
        player = new Paddle(game,ball,this);
        ground = new Ground();
        player.setPosition(BOARD_WIDTH/2,PADDLE_Y);
        ball.setPosition(BOARD_WIDTH/2,PADDLE_Y-50);
    }

    public void gameStart(){



        timer = new Timer(1000/60,this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ball.move();
        player.move();
        ball.checkCollisions(player,ground);
        ground.checkCollision(ball);
        repaint();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.GRAY);
        player.paint(g);
        ground.paint(g);
        g.setColor(Color.white);

        ball.paint(g);
    }

}
