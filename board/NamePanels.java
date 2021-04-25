package board;

import Player.Player;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class NamePanels {

    private NamePanel red, yellow, blue, black, green, purple;
    private JPanel redPanel, yellowPanel, bluePanel, blackPanel, greenPanel, purplePanel;


    public NamePanels(List<Player> lp, JFrame fram) {

        for (Player player : lp) {
            switch (player.getColor()) {
                case "RED" -> {
                    red = new NamePanel(player.getNickname(), 750, 170);
                    redPanel = new JPanel();
                    redPanel.setBounds(750, 220, 200, 60);
                    redPanel.setBackground(new Color(184, 41, 41));
                    fram.add(red);
                    fram.add(redPanel);
                }
                case "BLUE" -> {
                    blue = new NamePanel(player.getNickname(), 1000, 170);
                    bluePanel = new JPanel();
                    bluePanel.setBounds(1000, 220, 200, 60);
                    bluePanel.setBackground(new Color(45, 63, 164));
                    fram.add(blue);
                    fram.add(bluePanel);
                }
                case "YELLOW" -> {
                    yellow = new NamePanel(player.getNickname(), 750, 370);
                    yellowPanel = new JPanel();
                    yellowPanel.setBounds(750, 420, 200, 60);
                    yellowPanel.setBackground(new Color(224, 199, 15));
                    fram.add(yellow);
                    fram.add(yellowPanel);
                }
                case "BLACK" -> {
                    black = new NamePanel(player.getNickname(), 1000, 370);
                    blackPanel = new JPanel();
                    blackPanel.setBounds(1000, 420, 200, 60);
                    blackPanel.setBackground(new Color(0,0,0));
                    fram.add(black);
                    fram.add(blackPanel);
                }
                case "GREEN" -> {
                    green = new NamePanel(player.getNickname(), 750, 570);
                    greenPanel = new JPanel();
                    greenPanel.setBounds(750, 620, 200, 60);
                    greenPanel.setBackground(new Color(18, 125, 18));
                    fram.add(green);
                    fram.add(greenPanel);
                }
                case "PURPLE" -> {
                    purple = new NamePanel(player.getNickname(), 1000, 570);
                    purplePanel = new JPanel();
                    purplePanel.setBounds(1000, 620, 200, 60);
                    purplePanel.setBackground(new Color(130, 36, 171));
                    fram.add(purple);
                    fram.add(purplePanel);
                }
            }


        }

    }


}
