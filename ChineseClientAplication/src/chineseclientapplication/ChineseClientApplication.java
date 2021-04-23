/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chineseclientapplication;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jakub
 */
public class ChineseClientApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
       
        List<Player> playerList  = new ArrayList<>();
        
        Communication comm = new Communication("localhost", 6000, "nickname", playerList);
    }
    
}
