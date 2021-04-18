/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chineseserverapplication;


public class Pawn 
{
    String pawnID;
    String Color;
    int pawnPosition;
    
    String startPoint;
    PawnsRoute pawnRoute;
    
    public Pawn(String pawnID, String color, String startPoint, PawnsRoute pawnRoute)
    {
       this.pawnID = pawnID;
       this.Color = color;
       this.startPoint = startPoint;
       this.pawnRoute = pawnRoute;
    }
}
