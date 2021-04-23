/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chineseclientapplication;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author jakub
 */
public class Communication extends Thread
{
    private Socket serverSocket;
    
    private boolean isConnected;
    
    private PrintWriter output;
    
    private List<Player> playerList;
    public Communication(String serverName, int port, String nickname, List<Player> playerList) throws IOException
    {
        connectToServer(serverName, port, nickname);
        if (isConnected)
        {
            System.out.println("Połaczono z serverem");
            this.start();
        }
        this.playerList = playerList;
    }
    
    private void connectToServer(String serverName, int port, String nickname) throws IOException
    {
        try
        {
            serverSocket = new Socket(serverName, port);
            if (serverSocket.isConnected())
            {
                output = new PrintWriter(serverSocket.getOutputStream(), true);
                sendToServer(nickname);
                isConnected = true;
            }
            else
            {
                isConnected = false;
            }
        }
        catch(IOException e)
        {
            isConnected = false;
        }
    }
    
    private void sendToServer(String message)
    {
        output.println(message);
    }
    
    private void decodeJson(String message)
    {
        try
        {
           JSONObject json = new JSONObject(message);
           String operation = json.getString("Operation");
           if (operation.equals("addPlayer"))
           {
               Player p = new Player(json.getString("nickname"), json.getString("Color"), json.getBoolean("status"), playerList);
           }
           else if (operation.equals("changePlayerStatus"))
           {
               for (Player p : playerList)
               {
                   if (json.getString("nickname").equals(p.getNickname()))
                   {
                       p.changePlayerStatus(json.getBoolean("status"));
                       break;
                   }
               }
           }
           else if (operation.equals("removePlayer"))
           {
               for (Player p : playerList)
               {
                   if (json.getString("nickname").equals(p.getNickname()))
                   {
                       p.removePlayer();
                       break;
                   }
               }
           }
        }
        catch (JSONException e)
        {
            
        }
    }
    
    private void reciveMessageFromServer() throws IOException
    {
        try
        {
            Scanner input = new Scanner( new InputStreamReader(serverSocket.getInputStream()) );
            String inputString = input.next();
            System.out.println(inputString);
            decodeJson(inputString);
        }
        catch (IOException e)
        {
            isConnected = false;
        }
    }
    
    @Override
    public void run()
    {
        while (isConnected)
        {
            try
            {
                reciveMessageFromServer();
            }
            catch (IOException ex) 
            {
                isConnected = false;
            }
        }
        System.out.println("Utracono połączenie");
    }
}
