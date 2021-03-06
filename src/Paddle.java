import java.awt.*;

public class Paddle {
    private int x,y;
    private final int WIDTH = 100,HEIGHT = 20,SPEED = /*7*/10;

    Game game;
    Ball ball;
    Board board;

    public Paddle(Game game,Ball ball,Board board){
        x=0;
        y=0;

        this.board = board;
        this.game=game;
        this.ball=ball;
    }

    public void move(){
        if(game.isLeftPressed()){
            if(x>0){
                x-=SPEED;
            }
        }
        if(game.isRightPressed()){
            if(x+WIDTH<board.getWidth()){
                x+=SPEED;
            }
        }

    }

    public Rectangle getBounds(){
        return new Rectangle(x,y,WIDTH,HEIGHT);
    }

    public void setPosition(int x,int y){
        this.x = x - WIDTH/2;
        this.y = y - HEIGHT/2;
    }

    public void paint(Graphics g){
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x,y,WIDTH,HEIGHT);
        g.setColor(Color.GRAY);
        g.fillRect(x+WIDTH/4,y+HEIGHT/4,WIDTH/2,HEIGHT/2);
        g.drawLine(x,y,x+WIDTH/4,y+HEIGHT/4);
        g.drawLine((x+WIDTH*3/4),(y+HEIGHT*3/4),(x+WIDTH),(y+HEIGHT));
        g.drawLine((x+WIDTH*3/4),(y+HEIGHT/4),(x+WIDTH),(y));
        g.drawLine((x+WIDTH*3/4),(y+HEIGHT/4),(x+WIDTH),(y));
        g.drawLine((x+WIDTH/4),(y+HEIGHT*3/4),(x),(y+HEIGHT));


    }

}


