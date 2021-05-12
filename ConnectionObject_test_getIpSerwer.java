package src.TEST;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConnectionObject_test_getIpSerwer {
    @Test
    public void getIpSerwer_whenOnlyWhitespace(){
        ludoSystem.ConnectionObject con = new ludoSystem.ConnectionObject();
        con.setConnectionParameters("  ","  ",1234);
        String result = con.getIpSerwer();
        String expected = "  ";
        assertEquals(expected,result);
    }

    @Test
    public void getIpSerwer_whenOk(){
        ludoSystem.ConnectionObject con = new ludoSystem.ConnectionObject();
        con.setConnectionParameters("Kasia","abcd",1234);
        String result = con.getIpSerwer();
        String expected = "abcd";
        assertEquals(expected,result);
    }
}
