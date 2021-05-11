package chineseserverapplication;
    
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;





public class ChineseServerApplication 
{  
    
    
    public static void main(String[] args) 
    {
        Colors colors = new Colors();
        List<Player> players = new ArrayList<>();
        ServerCommunication communication = new ServerCommunication(players);
        BoardLogic board = new BoardLogic(players, communication);
        
        WaitingRoom.waitingRoom(players, communication, board, colors);
        
        board.startGame();
        
    }
}
