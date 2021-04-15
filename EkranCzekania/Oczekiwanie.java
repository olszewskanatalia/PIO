package EkranCzekania;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;
public class OknoOczekiwania extends JFrame{
    private Icon gif;
    private JLabel g;
    public OknoOczekiwania(){
        gif = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("lad.gif")));
        g = new JLabel(gif);
        getContentPane().add(g);

        JPanel panel = new JPanel();
        panel.setLayout((new GridLayout(0, 1)));
        panel.add(g);

        add(panel, BorderLayout.CENTER);
        setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
        setTitle("Oczekiwanie na połączenie...");
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static OknoOczekiwania pokaz_ekran_czekania(){
        OknoOczekiwania ocz = new OknoOczekiwania();
        return ocz;
    }
    public void przestan_pokazywac_ekran_czekania(){
        dispose();
    }

}
