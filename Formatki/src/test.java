
import Obiekty.ConnectionObject;
import Okna.LoginBoard;


import static net.mindview.util.SwingControl.run;

public class test {
    public static void main(String[] args) throws Exception {
        try {
            run(new LoginBoard(), 300, 400, "LUDOGAME");
            ConnectionObject co = new ConnectionObject();
            LoginBoard.getCo(co);
        } catch(NumberFormatException e) {
            ;
        }
    }


}
