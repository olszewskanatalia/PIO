package net.mindview.util;
//szybki model tworzenia okienka

import javax.swing.*;

public class SwingControl {
    public static void
     run(final JFrame f,final int width, final int height, final String title){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    f.setTitle(title);
                    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    f.setSize(width,height);
                    f.setVisible(true);
                }
            });
    }
}
