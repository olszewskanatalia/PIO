package chineseclientapplication;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;
import org.json.JSONException;
import org.json.JSONObject;

public class Communication extends Thread {

    private Socket serverSocket;

    private boolean isConnected;

    private PrintWriter output;

    private final List<Player> playerList;

    public Communication(String serverName, int port, String nickname, List<Player> playerList) throws IOException {
        connectToServer(serverName, port, nickname);
        if (isConnected) {
            System.out.println("Połaczono z serverem");
            this.start();
        }
        this.playerList = playerList;
    }

    public void connectToServer(String serverName, int port, String nickname) throws IOException {
        try {
            serverSocket = new Socket(serverName, port);
            if (serverSocket.isConnected()) {
                output = new PrintWriter(serverSocket.getOutputStream(), true);
                sendToServer(nickname);
                isConnected = true;
            } else {
                isConnected = false;
            }
        } catch (IOException e) {
            isConnected = false;
        }
    }

    private void sendToServer(String message) {
        output.println(message);
    }

    private void decodeJson(String message) {
        try {
            JSONObject json = new JSONObject(message);
            String operation = json.getString("Operation");
            if (operation.equals("addPlayer")) {
                Player p = new Player(json.getString("nickname"), json.getString("Color"), json.getBoolean("status"), playerList);
            } else if (operation.equals("changePlayerStatus")) {
                for (Player p : playerList) {
                    if (json.getString("nickname").equals(p.getNickname())) {
                        p.changePlayerStatus(json.getBoolean("status"));
                        break;
                    }
                }
            } else if (operation.equals("removePlayer")) {
                for (Player p : playerList) {
                    if (json.getString("nickname").equals(p.getNickname())) {
                        p.removePlayer();
                        break;
                    }
                }
            } else if (operation.equals("startGame")) {

            } else if (operation.equals("initPawn")) {

            } else if (operation.equals("movePawn")) {

            } else if (operation.equals("thrownDice")) {

            } else if (operation.equals("gameStatus")) {

            } else if (operation.equals("endGame")) {

            }
        } catch (JSONException e) {

        }
    }

    public void sendRolldDiceAsk() {
        JSONObject toSend = new JSONObject();
        toSend.put("Operation", "movePawn");
        sendToServer(toSend.toString());
    }

    public void sendMovePawnAsk(String pawnId) {
        JSONObject toSend = new JSONObject();
        toSend.put("Operation", "movePawn");
        toSend.put("PawnID", pawnId);
        sendToServer(toSend.toString());
    }

    private void reciveMessageFromServer() throws IOException {
        try {
            Scanner input = new Scanner(new InputStreamReader(serverSocket.getInputStream()));
            String inputString = input.next();
            System.out.println(inputString);
            decodeJson(inputString);
        } catch (IOException e) {
            isConnected = false;
        }
    }

    @Override
    public void run() {
        while (isConnected) {
            try {
                reciveMessageFromServer();
            } catch (IOException ex) {
                isConnected = false;
            }
        }
        System.out.println("Utracono połączenie");
    }
}
