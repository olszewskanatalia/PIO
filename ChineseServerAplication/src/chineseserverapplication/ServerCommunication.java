/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chineseserverapplication;

import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;

/**
 *
 * @author jakub
 */
public class ServerCommunication extends Thread
{
    public List<Player> players;
    
    private List<InternalAsk> internalAsks;
    public ServerCommunication(List<Player> players)
    {
        this.players = players;
        this.internalAsks = new ArrayList<>();
    }
    public synchronized void addToAsks(String nickname, JSONObject json)
    {
        internalAsks.add(new InternalAsk(nickname, json));
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
        for (Player p : players)
        {
            p.sendMessageToPlayer(message);
        }
    }
    
    public void run()
    {
        while (true)
        {
            if (internalAsks.size() > 0)
            {
                System.out.println(internalAsks.get(0).getNickname() + " : " + internalAsks.get(0).getJson());
            }
        }
    }
}


class InternalAsk
{
    private String nickname;
    private JSONObject json;
    public InternalAsk(String nickname, JSONObject json)
    {
        this.nickname = nickname;
        this.json = json;
    }
    public String getNickname()
    {
        return nickname;
    }
    public JSONObject getJson()
    {
        return json;
    }
}