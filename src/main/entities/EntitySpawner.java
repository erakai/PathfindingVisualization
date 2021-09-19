package main.entities;

import main.core.Updatable;
import main.display.Renderable;
import main.display.TileManager;
import main.util.Globals;
import main.util.Location;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EntitySpawner implements Updatable, Renderable {
    private List<Enemy> enemies;
    private Player player;

    public EntitySpawner() {
        enemies = new ArrayList<>();

        player = new Player(new Location((int) Globals.constant("COLUMN_#") / 2,
                (int) Globals.constant("ROW_#") / 2));
        Enemy enemy1 = new Enemy(new Location(0,0), EntityController.Controller.BreadthFirst,
                TileManager.Quadrant.TL);
        Enemy enemy2 = new Enemy(new Location((int) Globals.constant("COLUMN_#")-1,0),
                EntityController.Controller.Dijkstra, TileManager.Quadrant.TR);
        Enemy enemy3 = new Enemy(new Location(0,(int) Globals.constant("ROW_#")-1),
                EntityController.Controller.AStar, TileManager.Quadrant.BL);
        Enemy enemy4 = new Enemy(new Location((int) Globals.constant("COLUMN_#")-1,
                (int) Globals.constant("ROW_#")-1), EntityController.Controller.KianStar,
                TileManager.Quadrant.BR);

        enemies.add(enemy1);
        enemies.add(enemy2);
        enemies.add(enemy3);
        enemies.add(enemy4);
    }

    public void visualize(TileManager tm) {
        try {
            Thread.sleep(0);
            System.out.println("3 more seconds");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (Enemy e: enemies) {
            e.runController(tm);
        }
    }

    @Override
    public void update() {
        for (Entity e: enemies) e.update();
        player.update();
    }

    @Override
    public void render(Graphics g) {
        for (Entity e: enemies) e.render(g);
        player.render(g);
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
