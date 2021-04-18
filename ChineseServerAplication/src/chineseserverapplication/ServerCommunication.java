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
                sendToPlayer(player.getNickname(), toSend.toString());
            }
        }
        catch (JSONException e)
        {
            System.out.println("Błąd : " + player.getNickname() + " - " + inMessage);
        }
        
    }
    
    public void sendToPlayer(String nickname, String message)
    {
        for (Player p : players)
        {
            if (p.getNickname().equals(nickname))
            {
                p.sendMessageToPlayer(message);
                return;
            }
        }
        
        
    }
    public void sendToPlayers(String message)
    {
        players.forEach((p) -> 
        {
            p.sendMessageToPlayer(message);
        });
    }
    
}