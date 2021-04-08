/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chineseserverapplication;

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
    public Player(String nickname, Socket playerSocket)
    {
        this.nickname = nickname;
        this.playerSocket = playerSocket;
    }
}
