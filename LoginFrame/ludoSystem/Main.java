package ludoSystem;


import Login.LoginPanel;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;

public class Main {



    public static void main(String[] args) throws InterruptedException, InvocationTargetException {

        ConnectionObject cos = new ConnectionObject();

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginPanel lp =  new LoginPanel();
                while(lp.isActive())
                {
                    System.out.println("n");
                }
                cos.setConnectionParameters(lp.co.getNick(),lp.co.getIpSerwer(),lp.co.getIpPort());

            }
        });






    }
}
