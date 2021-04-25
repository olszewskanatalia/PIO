
public class Pawn {

    private String color;
    private String pawnID;
    private int pawnPosition;

    public Pawn(String color, String pawnID, int pawnPosition){
        this.color = color;
        this.pawnID = pawnID;
        this.pawnPosition = pawnPosition;
    }

    public String getPawnID(){
        return pawnID;
    }

    public int getPosition(){
        return pawnPosition;
    }

    public String getPawnColor(){
        return color;
    }

    public void killPawn(){
        pawnPosition = -1;
    }


}
