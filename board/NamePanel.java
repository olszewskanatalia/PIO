package board;

import javax.swing.*;
import java.awt.*;

public class NamePanel extends JPanel {

    private String name = "NONAME";
    private Integer xPos = 0;
    private Integer yPos = 0;
    private JLabel nameLabel = new JLabel();

    public NamePanel(String nick,Integer x, Integer y) {

        name = nick;
        xPos = x;
        yPos = y;

        nameLabel.setText(name);
        nameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        add(nameLabel);
        setBackground(Color.LIGHT_GRAY);
        setBounds(xPos, yPos, 200, 40);
    }



}
