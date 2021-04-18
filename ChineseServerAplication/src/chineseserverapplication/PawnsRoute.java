/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chineseserverapplication;

/**
 *
 * @author jakub
 */
public class PawnsRoute 
{
    private String route[];
    private int i;
    public PawnsRoute(String color)
    {
        route = new String[64];
        i=0;
        if (color.equals("Zielony"))
        {
            GreenPathBuilder();
            BlackPathBuilder();
            YellowPathBuilder();
            RedPathBuilder();
            BluePathBuilder();
            PurplePathBuilder();
            
            GreenEndPathBuilder();
        }
        else if (color.equals("Czarny"))
        {
            BlackPathBuilder();
            YellowPathBuilder();
            RedPathBuilder();
            BluePathBuilder();
            PurplePathBuilder();
            GreenPathBuilder();
            
            BlackEndPathBuilder();
        }
        else if (color.equals("Żółty"))
        {
            YellowPathBuilder();
            RedPathBuilder();
            BluePathBuilder();
            PurplePathBuilder();
            GreenPathBuilder();
            BlackPathBuilder();
            
            YellowEndPathBuilder();
        }
        else if (color.equals("Czerwony"))
        {
            RedPathBuilder();
            BluePathBuilder();
            PurplePathBuilder();
            GreenPathBuilder();
            BlackPathBuilder();
            YellowPathBuilder();
            
            RedEndPathBuilder();
        }
        else if (color.equals("Niebieski"))
        {
            BluePathBuilder();
            PurplePathBuilder();
            GreenPathBuilder();
            BlackPathBuilder();
            YellowPathBuilder();
            RedPathBuilder();
            
            BlueEndPathBuilder();
        }
        else if (color.equals("Fioletowy"))
        {
            PurplePathBuilder();
            GreenPathBuilder();
            BlackPathBuilder();
            YellowPathBuilder();
            RedPathBuilder();
            BluePathBuilder();
            
            PurpleEndPathBuilder();
        }
    }
    
    public int getSize()
    {
        return route.length;
    }
    
    public String getRoute()
    {
        String routeString = "";
        for(int i=0; i<getSize(); i++)
        {
            routeString = routeString + " " + route[i];
        }
        return routeString;
    }
    
    
    private void GreenPathBuilder()
    {
        for (int j=1; j<11; j++)
        {
            route[i] = "PZ" + j;
            i++;
        }
    }
    private void BlackPathBuilder()
    {
        for (int j=1; j<11; j++)
        {
            route[i] = "PB" + j;
            i++;
        }
    }
    private void YellowPathBuilder()
    {
        for (int j=1; j<11; j++)
        {
            route[i] = "PY" + j;
            i++;
        }
    }
    private void RedPathBuilder()
    {
        for (int j=1; j<11; j++)
        {
            route[i] = "PR" + j;
            i++;
        }
    }
    private void BluePathBuilder()
    {
        for (int j=1; j<11; j++)
        {
            route[i] = "PN" + j;
            i++;
        }
    }
    private void PurplePathBuilder()
    {
        for (int j=1; j<11; j++)
        {
            route[i] = "PP" + j;
            i++;
        }
    }
    private void GreenEndPathBuilder()
    {
        for (int j=1; j<5; j++)
        {
            route[i] = "DZ" + j;
            i++;
        }
    }
    private void BlackEndPathBuilder()
    {
        for (int j=1; j<5; j++)
        {
            route[i] = "DB" + j;
            i++;
        }
    }
    private void YellowEndPathBuilder()
    {
        for (int j=1; j<5; j++)
        {
            route[i] = "DY" + j;
            i++;
        }
    }
    private void RedEndPathBuilder()
    {
        for (int j=1; j<5; j++)
        {
            route[i] = "DR" + j;
            i++;
        }
    }
    private void BlueEndPathBuilder()
    {
        for (int j=1; j<5; j++)
        {
            route[i] = "DN" + j;
            i++;
        }
    }
    private void PurpleEndPathBuilder()
    {
        for (int j=1; j<5; j++)
        {
            route[i] = "DP" + j;
            i++;
        }
    }
    
    
}
