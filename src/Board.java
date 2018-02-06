import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JPanel implements ActionListener {
    Tile[][] board;
    public Board(){
        board = new Tile[1][1];
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
