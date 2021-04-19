/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chineseserverapplication;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jakub
 */
public class Colors 
{
    List<Color> colors;
    public Colors()
    {
        this.colors = new ArrayList<>();
        this.colors.add(new Color("Zielony"));
        this.colors.add(new Color("Czarny"));
        this.colors.add(new Color("Żółty"));
        this.colors.add(new Color("Czerwony"));
        this.colors.add(new Color("Niebieski"));
        this.colors.add(new Color("Fioletowy"));
    }
    public String getFreeColor()
    {
        System.out.println("tu też ");
        for (Color c : colors)
        {
            if (c.getFreeStatus() == false)
            {
                return c.getColor();
            }
        }
        return "";
    }
    public void freeColor(String colorName)
    {
        for (Color c : colors)
        {
            if (colorName.equals(c.getColorName()))
            {
                c.freeColor();
            }
        }
    }
}

    


class Color
{
    private String color;
    private boolean free;
    Color(String color)
    {
        this.color = color;
        this.free = false;
    }
    public synchronized boolean getFreeStatus()
    {
        return free;
    }
    public synchronized String getColor()
    {
        free = true;
        return color;
    }
    public synchronized String getColorName()
    {
        return color;
    }
    public synchronized void freeColor()
    { 
        free = false;
    }
}