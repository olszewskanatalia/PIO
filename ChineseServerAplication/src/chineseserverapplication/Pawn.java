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
    
    public int getPosition()
    {
        return pawnPosition;
    }
    
    public void movePawn(int numberOfMeshes, List<OneColorPawns> Pawns)
    {
        pawnPosition += numberOfMeshes;
    }
    
    public void killPawn()
    {
        pawnPosition = -1;
    }
    
    public boolean isAbleToMove(int numberOfMeshes, List<Pawn> OneColorPawns)
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
