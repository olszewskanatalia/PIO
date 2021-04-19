/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chineseserverapplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;





public class ChineseServerApplication 
{  
    
    
    public static void main(String[] args) throws IOException
    {
        Colors colors = new Colors();
        List<Player> players = new ArrayList<>();
        ServerCommunication communication = new ServerCommunication(players);
        BoardLogic board = new BoardLogic(players, communication);
        
        WaitingRoom.waitingRoom(players, communication, board, colors);
        
        board.startGame();
        
    }
}
