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
        switch (color) {
            case "Zielony":
                GreenPathBuilder();
                BlackPathBuilder();
                YellowPathBuilder();
                RedPathBuilder();
                BluePathBuilder();
                PurplePathBuilder();
                GreenEndPathBuilder();
                break;
            case "Czarny":
                BlackPathBuilder();
                YellowPathBuilder();
                RedPathBuilder();
                BluePathBuilder();
                PurplePathBuilder();
                GreenPathBuilder();
                BlackEndPathBuilder();
                break;
            case "Żółty":
                YellowPathBuilder();
                RedPathBuilder();
                BluePathBuilder();
                PurplePathBuilder();
                GreenPathBuilder();
                BlackPathBuilder();
                YellowEndPathBuilder();
                break;
            case "Czerwony":
                RedPathBuilder();
                BluePathBuilder();
                PurplePathBuilder();
                GreenPathBuilder();
                BlackPathBuilder();
                YellowPathBuilder();
                RedEndPathBuilder();
                break;
            case "Niebieski":
                BluePathBuilder();
                PurplePathBuilder();
                GreenPathBuilder();
                BlackPathBuilder();
                YellowPathBuilder();
                RedPathBuilder();
                BlueEndPathBuilder();
                break;
            case "Fioletowy":
                PurplePathBuilder();
                GreenPathBuilder();
                BlackPathBuilder();
                YellowPathBuilder();
                RedPathBuilder();
                BluePathBuilder();
                PurpleEndPathBuilder();
                break;
            default:
                break;
        }
    }
    
    public int getSize()
    {
        return route.length;
    }
    
    public String getRoute()
    {
        String routeString = "";
        for(int j=0; j<getSize(); j++)
        {
            routeString = routeString + " " + route[j];
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
