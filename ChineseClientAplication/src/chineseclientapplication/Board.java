package chineseclientapplication;

import java.util.ArrayList;
import java.util.List;
import pawn.Pawn;

public class Board {

    private final List<Pawn> pawnList;
    private Communication communication;

    public Board(Communication communication) {
        pawnList = new ArrayList<>();
        this.communication = communication;
    }

    public void addPawn(String pawnId, String color, String pawnPosition) {
        pawnList.add(new Pawn(color, pawnId, pawnPosition));
    }

    public List<Pawn> getPawnList() {
        return pawnList;
    }

    public void rollDice() {
        communication.sendRolldDiceAsk();
    }

    public void movePawn(String pawnId) {
        communication.sendMovePawnAsk(pawnId);
    }

    public void refreshWindow() {

    }
}
