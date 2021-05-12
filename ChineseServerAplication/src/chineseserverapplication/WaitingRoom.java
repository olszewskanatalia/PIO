package chineseserverapplication;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class WaitingRoom extends Thread {

    public List<Player> players;
    ServerCommunication communication;
    BoardLogic board;
    Colors colors;

    public WaitingRoom(List<Player> players, ServerCommunication communication, BoardLogic board, Colors colors) {
        this.players = players;
        this.communication = communication;
        this.board = board;
        this.colors = colors;
    }

    @Override
    public void run() {
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(6000);
            System.out.println("Server ip : " + serverSocket.getLocalPort());
            try {
                while (!board.getIsStarted()) {
                    Socket socket = serverSocket.accept();
                    if (players.size() < 6 && !board.getIsStarted()) {
                        addNewPlayer(socket, board, colors);
                    } else {
                        socket.close();
                    }
                }
            } catch (IOException e) {
                System.out.println("err : " + e.getStackTrace());
            } finally {
                serverSocket.close();
            }
        } catch (IOException ex) {
            System.out.println("Nie udało sę utworzyć servera");
            System.exit(100);
        }

    }

    public void addNewPlayer(Socket socket, BoardLogic board, Colors colors) {
        Thread t = new Thread(() -> {
            System.out.println("tutaj jestem jeszcze");
            try {
                Player newPlayer = new Player(socket, players, communication, board, colors);

            } catch (IOException ex) {
                System.out.println("Nie udało się połączyć użytkownika.");
            }
        });
        t.start();
    }

    public static synchronized boolean isPlayersReady(List<Player> players) {
        if (players.isEmpty()) {
            return false;
        }
        for (Player p : players) {
            if (!p.getIsReady()) {
                return false;
            }
        }
        return true;
    }

    public static void waitingRoom(List<Player> players, ServerCommunication communication, BoardLogic board, Colors colors) {
        WaitingRoom waitingRoom = new WaitingRoom(players, communication, board, colors);
        waitingRoom.start();
        while (!isPlayersReady(players)) {

        }
        System.out.println("Rozpoczęto grę");

    }
}
