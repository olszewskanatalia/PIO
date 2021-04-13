package paczka;




import javax.swing.JFrame;
import javax.swing.JPanel;


public class ObrazFrame extends JFrame {

    public ObrazFrame() {


        JPanel obrazPanel = new ObrazPanel();
        add(obrazPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);

    }

}


