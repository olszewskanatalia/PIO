/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chineseclientapplication;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author jakub
 */
public class Communication extends Thread
{
    private Socket socket;
    private BufferedReader input;
    public Communication(Socket s) throws IOException
    {
        this.socket = s;
        this.input = new BufferedReader( new InputStreamReader(socket.getInputStream()));
    }
    public void run()
    {
        try
        {
            while(true)
            {
                String response = input.readLine();
                System.out.println(response);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                input.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
              
        }
    }
}
