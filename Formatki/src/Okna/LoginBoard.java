package Okna;

import Obiekty.ConnectionObject;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static net.mindview.util.SwingControl.*;

public class LoginBoard extends JFrame {
    private JPanel
            titlePanel = new JPanel(),
            nickPanel = new JPanel(),
            ipSerwerPanel = new JPanel(),
            ipPortPanel = new JPanel();
    private static JTextField
            nickTxt = new JTextField(),
            ipSerwerTxt = new JTextField(),
            ipPortTxt = new JTextField();
    private JButton connect = new JButton("Połącz");
    private static ConnectionObject co = new ConnectionObject();

    public static void getCo(ConnectionObject pp) {
        pp.setConnectionParameters(nickTxt.getText(), ipSerwerTxt.getText(), Integer.parseInt(ipPortTxt.getText()));
    }

    private ActionListener connectListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e)  {


            if(nickTxt.getText() != "" && ipSerwerTxt.getText() != "" && Integer.parseInt(ipPortTxt.getText()) > 0)
                co.setConnectionParameters(nickTxt.getText(), ipSerwerTxt.getText(), Integer.parseInt(ipPortTxt.getText()));
            setVisible(false);
            dispose();
        }
    };

    public LoginBoard() {

        setLayout(null);
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
        add(nickTxt);

        ipSerwerPanel.add(new JLabel("IP Serwera:",JLabel.CENTER),BorderLayout.CENTER);
        ipSerwerPanel.setBounds(50,120,80,30);
        ipSerwerPanel.setBackground(new Color(179, 230, 255));
        ipSerwerPanel.setBorder(new LineBorder(Color.BLACK));
        add(ipSerwerPanel);

        ipSerwerTxt.setBounds(131,120,95,30);
        ipSerwerTxt.setBorder(new LineBorder(Color.BLACK));
        add(ipSerwerTxt);

        ipPortPanel.add(new JLabel("IP Portu:",JLabel.CENTER),BorderLayout.CENTER);
        ipPortPanel.setBounds(50,170,80,30);
        ipPortPanel.setBackground(new Color(179, 230, 255));
        ipPortPanel.setBorder(new LineBorder(Color.BLACK));
        add(ipPortPanel);

        ipPortTxt.setBounds(131,170,95,30);
        ipPortTxt.setBorder(new LineBorder(Color.BLACK));
        add(ipPortTxt);

        connect.setBounds(50,250, 180, 50);
        connect.addActionListener(connectListener);
        add(connect);

    }


}
