/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chineseserverapplication;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;





public class ChineseServerApplication 
{  
    
    
    public static void main(String[] args) throws IOException
    {
        //List usunąć z 2 wszystko
        List<Player> players = new ArrayList<>();
        Communication communication = new Communication(players);
        
        communication.start();
        WaitingRoom.waitingRoom(players);
        System.out.println("Rozpoczęto grę");
    }
}
