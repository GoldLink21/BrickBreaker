import java.awt.*;

public class Ball {
    private final int SPEED = 5,diam = 25;;

    int x,y;

    private double dx=SPEED,dy=-SPEED;

    private double MAXANGLE = 5*Math.PI/12;

    Board board;
    Ground ground;

    public Ball(Board board){
        this.board = board;
        x=0;
        y=0;
    }

    public void setPosition(int x, int y){
        this.x = x-diam/2;
        this.y = y-diam/2;
    }

    public void move(){
        if(x+diam>board.getWidth()||x<0)
            dx*=-1;
        if(y<0)
            dy*=-1;

        if(y+diam>board.getHeight())
            dy*=-1;

        x+=dx;
        y+=dy;
    }

    public int getX(){return x;}
    public int getY(){return y;}

    public void paint(Graphics g){
        g.fillOval(x,y,diam,diam);
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, diam, diam);
    }

    public void checkCollisions(Paddle other,Ground ground){

        //This is for the paddle
        if(getBounds().intersects(other.getBounds())){
            double paddleX = other.getBounds().getX();
            double paddleC = other.getBounds().getWidth()/2;
            double ballX = x;

            double bounceAngle = MAXANGLE * (((paddleX + paddleC) - ballX)/paddleC);

            if(x+(diam/2) < paddleX)
                ballX = x;
            else if(x + diam/2 > paddleX + other.getBounds().getWidth())
                ballX = x;
            else
                ballX = x + diam/2;
            dy = (int) -(SPEED * Math.cos(bounceAngle));
            dx = (int)(SPEED*-Math.sin(bounceAngle));
        }
        


    }

}
