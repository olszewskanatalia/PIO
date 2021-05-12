package src.TEST;

import ludoSystem.ConnectionObject;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ConnectionObject_test_getNick {

    @Test
    public void getNick_whenOnlyWhitespace(){
        ludoSystem.ConnectionObject con = new ConnectionObject();
        con.setConnectionParameters("  ","abcd",1234);
        String result = con.getNick();
        String expected = "  ";
        assertEquals(expected,result);
    }

    @Test
    public void getNick_whenOk(){
        ludoSystem.ConnectionObject con = new ConnectionObject();
        con.setConnectionParameters("Kasia","abcd",1234);
        String result = con.getNick();
        String expected = "Kasia";
        assertEquals(expected,result);
    }


}
