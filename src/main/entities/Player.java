package main.entities;

import main.display.Input;
import main.util.Location;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends Entity {
    private static final int radius = 16;

    public Player (Location location) {
        super("Player", location, null);
    }

    public void update(){}

    @Override
    public void render(Graphics g) {
        //x,y,width,height
        g.fillOval(getLocation().getX(), getLocation().getY(), radius*2, radius*2);
    }
}
