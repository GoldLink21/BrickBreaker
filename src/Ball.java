import java.awt.*;

public class Ball {
    private final int diam = 20;

    //This allows me to possibly change the speed later
    private int SPEED = 6;

    int x,y;

    private double dx=0,dy=-SPEED;

    //5*Math.PI/12
    private double MAXANGLE = Math.PI/3;

    Board board;

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
        /* NOT IMPLEMENTED
        if(board.getTicks()==999){
            //SPEED +=0.3;
        }*/
    }

    public int getX(){return x;}
    public int getY(){return y;}
    public int getDiam(){return diam;}
    public double getDx(){return dx;}
    public double getDy(){return dy;}

    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval(x,y,diam,diam);
        g.setColor(Color.BLACK);
        int rad = diam/2;
        g.fillOval(x+rad/2,y+rad/2,rad,rad);
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, diam, diam);
    }

    public void flipX(){
        dx*=-1;
    }
    public void flipY(){
        dy*=-1;
    }

    public void reset(Board board){
        dx=0;
        dy=-SPEED;
        setPosition(board.getWidth()/2,board.getPaddleY()-50);
    }

    public void checkCollisions(Paddle other,Ground ground){

        //This is for the paddle
        if(getBounds().intersects(other.getBounds())){
            double paddleX = other.getBounds().getX();
            double paddleC = other.getBounds().getWidth()/2;

            double bounceAngle = MAXANGLE * (((paddleX + paddleC) - x)/paddleC);

            dy = (int) -(SPEED * Math.cos(bounceAngle));
            dx = (int)(SPEED*-Math.sin(bounceAngle));
        }

        //If ball goes below line
        if(y+diam/2.0>board.getPaddleY()){
            Data.setScore(Data.getScore()-50);
            setPosition(board.getWidth()/2,board.getPaddleY()-15);
            flipY();
        }
    }


}
