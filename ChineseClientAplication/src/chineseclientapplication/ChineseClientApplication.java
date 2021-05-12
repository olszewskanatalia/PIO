package chineseclientapplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChineseClientApplication {

    public static void main(String[] args) throws IOException {

        List<Player> playerList = new ArrayList<>();

        Communication comm = new Communication("localhost", 6000, "nickname", playerList);
    }

}
