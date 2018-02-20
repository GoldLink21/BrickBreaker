import java.awt.*;

public class Tile {
    //Use #s to represent HP
    int x,y,hp;

    //Gap(7) is the distance between tiles,Width(40),Height(20)
    final private int HEIGHT = 25,WIDTH = 65, GAP = 2;

    public Tile(int x,int y,int hp){
        setPosition(x,y);
        setHp(hp);
    }

    //Snaps to grid positions
    public void setPosition(int x,int y){
        //
        this.x = GAP+(x*(WIDTH+GAP));
        this.y = GAP+(y*(HEIGHT+GAP));
    }

    //Sets hp of block
    public void setHp(int hp){this.hp = hp;}

    public int getX(){return x;}

    public int getY(){return y;}

    public int getHp(){return hp;}

    public Rectangle getBounds(){return new Rectangle(x,y,WIDTH,HEIGHT);}

    public void paint(Graphics g){g.fillRect(x,y,WIDTH,HEIGHT);}

    public void reduceHp(int amount){
        this.hp -= amount;
        if(this.hp<0)
            this.hp=0;
    }

    public void reduceHp(){
        if(hp>0)
            hp--;
    }

    public void checkCollision(Ball other){
        double fraction = 5.0;
        double right = x+WIDTH-(WIDTH/fraction), left = x+(WIDTH/fraction);
        double up = y+(HEIGHT/fraction),down = y+HEIGHT-(HEIGHT/fraction);
        if(other.getBounds().intersects(this.getBounds())&&hp>0) {

            //touching top
            if ((up > other.getY())&&(other.getDy()>0)) {
                other.flipY();
                //touching bottom
            } else if (down < other.getY() + other.getDiam()&&(other.getDy()<0)) {
                other.flipY();
            }
            //touching left
            if (left > other.getX()&&other.getDx()>0) {
                other.flipX();
                //touching right
            } else if (right < other.getX()&&other.getDx()<0){
                other.flipX();
            }
            Data.increaseScore(this);
            reduceHp();
        }
    }
}
