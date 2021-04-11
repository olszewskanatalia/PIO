/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chineseserverapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jakub
 */
public class WaitingRoom extends Thread {
    
    public ArrayList<Player> players;
    public Socket playerSocket;
            
    public WaitingRoom(Socket socket, ArrayList<Player> players)
    {
        this.players = players;
        this.playerSocket = socket;
    }

    @Override
    public void run() 
    {
        if (players.size() < 7)
        {
            try 
            {
                Player newPlayer = new Player(playerSocket);
                
            }
            catch (IOException ex) 
            {
                Logger.getLogger(WaitingRoom.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                    /*
        try
        {
            
            while (true)
            {
                String outputString = input.readLine();
                if(outputString.equals("exit"))
                {
                    break;
                }
                printToAllClients(outputString);
               System.out.println("Server recived : "+ outputString);
            }
            
        }
        catch(Exception e)
        {
            System.out.println("Error : " + e.getStackTrace());
        }*/
    }
    private void printToAllClients(String outputString)
    {
        /*
        for(Communication cl: commList)
        {
            
        }*/
    }
}
