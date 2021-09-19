package main.entities;

import main.util.Globals;
import main.util.Location;
import main.util.ResourceManager;

import java.awt.*;

public class Enemy extends Entity {

    public Enemy (Location location) {
        super("Enemy", location, null);
    }

    public void update() {
        // move based off its algorithm
    }

    //temporary
    @Override
    public void render(Graphics g) {
        //x,y,width,height
        g.setColor(Color.red);
        int radius = (int) (Globals.constant("TILE_SIZE") / 2);
        g.fillOval(getLocation().getX(), getLocation().getY(), radius*2, radius*2);
    }
}
