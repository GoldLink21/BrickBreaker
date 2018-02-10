import java.awt.*;

public class Paddle {
    private int x,y;
    private final int WIDTH = 100,HEIGHT = 20,SPEED = 7;

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
        g.fillRect(x,y,WIDTH,HEIGHT);
    }

}


