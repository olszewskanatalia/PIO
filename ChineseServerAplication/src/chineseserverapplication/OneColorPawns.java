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
    private String color;
    
    private PawnsRoute pawnRoute;
    
    private List<Pawn> pawns;
    
    
    
            
    
    public OneColorPawns(String color)
    {
        
        this.color = color;
        
        this.pawnRoute = new PawnsRoute(color);
        
        System.out.println(pawnRoute.getRouteString());
        
        this.pawns = new ArrayList<>();
        
        for (int i = 1; i<5; i++)
        {
            switch (color) {
                case "Zielony":
                    pawns.add(new Pawn("Z" + i, color, "Z" + i, pawnRoute));
                    break;
                case "Czarny":
                    pawns.add(new Pawn("B" + i, color, "B" + i, pawnRoute));
                    break;
                case "Żółty":
                    pawns.add(new Pawn("Y" + i, color, "Y" + i, pawnRoute));
                    break;
                case "Czerwony":
                    pawns.add(new Pawn("R" + i, color, "R" + i, pawnRoute));
                    break;
                case "Niebieski":
                    pawns.add(new Pawn("N" + i, color, "N" + i, pawnRoute));
                    break;
                case "Fioletowy":
                    pawns.add(new Pawn("P" + i, color, "P" + i, pawnRoute));
                    break;
                default:
                    break;
            }
        }
    }
    
    
    public synchronized List<Pawn> getPawnsList()
    {
        return pawns;
    }
    public synchronized String getColor()
    {
        return color;
    }
}
