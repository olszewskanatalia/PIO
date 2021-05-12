package src.TEST;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConnectionObject_test_getIpPort {

    @Test
    public void getIpSerwer_whenOk(){
        ludoSystem.ConnectionObject con = new ludoSystem.ConnectionObject();
        con.setConnectionParameters("Kasia","abcd",1234);
        int result = con.getIpPort();
        int expected = 1234;
        assertEquals(expected,result);
    }

}
