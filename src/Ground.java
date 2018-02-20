import java.awt.*;

public class Ground {

    Tile[][] ground;
    Ball ball;

    //Row is how many horizontally (10), col is how many vertically
    //TILE_COLUMN = 10, TILE_ROW = 12
    private final int TILE_COLUMN = 1, TILE_ROW = 1;

    public Ground() {
        ground = new Tile[TILE_ROW][TILE_COLUMN];
        fillBoard();
    }

    public void fillBoard() {
        for (int col = TILE_COLUMN - 1; col >= 0; col--) {
            for (int row = TILE_ROW - 1; row >= 0; row--) {
                ground[row][col] = new Tile(row, col, (TILE_COLUMN - col+1)/2 );
            }
        }
    }

    public boolean checkBoard(){
        for (int col = TILE_COLUMN - 1; col >= 0; col--) {
            for (int row = TILE_ROW - 1; row >= 0; row--) {
                if(ground[row][col].getHp()>0)
                    return false;
            }
        }
        return true;
    }

    public void paint(Graphics g) {
        for (int col = TILE_COLUMN - 1; col >= 0; col--) {
            for (int row = TILE_ROW - 1; row >= 0; row--) {
                if (ground[row][col].getHp() > 0) {
                    chooseColor(row, col, g);
                    ground[row][col].paint(g);
                }
            }
        }
    }

    public void chooseColor(int row, int col, Graphics g) {
        int tileHp = ground[row][col].getHp();
        switch (tileHp) {
            case 1:g.setColor(Color.RED);break;
            case 2:g.setColor(Color.ORANGE);break;
            case 3:g.setColor(Color.GREEN);break;
            case 4:g.setColor(Color.CYAN);break;
            case 5:g.setColor(Color.BLUE);break;
            case 6:g.setColor(Color.PINK);break;
            case 7:g.setColor(Color.MAGENTA);break;
            case 8:g.setColor(Color.WHITE);break;
            case 9:g.setColor(Color.LIGHT_GRAY);break;
            case 10:g.setColor(Color.GRAY);break;
            case 11:g.setColor(Color.DARK_GRAY);break;
            default:g.setColor(Color.getHSBColor(90, 100, 100));break;
        }
    }

    public Rectangle getBounds(int x, int y) {
        return ground[x][y].getBounds();
    }

    public int getColumns() {
        return TILE_COLUMN;
    }

    public int getRows() {
        return TILE_ROW;
    }

    public Tile getTile(int x, int y) {
        if ((x >= 0 && x < TILE_ROW)&&(y>=0&&y<TILE_COLUMN))
            return ground[x][y];
        return null;
    }

    public void checkCollision(Ball other){
        this.ball = other;
        for (int col = TILE_COLUMN - 1; col >= 0; col--) {
            for (int row = TILE_ROW - 1; row >= 0; row--) {
                ground[row][col].checkCollision(ball);
            }
        }
    }
}
