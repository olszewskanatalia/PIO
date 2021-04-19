/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chineseserverapplication;

import java.util.List;
import org.json.*;

/**
 *
 * @author jakub
 */
public class ServerCommunication
{
    public List<Player> players;
    
    public ServerCommunication(List<Player> players)
    {
        this.players = players;
    }
    public synchronized void makeAsk(Player player, String inMessage)
    {
        try
        {
            JSONObject json = new JSONObject(inMessage);
            System.out.println(json);
            String operation = json.getString("Operation");
            if (operation.equals("changePlayerStatus"))
            {
                player.changePlayerStatus();
                JSONObject toSend = new JSONObject();
                toSend.put("Operation", "changePlayerStatus");
                toSend.put("nickname", player.getNickname());
                toSend.put("status", player.getIsReady());
                sendToPlayer(player, toSend.toString());
            }
        }
        catch (JSONException e)
        {
            System.out.println("Błąd : " + player.getNickname() + " - " + inMessage);
        }
        
    }
    
    public void sendStartGameInfo(BoardLogic board)
    {
        
        for (OneColorPawns ocp : board.getPawnsList())
        {
            for (Pawn p : ocp.getPawnsList())
            {
                JSONObject toSend = new JSONObject();
                toSend.put("Operation", "initPawn");
                toSend.put("pawnID", p.getPawnID());
                toSend.put("color", p.getPawnColor());
                toSend.put("pawnPosition", p.getPositionString());
                sendToPlayers(toSend.toString());
            }
        }
        JSONObject toSend = new JSONObject();
        toSend.put("Operation", "startGame");
        sendToPlayers(toSend.toString());
    }
    
    public void sendInfoAboutPlayers(Player player)
    {
        for (Player p : players)
        {
            JSONObject toSend = new JSONObject();
            toSend.put("Operation", "addPlayer");
            toSend.put("nickname", p.getNickname());
            toSend.put("Color", p.getColor());
            toSend.put("status", p.getIsReady());
            sendToPlayer(player, toSend.toString());
        }
    }
    
    public void removePlayer(Player player)
    {
        JSONObject toSend = new JSONObject();
        toSend.put("Operation", "removePlayer");
        sendToPlayers(toSend.toString());
    }
    
    private void sendToPlayer(Player player, String message)
    {
        player.sendMessageToPlayer(message);
    }
    private void sendToPlayers(String message)
    {
        players.forEach((p) -> 
        {
            p.sendMessageToPlayer(message);
        });
    }
    
}