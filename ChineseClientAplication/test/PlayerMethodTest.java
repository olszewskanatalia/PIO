
import chineseclientapplication.Player;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerMethodTest {

    private Player player;
    private List<Player> playerList;

    public PlayerMethodTest() {
    }

    @Before
    public void setUp() {
        playerList = new ArrayList<>();
        player = new Player("Player", "Zielony", false, playerList);
    }

    @Test
    public void testPlayer() {
        assertEquals(player.getNickname(), "Player");
        assertEquals(player.getColor(), "Zielony");
        assertEquals(player.getPlayerStatus(), false);
        player.changePlayerStatus(true);
        assertEquals(player.getPlayerStatus(), true);
        player.removePlayer();
        assertEquals(playerList.size(), 0);
    }
}
