/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chineseserverapplication;

import java.util.Random;

/**
 *
 * @author jakub
 */
public class GameCube 
{
    private Random rand;
    private int numberOfMeshes;
    public GameCube()
    {
        this.rand = new Random();
    }
    public GameCube(int seed)
    {
        this.rand = new Random(seed);
    }
    public void generateRandomOfMeshes()
    {
        numberOfMeshes = rand.nextInt(6) + 1;
    }
    public int getNumberOfMeshes()
    {
        return numberOfMeshes;
    }
}
