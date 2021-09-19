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
        Enemy enemy1 = new Enemy(new Location(0,0), EnemyController.Controller.BreadthFirst,
                TileManager.Quadrant.TL);
        Enemy enemy2 = new Enemy(new Location((int) Globals.constant("COLUMN_#")-1,0),
                EnemyController.Controller.Dijkstra, TileManager.Quadrant.BL);
        Enemy enemy3 = new Enemy(new Location(0,(int) Globals.constant("ROW_#")-1),
                EnemyController.Controller.AStar, TileManager.Quadrant.TR);
        Enemy enemy4 = new Enemy(new Location((int) Globals.constant("COLUMN_#")-1,
                (int) Globals.constant("ROW_#")-1), EnemyController.Controller.Static,
                TileManager.Quadrant.BR);

        enemies.add(enemy1);
        enemies.add(enemy2);
        enemies.add(enemy3);
        enemies.add(enemy4);
    }

    public void visualize(TileManager tm) {
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
