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
public class Player extends Thread
{
    private String nickname;
    private String color;
    private Socket playerSocket;
    private boolean ready;
    private PrintWriter output;
    
    private ArrayList<Player> players;
    
    public Player(Socket playerSocket, ArrayList<Player> players) throws IOException
    {
        if (addPlayer(playerSocket))
        {
            this.ready = false;
            this.output = new PrintWriter(this.playerSocket.getOutputStream(), true);
            System.out.println("Dodano Gracza : " + this.nickname);
            this.players = players;
            this.start();
        }
        else
        {
            playerSocket.close();
        }
        
    }
    
    public Socket getSocket()
    {
        return playerSocket;
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
        catch (Exception e)
        {
            players.remove(this);
            System.out.println("Wyrzucono gracza : " + nickname);
            this.stop();
        }
    }
    
    public boolean addPlayer(Socket playerSocket) throws IOException
    {
        BufferedReader input = new BufferedReader( new InputStreamReader(playerSocket.getInputStream()) );
        this.playerSocket = playerSocket;
        this.nickname = input.readLine();
        return true;
    }

    /**
     *
     * @throws IOException
     */
    @Override
    public void run() 
    {
        while (true)
        {
            try 
            {
                reciveMessageFromPlayer();
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
