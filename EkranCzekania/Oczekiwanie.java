package EkranCzekania;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Oczekiwanie extends JFrame{
    private static JFrame frame = new JFrame();
    private static Icon gif;
    private static JLabel g;
    public Oczekiwanie(){
        gif = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("lad.gif")));
        g = new JLabel(gif);
        frame.getContentPane().add(g);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(40, 40, 20, 40));
        panel.setLayout((new GridLayout(0, 1)));
        panel.add(g);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Oczekiwanie na połączenie...");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public void pokaz_ekran_czekania(){
        new Oczekiwanie();
    }
    public void przestan_pokazywac_ekran_czekania(){
        Oczekiwanie.frame.dispose();
    }
}
