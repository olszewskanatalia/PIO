
import chineseserverapplication.OneColorPawns;
import chineseserverapplication.Pawn;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class PawnTest {

    private OneColorPawns ocp;

    public PawnTest() {
    }

    @Before
    public void setUp() {
        ocp = new OneColorPawns("Zielony");
    }

    @Test
    public void pawnTest() {
        Pawn pawn = ocp.getPawnsList().get(0);

        assertEquals(-1, pawn.getPosition());

        if (pawn.isAbleToMove(3, ocp.getPawnsList())) {
            pawn.movePawn(3);
        }
        assertEquals(-1, pawn.getPosition());

        if (pawn.isAbleToMove(3, ocp.getPawnsList())) {
            pawn.movePawn(3);
        }
        assertEquals(-1, pawn.getPosition());

        if (pawn.isAbleToMove(6, ocp.getPawnsList())) {
            pawn.movePawn(6);
        }
        assertEquals(0, pawn.getPosition());

        if (pawn.isAbleToMove(240, ocp.getPawnsList())) {
            pawn.movePawn(240);
        }
        assertEquals(0, pawn.getPosition());

        if (pawn.isAbleToMove(5, ocp.getPawnsList())) {
            pawn.movePawn(5);
        }
        assertEquals(5, pawn.getPosition());

        pawn.killPawn();
        assertEquals(-1, pawn.getPosition());

        if (pawn.isAbleToMove(6, ocp.getPawnsList())) {
            pawn.movePawn(6);
        }
        assertEquals(0, pawn.getPosition());

        if (pawn.isAbleToMove(63, ocp.getPawnsList())) {
            pawn.movePawn(63);
        }
        assertEquals(63, pawn.getPosition());

        if (pawn.isAbleToMove(1, ocp.getPawnsList())) {
            pawn.movePawn(1);

        }
        assertEquals(63, pawn.getPosition());

        assertEquals("DZ4", pawn.getPositionString());

        Pawn pawn2 = ocp.getPawnsList().get(1);

        assertEquals(-1, pawn2.getPosition());

        pawn2.movePawn(6);

        assertEquals(0, pawn2.getPosition());

        if (pawn.isAbleToMove(63, ocp.getPawnsList())) {
            pawn.movePawn(63);
        }
        assertEquals(63, pawn.getPosition());

        assertEquals(0, pawn2.getPosition());

    }
}
