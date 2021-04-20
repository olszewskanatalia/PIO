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
    public BoardLogic board;
    
    public ServerCommunication(List<Player> players)
    {
        this.players = players;
    }
    public synchronized void makeAsk(Player player, String inMessage, BoardLogic board)
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
            else if (operation.equals("throwDice"))
            {
                board.throwDice(player);
            }
            else if (operation.equals("movePawn"))
            {
                String pawnID = json.getString("PawnID");
                board.makeMovePawn(player, pawnID);
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
    
    public void movePawnInfo(Pawn pawn)
    {
        JSONObject toSend = new JSONObject();
        toSend.put("Operation", "movePawn");
        toSend.put("pawnID", pawn.getPawnID());
        toSend.put("pawnPosition", pawn.getPositionString());
        sendToPlayers(toSend.toString());
    }
    
    public void ThrownDice(int numberOfMeshes)
    {
        JSONObject toSend = new JSONObject();
        toSend.put("Operation", "thrownDice");
        toSend.put("NumberOfMeshes",numberOfMeshes);
        sendToPlayers(toSend.toString());
    }
    
    public void endGame(String winPlayer)
    {
        JSONObject toSend = new JSONObject();
        toSend.put("Operation", "endGame");
        toSend.put("WinPlayer",winPlayer);
        sendToPlayers(toSend.toString());
    }
    
    
    private void playerTourThrowDice(String nickname)
    {
        JSONObject toSend = new JSONObject();
        toSend.put("Operation", "gameStatus");
        toSend.put("Type","waitingForDice");
        toSend.put("nickname", nickname);
        sendToPlayers(toSend.toString());
    }
    
    private void playerTourMovePawn(String nickname)
    {
        JSONObject toSend = new JSONObject();
        toSend.put("Operation", "gameStatus");
        toSend.put("Type","waitingForMove");
        toSend.put("nickname", nickname);
        sendToPlayers(toSend.toString());
    }
    
    public synchronized void playerTourInfo(String nickname, String gameStatus)
    {
        if (gameStatus.equals("WaitingForDice"))
        {
            playerTourThrowDice(nickname);
        }
        else if (gameStatus.equals("WaitingForMove"))
        {
            playerTourMovePawn(nickname);
        }
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
    
    public void addPlayer(Player player)
    {
        JSONObject toSend = new JSONObject();
            toSend.put("Operation", "addPlayer");
            toSend.put("nickname", player.getNickname());
            toSend.put("Color", player.getColor());
            toSend.put("status", player.getIsReady());
            sendToPlayers( toSend.toString());
    }
    
    public void removePlayer(Player player)
    {
        JSONObject toSend = new JSONObject();
        toSend.put("Operation", "removePlayer");
        toSend.put("nickname", player.getNickname());
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