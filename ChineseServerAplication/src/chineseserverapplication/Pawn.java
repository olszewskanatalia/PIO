/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chineseserverapplication;

import java.util.List;


public class Pawn 
{
    private final String pawnID;
    private final String Color;
    private int pawnPosition;
    
    private final String startPoint;
    private final PawnsRoute pawnRoute;
    
    public Pawn(String pawnID, String color, String startPoint, PawnsRoute pawnRoute)
    {
       this.pawnID = pawnID;
       this.Color = color;
       this.startPoint = startPoint;
       this.pawnRoute = pawnRoute;
       this.pawnPosition = -1;
    }
    
    public synchronized String getPawnID()
    {
        return pawnID;
    }
    
    public synchronized int getPosition()
    {
        return pawnPosition;
    }
    
    public synchronized String getPositionString()
    {
        int i = getPosition();
        if (i == -1)
        {
            return startPoint;
        }
        else
        {
            return pawnRoute.getRoute()[i];
        }
    }
    
    public synchronized String getNewPositionString(int numberOfMeshes)
    {
        int i = getPosition();
        if (i == -1)
        {
            if (numberOfMeshes == 6)
            {
                return pawnRoute.getRoute()[0];
            }
        }
        else
        {
            return pawnRoute.getRoute()[i+numberOfMeshes];
        }
        return startPoint;
    }
    
    public synchronized void movePawn(int numberOfMeshes)
    {
        pawnPosition += numberOfMeshes;
    }
    
    public synchronized void killPawn()
    {
        pawnPosition = -1;
    }
    
    public synchronized boolean isAbleToMove(int numberOfMeshes, List<Pawn> OneColorPawns)
    {
        if (pawnPosition == -1)
        {
            if (numberOfMeshes == 6)
            {
                for (Pawn p : OneColorPawns)
                {
                    if (p.getPosition() == 0)
                    {
                        return false;
                    }
                }
                return true;
            }
        }
        else if (pawnPosition + numberOfMeshes < pawnRoute.getSize())
        {
            for (Pawn p : OneColorPawns)
                {
                    if (p.getPosition() == pawnPosition + numberOfMeshes)
                    {
                        return false;
                    }
                }
            return true;
        }
        return false;
    }
}
