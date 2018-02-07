public class Tile {
    //Use #s to represent HP
    int x,y,hp;
    final private int HEIGHT = 20,WIDTH = 20, GAP = 5;

    //Without an hp in the constructor, it auto sets to 0, which means no tile there
    public Tile(int x, int y){
        setPosition(x,y);
        setHp(0);
    }

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
    public void setHp(int hp){
        this.hp = hp;
    }

    public int getX(){ return x; }

    public int getY(){return y;}

    public int getHp(){return hp;}



}
