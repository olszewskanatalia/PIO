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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;

/**
 *
 * @author jakub
 */
public class Player extends Thread
{
    private String nickname;
    private String color;
    private Socket playerSocket;
    private boolean ready;
    private PrintWriter output;
    
    private boolean isOnline;
    
    public ServerCommunication communication;
    public List<Player> players;
    
    public Player(Socket playerSocket, List<Player> players, ServerCommunication communication) throws IOException
    {
        if (addPlayer(playerSocket))
        {
            this.ready = false;
            this.output = new PrintWriter(this.playerSocket.getOutputStream(), true);
            this.players = players;
            this.communication = communication;
            this.isOnline = true;
            if (!addToPlayersList(players))
            {
                playerSocket.close();
            }
            this.start();
            System.out.println("Dodano gracza : " + this.nickname);
            System.out.println("Liczba graczy : " + players.size());
        }
        else
        {
            playerSocket.close();
        }
        
    }
    
    public boolean addPlayer(Socket playerSocket) throws IOException
    {
        BufferedReader input = new BufferedReader( new InputStreamReader(playerSocket.getInputStream()) );
        this.playerSocket = playerSocket;
        this.nickname = input.readLine();
        for (Player p: players)
        {
            if (nickname.equals(p.getNickname()))
            {
                return false;
            }
        }
        return true;
    }
    
    public synchronized boolean addToPlayersList(List<Player> players)
    {
        if(players.size() < 6)
        {
            players.add(this);
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public synchronized String changePlayerStatus()
    {
        return "nick='" + nickname + "', ready='" + ready + "'";
    }
    
    public synchronized String packPlayerToString()
    {
        return "nick='" + nickname + "', color='" + color + "', ready='" + ready + "'";
    }
    
    public synchronized boolean getIsReady()
    {
        return ready;
    }
    
    public String getNickname()
    {
        return nickname;
    }
    
    public void sendMessageToPlayer(String message)
    {
        output.println(message);
    }
    
    public void reciveMessageFromPlayer() throws IOException
    {
        try
        {
            BufferedReader input = new BufferedReader( new InputStreamReader(playerSocket.getInputStream()) );
            System.out.println("Dostano : " + input.readLine());
        }
        catch (IOException e)
        {
            isOnline = false;
        }
    }
    
    

    @Override
    public void run() 
    {
        while (isOnline)
        {
            try 
            {
                reciveMessageFromPlayer();
            } 
            catch (IOException ex) 
            {
                isOnline = false;
            }
        }
        System.out.println("Wyrzucono gracza : " + nickname);
        players.remove(this);
        System.out.println( "Liczba graczy : " + players.size() );     
    }
    
}
