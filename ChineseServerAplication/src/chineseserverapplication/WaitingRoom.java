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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jakub
 */
public class WaitingRoom extends Thread {
    
    public List<Player> players;       
    
    public WaitingRoom(List<Player> players)
    {
        this.players = players;
    }

    @Override
    public void run() 
    {
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(0);
            System.out.println("Server ip : " + serverSocket.getLocalPort() );
            List<WaitingRoom> waitingrooms = new ArrayList<>();
            try
            {
                while(true)
                {
                    Socket socket = serverSocket.accept();
                    if (players.size() < 6)
                    {
                        try 
                        {
                            Player newPlayer = new Player(socket, players);

                        }
                        catch (IOException ex) 
                        {
                            System.out.println("Nie udało się połączyć użytkownika.");
                        }
                    }
                    else
                    {
                        socket.close();
                    }
                }
            }
            catch (IOException e)
            {
                System.out.println("err : "+ e.getStackTrace());
            }
            finally
            {
                serverSocket.close();
            }
        } 
        catch (IOException ex) 
        {
            System.out.println("Nie udało sę utworzyć servera");
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
    
    public static boolean isPlayersReady(List<Player> players)
    {
        for (Player p : players) 
        {
            if (!p.getIsReady())
            {
                return false;
            }
        }
        return true;
    }
    
    
    public static void waitingRoom( List<Player> players) throws IOException
    {
        WaitingRoom waitingRoom = new WaitingRoom(players);
        waitingRoom.run();
    }
}
