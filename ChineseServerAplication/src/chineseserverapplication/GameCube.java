package chineseserverapplication;

import java.util.Random;

public class GameCube {

    private Random rand;
    private int numberOfMeshes;

    public GameCube() {
        this.rand = new Random();
    }

    public GameCube(int seed) {
        this.rand = new Random(seed);
    }

    public void generateRandomOfMeshes() {
        numberOfMeshes = rand.nextInt(6) + 1;
    }

    public int getNumberOfMeshes() {
        return numberOfMeshes;
    }
}
