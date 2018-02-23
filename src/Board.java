import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Board extends JPanel implements ActionListener {

    private final int BOARD_WIDTH = 805,BOARD_HEIGHT = 700,PADDLE_Y = BOARD_HEIGHT-50;

    public static int Ticks = 0;

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

    public void resetGame(){
        player.setPosition(BOARD_WIDTH/2,PADDLE_Y);
        ball.reset(this);
        Data.setScore(0);
        ground.fillBoard();
    }

    public int getPaddleY(){return PADDLE_Y;}

    /*
    public static int getTicks(){return Ticks;}

    public static void resetTicks(){Ticks = 0;}
    */

    @Override
    public void actionPerformed(ActionEvent e) {
        if(Data.isPlay()) {
            ball.move();
            player.move();
            ball.checkCollisions(player, ground);
            ground.checkCollision(ball);
            if(ground.checkBoard()){
                Data.toggleEnd();
            }
        }
        /*NOT IMPLEMENTED
        if(Data.isPlay()) {
            Ticks++;
            if (Ticks == 1000)
                Ticks = 0;
        }
        */
        repaint();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Font scoreFont = new Font("TimesRoman", Font.PLAIN,30);
        Font endFont = new Font("TimesRoman",Font.BOLD, 40);
        Font titleFont = new Font("Serif",Font.BOLD,75);
        if(Data.isPlay()) {
            g.setColor(Color.lightGray);
            g.drawLine(0,PADDLE_Y,getWidth(),PADDLE_Y);
            g.drawLine(0,PADDLE_Y+1,getWidth(),PADDLE_Y+1);
            player.paint(g);
            ground.paint(g);
            ball.paint(g);
            g.setColor(Color.WHITE);
            g.setFont(scoreFont);
            //printSimpleString(Data.getScoreString(), 1, getWidth()-50,26,g);
            g.drawString("Score: "+Data.getScoreString(),5,26);
            //g.drawString(Integer.toString(Ticks),5,26+27);
        }else if(Data.isEnd()){
            g.setFont(endFont);
            printSimpleString(" You cleared all the tiles with "+Data.getScoreString()+" points ",getWidth(),0,(int)(getHeight()*1.0/3.0),g);
            printSimpleString(" Press Space to return to the menu ",getWidth(),0,(int)(getHeight()*1.5/3.0),g);

        }else if(Data.isPause()){
            g.setFont(endFont);
            printSimpleString(" You have paused ",getWidth(),0,(int)(getHeight()*1.0/3.0),g);
            printSimpleString(" Current score: "+Data.getScoreString()+" points ",getWidth(),0,(int)(getHeight()*1.75/3.0),g);
            printSimpleString(" Press P to continue ",getWidth(),0,(int)(getHeight()*2.2/3.0),g);
        }else if(Data.isMenu()){
            g.setFont(titleFont);
            printSimpleString(" Brick Breaker ",getWidth(),0,(int)(getHeight()*1.2/3.0),g);
            g.setFont(scoreFont);
            printSimpleString(" Press Space to play ",getWidth(),0,(int)(getHeight()*1.5/3.0),g);
        }
    }

    public void DEBUG_KILL(){
        if(Data.DEBUG()) {
            for (int col = ground.getColumns() - 1; col >= 0; col--) {
                for (int row = ground.getRows() - 1; row >= 0; row--) {
                    ground.getTile(row, col).reduceHp();
                }
            }
        }
    }

    private void printSimpleString(String s, int width, int XPos, int YPos, Graphics g2d){
        //returns the LENGTH of the STRING parameter to the variable stringLen
        int stringLen = (int)g2d.getFontMetrics().getStringBounds(s, g2d).getWidth();
        //determines the center of the WIDTH parameter and subtracts the center of the length
        //to determine the X value to start the string
        int start = width/2 - stringLen/2;
        //prints s at the desired X position with adjustment and the desired y.
        g2d.drawString(s, start + XPos, YPos);
    }

}
