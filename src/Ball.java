import java.awt.*;

public class Ball {
    int x,y;
    final private int diam = 25;
    public Ball(){

    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void move(){

    }

    public int getX(){return x;}

    public int getY(){return y;}

    public void paint(Graphics g){
        g.fillOval(x,y,diam,diam);
    }


}
