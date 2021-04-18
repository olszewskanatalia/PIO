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

/**
 *
 * @author jakub
 */
public class WaitingRoom extends Thread {
    
    public List<Player> players;       
    ServerCommunication communication;
    
    public WaitingRoom(List<Player> players, ServerCommunication communication)
    {
        this.players = players;
        this.communication = communication;
    }

    @Override
    public void run() 
    {
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(6000);
            System.out.println("Server ip : " + serverSocket.getLocalPort() );
            try
            {
                while(true)
                {
                    Socket socket = serverSocket.accept();
                    if (players.size() < 6)
                    {
                        try 
                        {
                            Player newPlayer = new Player(socket, players, communication);

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

    public static synchronized boolean isPlayersReady(List<Player> players)
    {
        if (players.isEmpty())
        {
            return false;
        }
        for (Player p : players) 
        {
            if (!p.getIsReady())
            {
                return false;
            }
        }
        return true;
    }
    
    
    public static void waitingRoom( List<Player> players, ServerCommunication communication) throws IOException
    {
        WaitingRoom waitingRoom = new WaitingRoom(players, communication);
        waitingRoom.start();
        while (!isPlayersReady(players))
        {
            System.out.println("err");
        }
        System.out.println("Rozpoczęto grę");
    }
}
