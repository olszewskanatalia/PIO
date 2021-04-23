/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chineseclientapplication;

import java.util.List;

public class Player 
{
    private String nickname;
    private String color;
    private boolean ready;
    
    private List<Player> playerList;
    
    public Player(String nickname, String color, boolean ready, List<Player> playerList)
    {
        this.nickname = nickname;
        this.color = color;
        this.ready = ready;
        this.playerList = playerList;
        this.playerList.add(this);
    }
    public void changePlayerStatus(boolean ready)
    {
        this.ready = ready;
    }
    public boolean getPlayerStatus()
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
    public void removePlayer()
    {
        playerList.remove(this);
    }
}
