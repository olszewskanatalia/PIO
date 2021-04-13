package paczka;

import java.awt.EventQueue;



public class Test_Okna_Akceptacji {
    public static void main(String[] args)  {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ObrazFrame();

            }

        });

    }
}