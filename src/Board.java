import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Board extends JPanel implements ActionListener {
    List<Tile> board;
    public Board(){
        board = new ArrayList<Tile>();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
