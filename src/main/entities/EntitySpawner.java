package main.entities;

import main.core.Updatable;
import main.display.Renderable;
import main.util.Location;

import java.awt.*;
import java.util.List;

public class EntitySpawner implements Updatable, Renderable {
    private List<Entity> entities;
    private Player player;

    public EntitySpawner() {
        Player player = new Player(new Location(12,12));
        Enemy enemy1 = new Enemy(new Location(0,0));
        Enemy enemy2 = new Enemy(new Location(24,0));
        Enemy enemy3 = new Enemy(new Location(0,24));
        Enemy enemy4 = new Enemy(new Location(24,24));
    }


    @Override
    public void update() {
        for (Entity e: entities) e.update();
        player.update();
    }

    @Override
    public void render(Graphics g) {
        for (Entity e: entities) e.render(g);
        player.render(g);
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
