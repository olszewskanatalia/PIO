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

/**
 *
 * @author jakub
 */
public class Player 
{
    private String nickname;
    private String color;
    private Socket playerSocket;
    private boolean ready;
    private PrintWriter output;
    
    public Player(Socket playerSocket) throws IOException
    {
        if (addPlayer(playerSocket))
        {
            this.ready = false;
            this.output = new PrintWriter(this.playerSocket.getOutputStream(), true);
            System.out.println("Dodano Gracza : " + this.nickname);
            this.run();
        }
        else
        {
            playerSocket.close();
        }
        
    }
    
    public void sendMessageToPlayer(String message)
    {
        output.println(message);
    }
    
    public void reciveMessageFromPlayer() throws IOException
    {
        BufferedReader input = new BufferedReader( new InputStreamReader(playerSocket.getInputStream()) );
        System.out.println("Dostano : " + input.readLine());
    }
    
    public boolean addPlayer(Socket playerSocket) throws IOException
    {
        BufferedReader input = new BufferedReader( new InputStreamReader(playerSocket.getInputStream()) );
        this.playerSocket = playerSocket;
        this.nickname = input.readLine();
        return true;
    }
    public void run() throws IOException
    {
        while (true)
        {
            reciveMessageFromPlayer();
        }
    }
    
}
