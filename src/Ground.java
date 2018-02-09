import java.awt.*;

public class Ground {

    Tile[][] ground;

    //Row is how many horizontally (10), col is how many vertically
    private final int TILE_COLUMN = 10,TILE_ROW = 17;

    public Ground(){
        ground = new Tile[TILE_ROW][TILE_COLUMN];
        fillBoard();
    }

    public void fillBoard(){
        for(int col=TILE_COLUMN-1;col>=0;col--){
            for(int row = TILE_ROW-1;row>=0;row--){
                ground[row][col] = new Tile(row,col,TILE_COLUMN-col);
            }
        }
    }

    public void paint(Graphics g){
        for(int col=TILE_COLUMN-1;col>=0;col--){
            for(int row = TILE_ROW-1;row>=0;row--){
                if(ground[row][col].getHp()>0){
                    chooseColor(row,col,g);
                    ground[row][col].paint(g);
                }
            }
        }
    }

    public void chooseColor(int row,int col,Graphics g){
        int tileHp = ground[row][col].getHp();
        switch(tileHp){
            case 1:g.setColor(Color.RED);break;
            case 2:g.setColor(Color.ORANGE);break;
            case 3:g.setColor(Color.YELLOW);break;
            case 4:g.setColor(Color.GREEN);break;
            case 5:g.setColor(Color.BLUE);break;
            case 6:g.setColor(Color.CYAN);break;
            case 7:g.setColor(Color.PINK);break;
            case 8:g.setColor(Color.MAGENTA);break;
            case 9:g.setColor(Color.WHITE);break;
            case 10:g.setColor(Color.lightGray);break;
            case 11:g.setColor(Color.GRAY);break;
            case 12:g.setColor(Color.DARK_GRAY);break;
            default:g.setColor(Color.getHSBColor(90,100,100));break;
        }
    }

}
