package main.entities;

import main.util.Location;
import main.util.ResourceManager;

import java.awt.*;

public class Enemy extends Entity {
    private static final int radius = 16;

    public Enemy (Location location) {
        super("Enemy", location, null);
    }

    public void update(){}

    @Override
    public void render(Graphics g) {
        //x,y,width,height
        g.fillOval(getLocation().getX(), getLocation().getY(), radius, radius);
    }
}
