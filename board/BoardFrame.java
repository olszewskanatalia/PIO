package board;

import Player.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BoardFrame extends JFrame {


    public JFrame frame = new JFrame();

    public static void main (String [] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {

                    List<Player> playerList = new ArrayList<Player>();
                    new Player("Player1", "RED",true, playerList);
                    new Player("Player2", "BLUE", true, playerList);
                    new Player("Player3", "BLACK", true, playerList);
                    new Player("Player4", "GREEN", true, playerList);
                    new Player("Player5", "YELLOW", true, playerList);
                    new Player("Player6", "PURPLE", true, playerList);


                   new BoardFrame(playerList);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public BoardFrame(List<Player> pl) {
        BoardPanel board = new BoardPanel(new ImageIcon(getClass().getResource("/board.png")).getImage());
        board.setBounds(0,0,650,750);
        board.setLayout(null);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(300,100, 1300,790);
        frame.add(board);
        frame.add(new TitlePanel());
        frame.setVisible(true);
        NamePanels nps = new NamePanels(pl, frame);



    }
}
