package main.core;

import main.display.Screen;

import javax.swing.*;

public class Runner {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pathfinding Visualization");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Screen instance = new Screen();
        instance.setFocusable(true);
        instance.setLayout(null);
        frame.add(instance);
        frame.pack();
        frame.setVisible(true);
    }

}
