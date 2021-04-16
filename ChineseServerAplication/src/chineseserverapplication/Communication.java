/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chineseserverapplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import javax.management.Query;
import org.json.simple.JSONObject;

/**
 *
 * @author jakub
 */
public class Communication extends Thread
{
    public List<Player> players;
    
    private List<InternalAsk> internalAsks;
    public Communication(List<Player> players)
    {
        this.players = players;
        this.internalAsks = new ArrayList<>();
    }
    public synchronized void addToAsks(String nickname, JSONObject json)
    {
        internalAsks.add(new InternalAsk(nickname, json));
    }
    
    public void sendToPlayer(String nickname)
    {
        
    }
    public void sendToPlayers()
    {
        
    }
    
    public void run()
    {
        while (true)
        {
            if (internalAsks.size() > 0)
            {
                
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