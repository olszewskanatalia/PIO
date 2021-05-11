
import chineseserverapplication.GameCube;
import org.junit.Assert;
import org.junit.Test;

public class GameCubeTest {

    private GameCube gameCube;

    public GameCubeTest() {
        gameCube = new GameCube();
    }

    @Test
    public void gameCubeTest() {
        for (int i = 0; i < 100; i++) {
            gameCube.generateRandomOfMeshes();
            int x = gameCube.getNumberOfMeshes();
            Assert.assertTrue("Wylosowana liczba jest za duża", x < 7);
            Assert.assertTrue("Wylosowana liczba jest za mała", x > 0);
        }
    }
}
