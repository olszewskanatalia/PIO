/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chineseserverapplication;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;





public class ChineseServerApplication 
{  
    Player players[] = new Player[6];
    
    public static void main(String[] args) throws IOException
    {
        ArrayList<Communication> commList = new ArrayList<>();
        try (ServerSocket serverSocket = new ServerSocket(6667))
        {
            while(true)
            {
                Socket socket = serverSocket.accept();
                Communication communication = new Communication(socket, commList);
                commList.add(communication);
                communication.start();
            }
        }
        catch (Exception e)
        {
            System.out.println("err : "+ e.getStackTrace());
        }
    
    }
}
