package Obiekty;

public class ConnectionObject {
    private String nick;
    private String ipSerwer;
    private int ipPort;

    public void setConnectionParameters
            (String inputNick, String inputIpSerwer,int inputIpPort) {
        nick = inputNick;
        ipSerwer = inputIpSerwer;
        ipPort = inputIpPort;
    }
    public String getNick() {
        return nick;
    }
    public String getIpSerwer() {
        return ipSerwer;
    }
    public int getIpPort() {
        return ipPort;
    }
}
