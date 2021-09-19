package main.entities;

import main.display.TileManager;
import main.util.Globals;
import main.util.Location;

import java.awt.*;

public class Enemy extends Entity {
    private TileManager.Quadrant quad;
    private EnemyController.Controller controller;

    public Enemy (Location location, EnemyController.Controller controller, TileManager.Quadrant quad) {
        super("Enemy", location, null);
        this.controller = controller;
        this.quad = quad;
    }

    public void runController(TileManager tileManager) {
        EnemyController.runController(controller, tileManager, quad);
    }

    public void update() {
        // move based off its algorithm
        // or probably dont
    }

    //temporary
    @Override
    public void render(Graphics g) {
        //x,y,width,height
        g.setColor(Color.green);
        int radius = (int) (Globals.constant("TILE_SIZE") / 2);
        g.fillOval(getLocation().getX(), getLocation().getY(), radius*2, radius*2);
    }
}
