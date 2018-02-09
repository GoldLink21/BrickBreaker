import java.awt.*;

public class Paddle {
    private int x,y;
    private final int WIDTH = 100,HEIGHT = 20;

    public Paddle(){

    }

    public void move(){

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


