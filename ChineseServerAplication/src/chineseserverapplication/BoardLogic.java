
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
        communication.sendStartGameInfo(this);
        gameStatus = "WaitingForDice";
        communication.playerTourInfo(getPlayerTourNickname(), getStatus());
    }
    
    public synchronized void removePlayer()
    {
        if (isStared)
        {
            nextPlayerTour();
        }
    }
    
    private synchronized void nextPlayerTour()
    {
        i += 1;
        playerTourNickname = players.get(i%players.size()).getNickname();
        gameStatus = "WaitingForDice";
        communication.playerTourInfo(getPlayerTourNickname(), getStatus());
    }
    
    private synchronized void changeStatusToMove()
    {
        gameStatus = "WaitingForMove";
        communication.playerTourInfo(getPlayerTourNickname(), getStatus());
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
    private synchronized String getPlayerTourNickname()
    {
        return playerTourNickname;
    }
    
    public synchronized void throwDice(Player player)
    {
        if (getPlayerTourNickname().equals(player.getNickname()))
        {
            if (this.getStatus().equals("WaitingForDice"))
            {
                gameCube.generateRandomOfMeshes();
                communication.ThrownDice(gameCube.getNumberOfMeshes());
                for (OneColorPawns ocp : colorPawns)
                {
                    if (player.getColor().equals(ocp.getColor()))
                    {
                        for (Pawn p : ocp.getPawnsList())
                        {
                            if (p.isAbleToMove(gameCube.getNumberOfMeshes(), ocp.getPawnsList()))
                            {
                                changeStatusToMove();
                                return;
                            }
                        }
                        
                    }
                }
                System.out.println("ty?");
                nextPlayerTour();
                return;
            }
        }
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
                        communication.movePawnInfo(p);
                    }
                }
            }
    }
    
    public synchronized void makeMovePawn(Player player, String pawnID)
    {
        if (getPlayerTourNickname().equals(player.getNickname()))
        {
            if (this.getStatus().equals("WaitingForMove"))
            {
                int numberOfMeshes = gameCube.getNumberOfMeshes();
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
                                    
                                    communication.movePawnInfo(p);
                                    
                                    ifGameIsWin();
                                    
                                    nextPlayerTour();
                                    
                                    return;
                                }
                                else
                                {
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    
    public synchronized void ifGameIsWin()
    {
        for (OneColorPawns ocp : colorPawns)
        {
            int howManyInHome = 0;
            for (Pawn p : ocp.getPawnsList())
            {
                if (p.getPosition() > 59)
                {
                    howManyInHome++;
                }
            }
            if (howManyInHome == 4)
            {
                for (Player player : players)
                {
                    if (player.getColor().equals(ocp.getColor()))
                    {
                        communication.endGame(player.getNickname());
                        System.out.println("Koniec gry. Wygrał : " + player.getNickname());
                        System.exit(0);
                    }
                }
            }
        }
    }
}
