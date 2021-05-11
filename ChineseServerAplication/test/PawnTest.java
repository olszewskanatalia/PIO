
import chineseserverapplication.OneColorPawns;
import chineseserverapplication.Pawn;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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

        Assert.assertEquals(-1, pawn.getPosition());

        if (pawn.isAbleToMove(3, ocp.getPawnsList())) {
            pawn.movePawn(3);
            Assert.assertEquals(-1, pawn.getPosition());

        }
        if (pawn.isAbleToMove(3, ocp.getPawnsList())) {
            pawn.movePawn(3);
            Assert.assertEquals(0, pawn.getPosition());

        }
        if (pawn.isAbleToMove(6, ocp.getPawnsList())) {
            pawn.movePawn(6);
            Assert.assertEquals(6, pawn.getPosition());
        }
        if (pawn.isAbleToMove(240, ocp.getPawnsList())) {
            pawn.movePawn(240);
            Assert.assertEquals(246, pawn.getPosition());
        }
        if (pawn.isAbleToMove(5, ocp.getPawnsList())) {
            pawn.movePawn(5);
            Assert.assertEquals(11, pawn.getPosition());
        }
        pawn.killPawn();
        Assert.assertEquals(-1, pawn.getPosition());

        if (pawn.isAbleToMove(6, ocp.getPawnsList())) {
            pawn.movePawn(6);
            Assert.assertEquals(0, pawn.getPosition());
        }

        if (pawn.isAbleToMove(64, ocp.getPawnsList())) {
            pawn.movePawn(64);
            Assert.assertEquals(64, pawn.getPosition());
        }
        if (pawn.isAbleToMove(1, ocp.getPawnsList())) {
            pawn.movePawn(1);
            Assert.assertEquals(65, pawn.getPosition());
        }

        Assert.assertEquals("ZD4", pawn.getPosition());

        pawn.killPawn();
        Assert.assertEquals(-1, pawn.getPosition());
    }
}
