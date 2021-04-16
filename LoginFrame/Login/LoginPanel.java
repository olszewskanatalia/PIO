package Login;


import ludoSystem.ConnectionObject;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.Timer.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.SwingControl.*;

public class LoginPanel extends JFrame {
    private JPanel
            titlePanel = new JPanel(),
            nickPanel = new JPanel(),
            ipSerwerPanel = new JPanel(),
            ipPortPanel = new JPanel();
    private static JTextField
            nickTxt = new JTextField(30),
            ipSerwerTxt = new JTextField(30),
            ipPortTxt = new JTextField(30);
    private String
            nick = "",
            ipSerwer = "",
            ipPort ="";
    public boolean click = false;
    public boolean isHere = true;
    private JButton connect = new JButton("Połącz");
    public ConnectionObject co = new ConnectionObject();

    private ActionListener connectListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e)  {


            click = true;
            setVisible(false);
            if (GoodNick(nick) && GoodIpPort(ipPort) && GoodIpSerwer(ipSerwer)) {

                co.setConnectionParameters(nick, ipSerwer, Integer.parseInt(ipPort));

            } else
                co = null;
            dispose();
        }
    };
    // :  (

    private void makeBoard(){
        setLayout(null);
        setTitle("LUDO GAME");
        setSize(300,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        getContentPane().setBackground(new Color(230, 243, 255));

        titlePanel.add( new JLabel("LUDO - LOGOWANIE", JLabel.CENTER),BorderLayout.CENTER);
        titlePanel.setBounds(0, 0, 300,30);
        titlePanel.setBackground(new Color(179, 230, 255));
        titlePanel.setBorder(new LineBorder(Color.BLACK));
        add(BorderLayout.NORTH, titlePanel);

        nickPanel.add(new JLabel("Nick:",JLabel.CENTER),BorderLayout.CENTER);
        nickPanel.setBounds(50, 70, 80,30);
        nickPanel.setBackground(new Color(179, 230, 255));
        nickPanel.setBorder(new LineBorder(Color.BLACK));
        add( nickPanel);

        nickTxt.setBounds(131,70,95,30);
        nickTxt.setBorder(new LineBorder(Color.BLACK));
        nickTxt.addActionListener(new T1());
        add(nickTxt);

        ipSerwerPanel.add(new JLabel("IP Serwera:",JLabel.CENTER),BorderLayout.CENTER);
        ipSerwerPanel.setBounds(50,120,80,30);
        ipSerwerPanel.setBackground(new Color(179, 230, 255));
        ipSerwerPanel.setBorder(new LineBorder(Color.BLACK));
        add(ipSerwerPanel);

        ipSerwerTxt.setBounds(131,120,95,30);
        ipSerwerTxt.setBorder(new LineBorder(Color.BLACK));
        ipSerwerTxt.addActionListener(new T2());
        add(ipSerwerTxt);

        ipPortPanel.add(new JLabel("IP Portu:",JLabel.CENTER),BorderLayout.CENTER);
        ipPortPanel.setBounds(50,170,80,30);
        ipPortPanel.setBackground(new Color(179, 230, 255));
        ipPortPanel.setBorder(new LineBorder(Color.BLACK));
        add(ipPortPanel);

        ipPortTxt.setBounds(131,170,95,30);
        ipPortTxt.setBorder(new LineBorder(Color.BLACK));
        ipPortTxt.addActionListener(new T3());
        add(ipPortTxt);

        connect.setBounds(50,250, 180, 50);
        connect.addActionListener(connectListener);
        add(connect);
    }

    public LoginPanel() {

        makeBoard();
        //new Timer(10000,connectListener);




    }
    private void showInput() {
        System.out.println(nick + " " + ipSerwer + " " + ipPort);
    }

    private boolean GoodNick(String name) {
        if(name.equals("")) return false;
        else return true;
    }

    private boolean GoodIpSerwer(String ipS) {
        if(ipS.equals("")) return false;
        else return true;
    }

    private boolean GoodIpPort(String ipP) {
        for(int i = 0; i < ipP.length(); i++)
        {
            if(!(ipP.charAt(i) >= '0' && ipP.charAt(i) <= '9'))
                return false;
        }
        return true;
    }


    class T1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(nickTxt.getSelectedText() == null)
                nick = nickTxt.getText();
            else
                nick = nickTxt.getSelectedText();
        }
    }

    class T2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(ipSerwerTxt.getSelectedText() == null)
                ipSerwer = ipSerwerTxt.getText();
            else
                ipSerwer = ipSerwerTxt.getSelectedText();
        }
    }

    class T3 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(ipPortTxt.getSelectedText() == null)
                ipPort = ipPortTxt.getText();
            else
                ipPort = ipPortTxt.getSelectedText();
        }
    }
}
