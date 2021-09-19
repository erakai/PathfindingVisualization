package main.entities;

import main.display.TileManager;
import main.util.Globals;
import main.util.Location;

import java.awt.*;

public class Enemy extends Entity {
    private TileManager.Quadrant quad;
    private EntityController.Controller controller;

    public Enemy (Location location, EntityController.Controller controller, TileManager.Quadrant quad) {
        super("Enemy", location, null);
        this.controller = controller;
        this.quad = quad;
    }

    public void runController(TileManager tileManager) {
        EntityController.runController(controller, tileManager, quad);
    }

    public void update() {
        // move based off its algorithm
        // or probably dont
    }

    //temporary
    @Override
    public void render(Graphics g) {
        //x,y,width,height
        g.setColor(new Color(0, 148, 212));
        int radius = (int) (Globals.constant("TILE_SIZE"));
        g.fillRect(getLocation().getX(), getLocation().getY(), radius, radius);
    }
}
