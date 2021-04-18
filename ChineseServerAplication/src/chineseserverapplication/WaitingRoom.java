/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chineseserverapplication;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author jakub
 */
public class WaitingRoom extends Thread {
    
    public List<Player> players;       
    ServerCommunication communication;
    BoardLogic board;
    
    public WaitingRoom(List<Player> players, ServerCommunication communication, BoardLogic board)
    {
        this.players = players;
        this.communication = communication;
        this.board = board;
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
                while(!board.getIsStarted())
                {
                    Socket socket = serverSocket.accept();
                    if (players.size() < 6 && !board.getIsStarted())
                    {
                        addNewPlayer(socket, board);
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
            System.exit(100);
        }
        
    }
    public void addNewPlayer(Socket socket, BoardLogic board)
    {
        Thread t = new Thread(() -> {
            try
            {
                Player newPlayer = new Player(socket, players, communication, board);
                
            }
            catch (IOException ex)
            {
                System.out.println("Nie udało się połączyć użytkownika.");
            } 
        });
        t.start();
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
    
    
    public static void waitingRoom( List<Player> players, ServerCommunication communication, BoardLogic board) throws IOException
    {
        WaitingRoom waitingRoom = new WaitingRoom(players, communication, board);
        waitingRoom.start();
        while (!isPlayersReady(players))
        {

        }
        System.out.println("Rozpoczęto grę");
        
    }
}
