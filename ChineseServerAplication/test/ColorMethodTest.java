
import chineseserverapplication.Colors;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ColorMethodTest {

    private Colors colors;

    private List<String> colorsName;

    public ColorMethodTest() {
    }

    @Before
    public void setUp() {
        colors = new Colors();
        colorsName = new ArrayList<>();
        colorsName.add("Zielony");
        colorsName.add("Czarny");
        colorsName.add("Żółty");
        colorsName.add("Czerwony");
        colorsName.add("Niebieski");
        colorsName.add("Fioletowy");
    }

    @Test
    public void colorMethodTest() {
        String color1 = colors.getFreeColor();
        System.out.println(colorsName.indexOf(color1));
        assertTrue("Kolor nie istnieje", colorsName.indexOf(color1) >= 0);

        String color2 = colors.getFreeColor();
        System.out.println(colorsName.indexOf(color2));
        assertTrue("Kolor nie istnieje", colorsName.indexOf(color2) >= 0);

        String color3 = colors.getFreeColor();
        System.out.println(colorsName.indexOf(color3));
        assertTrue("Kolor nie istnieje", colorsName.indexOf(color3) >= 0);

        String color4 = colors.getFreeColor();
        System.out.println(colorsName.indexOf(color4));
        assertTrue("Kolor nie istnieje", colorsName.indexOf(color4) >= 0);

        String color5 = colors.getFreeColor();
        System.out.println(colorsName.indexOf(color5));
        assertTrue("Kolor nie istnieje", colorsName.indexOf(color5) >= 0);

        String color6 = colors.getFreeColor();
        System.out.println(colorsName.indexOf(color6));
        assertTrue("Kolor nie istnieje", colorsName.indexOf(color6) >= 0);

        String color7 = colors.getFreeColor();
        System.out.println(colorsName.indexOf(color7));
        assertEquals(color7, null);

        colors.freeColor(color2);
        String color2OnceAgain = colors.getFreeColor();
        System.out.println(colorsName.indexOf(color2OnceAgain));
        assertEquals(color2OnceAgain, color2);

        String color8 = colors.getFreeColor();
        System.out.println(colorsName.indexOf(color8));
        assertEquals(color8, null);
    }
}
