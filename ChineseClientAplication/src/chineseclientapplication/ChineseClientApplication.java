/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chineseclientapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author jakub
 */
public class ChineseClientApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
       try (Socket socket = new Socket("localhost", 5000))
       {
           BufferedReader input = new BufferedReader( new InputStreamReader(socket.getInputStream()));
           PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
           Scanner scanner = new Scanner(System.in);
           String userInput;
           String response;
           String clientName = "empty";
           Communication communication = new Communication(socket);
           communication.start();
           do
           {
               if (clientName.equals("empty"))
               {
                   System.out.println("Enter your name");
                   userInput = scanner.nextLine();
                   clientName = userInput;
                   output.println(userInput);
                   if (userInput.equals("exit"))
                   {
                       break;
                   }
               }
               else
               {
                   String message = ("("+ clientName+") : ");
                   System.out.println("message : ");
                   userInput = scanner.nextLine();
                   output.println(message + userInput);
                   if(userInput.equals("exit"))
                   {
                       break;
                   }
               }
           }
           while (!userInput.equals("exit"));
       }
       catch (Exception e)
       {
           System.out.println("Exception : " + e.getStackTrace());
       }
    }
    
}
