/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chineseserverapplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author jakub
 */
public class Communication extends Thread {
    private Socket socket;
    private ArrayList<Communication> commList;
    private PrintWriter output;
    
    public Communication(Socket socket, ArrayList<Communication> commList)
    {
        this.socket = socket;
        this.commList = commList;
    }

    @Override
    public void run() 
    {
        try
        {
            BufferedReader input = new BufferedReader( new InputStreamReader(socket.getInputStream()) );
            output = new PrintWriter(socket.getOutputStream(), true);
            while (true)
            {
                String outputString = input.readLine();
                if(outputString.equals("exit"))
                {
                    break;
                }
                printToAllClients(outputString);
               System.out.println("Server recived : "+ outputString);
            }
            
        }
        catch(Exception e)
        {
            System.out.println("Error : " + e.getStackTrace());
        }
    }
    private void printToAllClients(String outputString)
    {
        for(Communication cl: commList)
        {
            cl.output.println(outputString);
        }
    }
}
