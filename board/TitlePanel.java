package board;

import javax.swing.*;
import java.awt.*;

public class TitlePanel extends JPanel {

    private JLabel title = new JLabel();

    public TitlePanel() {
        title.setText("LUDO GAME");
        title.setFont(new Font("Times New Roman", Font.BOLD, 40));
        title.setBackground(Color.YELLOW);
        add(title);
        setBackground(Color.LIGHT_GRAY);
        setBounds(650,0,650,50);
    }


}
