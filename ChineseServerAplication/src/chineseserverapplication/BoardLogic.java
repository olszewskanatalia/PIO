/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chineseserverapplication;

import java.util.ArrayList;
import java.util.List;

public class BoardLogic
{
    private boolean isStared;
    
    int i;
    String playerTourNickname;
    
    
    List <OneColorPawns> colorPawns;
    List <Player> players;
    ServerCommunication communication;
    GameCube gameCube;
    String gameStatus;
    public BoardLogic(List <Player> players, ServerCommunication communication)
    {
        this.colorPawns = new ArrayList<>();
        this.colorPawns.add(new OneColorPawns("Zielony"));
        this.colorPawns.add(new OneColorPawns("Czarny"));
        this.colorPawns.add(new OneColorPawns("Żółty"));
        this.colorPawns.add(new OneColorPawns("Czerwony"));
        this.colorPawns.add(new OneColorPawns("Niebieski"));
        this.colorPawns.add(new OneColorPawns("Fioletowy"));
        
        this.players = players;
        this.communication = communication;
        this.isStared = false;
        
        this.gameCube = new GameCube();
    }
    public void startGame()
    {
        isStared = true;
        i = 0;
        playerTourNickname = players.get(0).getNickname();
    }
    public boolean getIsStarted()
    {
        return isStared;
    }
    
    public void makeMove(String pawnID, int numberOfMeshes)
    {
        
    }
}
