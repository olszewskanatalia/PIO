package pawn;

public class Pawn {

    private String color;
    private String pawnID;
    public String idpola;

    public Pawn(String color, String pawnID, String idpola) {
        this.color = color;
        this.pawnID = pawnID;
        this.idpola = idpola;
    }

    public String getPawnID(){
        return pawnID;
    }
    
    public String getPawnColor(){
        return color;
    }
    
    public String getIdPola(){
        return idpola;
    }
}
