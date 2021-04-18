/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chineseserverapplication;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author jakub
 */
public class OneColorPawns 
{
    String color;
    
    PawnsRoute pawnRoute;
    
    List<Pawn> pawns;
    
    public OneColorPawns(String color)
    {
        
        this.color = color;
        
        this.pawnRoute = new PawnsRoute(color);
        
        System.out.println(pawnRoute.getRoute());
        
        this.pawns = new ArrayList<>();
        
        for (int i = 1; i<5; i++)
        {
            if (color.equals("Zielony"))
            {
                pawns.add(new Pawn("Z" + i, color, "Z" + i, pawnRoute));
            }
            else if (color.equals("Czarny"))
            {
                pawns.add(new Pawn("B" + i, color, "B" + i, pawnRoute));
            }
            else if (color.equals("Żółty"))
            {
                pawns.add(new Pawn("Y" + i, color, "Y" + i, pawnRoute));
            }
            else if (color.equals("Czerwony"))
            {
                pawns.add(new Pawn("R" + i, color, "R" + i, pawnRoute));
            }
            else if (color.equals("Niebieski"))
            {
                pawns.add(new Pawn("N" + i, color, "N" + i, pawnRoute));
            }
            else if (color.equals("Fioletowy"))
            {
                pawns.add(new Pawn("P" + i, color, "P" + i, pawnRoute));
            }
        }
    }
}
