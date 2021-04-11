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





public class ChineseServerApplication 
{  
    
    
    public static void main(String[] args) throws IOException
    {
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<WaitingRoom> waitingrooms = new ArrayList<WaitingRoom>();
        
        ServerSocket serverSocket = new ServerSocket(0);
        System.out.println("Server ip : " + serverSocket.getLocalPort() );
        try
        {
            while(true)
            {
                Socket socket = serverSocket.accept();
                if (players.size() < 7)
                {
                    WaitingRoom waitingroom = new WaitingRoom(socket, players);
                    waitingrooms.add(waitingroom);
                    waitingroom.start();
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("err : "+ e.getStackTrace());
        }
        finally
        {
            serverSocket.close();
        }
    }
}
