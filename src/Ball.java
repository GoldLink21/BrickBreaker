import java.awt.*;

public class Ball {
    int x,y;
    final private int diam = 25;

    double MAXANGLE = 5*Math.PI/12;

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

    public Rectangle getBounds(){
        return new Rectangle(x, y, diam, diam);
    }

    public void checkCollisions(Paddle other){
        double paddleY = other.getBounds().getY();
        double paddleC = other.getBounds().getHeight()/2;
        double bally = y;

        double bounceAngle = MAXANGLE * (((paddleY + paddleC) - bally)/paddleC);
    }

}
