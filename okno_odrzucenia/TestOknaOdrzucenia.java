
package okno_odrzucenia;

import java.awt.EventQueue;

public class TestOknaOdrzucenia {
    public static void main(String[] args)  {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ObrazFrameOdrzucenia();

            }

        });

    }
}
