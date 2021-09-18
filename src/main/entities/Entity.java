package main.entities;

import main.display.Renderable;
import main.util.Location;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 *  A basic Entity template class that knows its location, image, and name.
 *
 *  To create an Entity class based off this:
 *
 *  public class EntityName extends Entity {
 *      public EntityName (Location location) {
 *          super("EntityName", location, ResourceManager.getSprite("EntityName"));
 *      }
 *  }
 */
public abstract class Entity implements Renderable {
    private Location location;
    private BufferedImage image;
    private String name;
    private boolean visible = true;

    public Entity(String name, Location location, BufferedImage image) {
        this.location = location;
        this.image = image;
        this.name = name;
    }

    @Override
    public void render(Graphics g) {
        if (visible) g.drawImage(image, location.getX(), location.getY(), null);
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
