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
        gameStatus = "WaitingForDice";
    }
    
    public synchronized void removePlayer()
    {
        if (isStared)
        {
            nextPlayerTour();
        }
    }
    
    private void nextPlayerTour()
    {
        i += 1;
        playerTourNickname = players.get(i%players.size()).getNickname();
        gameStatus = "WaitingForDice";
        //send
    }
    
    private void changeStatusToMove()
    {
        gameStatus = "WaitingForMove";
    }
    
    public synchronized List <OneColorPawns> getPawnsList()
    {
       return colorPawns;
    }
    
    public synchronized boolean getIsStarted()
    {
        return isStared;
    }
    
    private synchronized String getStatus()
    {
        return gameStatus;
    }
    
    public synchronized void throwDice(Player player)
    {
        if (playerTourNickname.equals(player.getNickname()))
        {
            if (this.getStatus().equals("WaitingForDice"))
            {
                gameCube.generateRandomOfMeshes();
                for (OneColorPawns ocp : colorPawns)
                {
                    if (player.getColor().equals(ocp.getColor()))
                    {
                        for (Pawn p : ocp.getPawnsList())
                        {
                            if (p.isAbleToMove(gameCube.getNumberOfMeshes(), ocp.getPawnsList()))
                            {
                                changeStatusToMove();
                                //send
                            }
                        }
                        nextPlayerTour();
                    }
                }
            }
        }
        nextPlayerTour();
    }
    
    private synchronized void killPawns(String newPosition)
    {
        for (OneColorPawns ocp : colorPawns)
            {
                for (Pawn p : ocp.getPawnsList())
                {
                    if (p.getPositionString().equals(newPosition))
                    {
                        p.killPawn();
                        //send
                    }
                }
            }
    }
    
    public synchronized void makeMovePawn(Player player, String pawnID, int numberOfMeshes)
    {
        if (playerTourNickname.equals(player.getNickname()))
        {
            if (this.getStatus().equals("WaitingForMove"))
            {
                for (OneColorPawns ocp : colorPawns)
                {
                    if (player.getColor().equals(ocp.getColor()))
                    {
                        for (Pawn p : ocp.getPawnsList())
                        {
                            if (p.getPawnID().equals(pawnID))
                            {
                                if (p.isAbleToMove(gameCube.getNumberOfMeshes(), ocp.getPawnsList()))
                                {
                                    killPawns(p.getNewPositionString(numberOfMeshes));
                                    p.movePawn(numberOfMeshes);
                                    //send
                                    nextPlayerTour();
                                }
                            }
                            else
                            {
                                //send
                                return;
                            }
                        }
                    }
                }
                //send
            }
        }
    }
}
