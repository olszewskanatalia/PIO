package pawn;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class PawnTest {

    public Pawn tested_pawn;

    @Before
    public void setUp() {
        tested_pawn = new Pawn("red", "example_pawnID", "example_idpola");
    }

    @Test
    public void getColor_correct() {

        //when
        String result = tested_pawn.getPawnColor();

        //then
        String expected = "red";
        assertEquals(expected, result);
    }

    @Test
    public void getPawnID_correct() {
        //when
        String result = tested_pawn.getPawnID();

        //then
        String expected = "example_pawnID";
        assertEquals(expected, result);
    }

    @Test
    public void getIdPola_correct() {
        //when
        String result = tested_pawn.getIdPola();

        //then
        String expected = "example_idpola";
        assertEquals(expected, result);
    }

}
