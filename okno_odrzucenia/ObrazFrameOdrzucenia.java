
package okno_odrzucenia;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ObrazFrameOdrzucenia extends JFrame {
    public ObrazFrameOdrzucenia() {


        JPanel obrazPanel = new ObrazPanelOdrzucenia();
        add(obrazPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);

    }
}
