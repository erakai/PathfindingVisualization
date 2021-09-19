package main.entities;

import main.core.Updatable;
import main.display.Renderable;
import main.util.Globals;
import main.util.Location;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EntitySpawner implements Updatable, Renderable {
    private List<Entity> entities;
    private Player player;

    public EntitySpawner() {
        entities = new ArrayList<>();

        player = new Player(new Location((int) Globals.constant("COLUMN_#") / 2,(int) Globals.constant("ROW_#") / 2));
        Enemy enemy1 = new Enemy(new Location(0,0));
        Enemy enemy2 = new Enemy(new Location((int) Globals.constant("COLUMN_#")-1,0));
        Enemy enemy3 = new Enemy(new Location(0,(int) Globals.constant("ROW_#")-1));
        Enemy enemy4 = new Enemy(new Location((int) Globals.constant("COLUMN_#")-1,(int) Globals.constant("ROW_#")-1));

        entities.add(enemy1);
        entities.add(enemy2);
        entities.add(enemy3);
        entities.add(enemy4);
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
