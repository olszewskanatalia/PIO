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
import java.util.List;
import java.util.Scanner;

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
    public BoardLogic board;
    public Colors colors;
    
    public Player(Socket playerSocket, List<Player> players, ServerCommunication communication, BoardLogic board, Colors colors) throws IOException
    {
        this.players = players;
            if (addPlayer(playerSocket, colors))
            {
                this.ready = false;
                this.output = new PrintWriter(this.playerSocket.getOutputStream(), true);
                this.communication = communication;
                this.isOnline = true;
                this.board = board;
                this.colors = colors;
                if (!addToPlayersList(players, board))
                {
                    playerSocket.close();
                    return;
                }
                communication.sendInfoAboutPlayers(this);
                this.start();
                System.out.println("Dodano gracza : " + this.nickname);
                System.out.println("Liczba graczy : " + players.size());
            }
            else
            {
                playerSocket.close();
                System.out.println("Nie udało się dodać gracza : " + nickname);
            }
        
        
        
    }
    
    public synchronized boolean addPlayer(Socket playerSocket, Colors colors) throws IOException
    {
        Scanner input = new Scanner( new InputStreamReader(playerSocket.getInputStream()) );
        this.playerSocket = playerSocket;
        this.nickname = input.next();
        if (!players.isEmpty())
        {
            if (!players.stream().noneMatch((p) -> (nickname.equals(p.getNickname())))) 
            {
                return false;
            }
        }
        
        try 
        {
            this.color = colors.getFreeColor();
        }
        catch (Exception e)
        {
           System.out.println("nie udało się wybrać koloru"); 
        }
        return this.color != null;
        
    }
    
    public synchronized BoardLogic getBoard()
    {
        return board;
    }
    public synchronized boolean addToPlayersList(List<Player> players, BoardLogic board)
    {
        if(players.size() < 6 && !board.getIsStarted())
        {
            communication.addPlayer(this);
            players.add(this);
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public synchronized void changePlayerStatus()
    {
        ready = !ready;
    }
    
    public synchronized boolean getIsReady()
    {
        return ready;
    }
    
    public String getNickname()
    {
        return nickname;
    }
    public String getColor()
    {
        return color;
    }
    
    public void sendMessageToPlayer(String message)
    {
        output.println(message);
    }
    
    public void reciveMessageFromPlayer() throws IOException
    {
        try
        {
            Scanner input = new Scanner( new InputStreamReader(playerSocket.getInputStream()) );
            communication.makeAsk(this, input.next() , getBoard() );
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
        board.removePlayer();
        communication.removePlayer(this);
        colors.freeColor(color);
        
        System.out.println("Wyrzucono gracza : " + nickname);
        players.remove(this);
        System.out.println( "Liczba graczy : " + players.size() );     
    }
    
}
