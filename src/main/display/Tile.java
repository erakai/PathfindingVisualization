package main.display;

import main.util.Globals;
import main.util.Location;

import java.awt.*;

/**
 * Tile class, just rectangles with different shapes, colors, and locations
 * @author Kian Nowrouzi
 */
public class Tile implements Renderable{
    private Location location;
    private Color tileColor;
    private Color outlineColor;
    private boolean occupied = false;

    public Tile(Location loc, Color tileColor) {
        this.location = loc;
        this.tileColor = tileColor;
    }

    public Tile(Location loc) {
        this(loc, Color.BLACK);
        setOutlineColor(Color.GRAY);
    }

    //drawMe
    @Override
    public void render(Graphics g) {
        g.setColor(tileColor);
        g.fillRect(location.getX(), location.getY(), (int)Globals.constant("TILE_SIZE"), (int)Globals.constant("TILE_SIZE"));

        if (outlineColor != null) {
            g.setColor(outlineColor);
            g.drawRect(location.getX(), location.getY(), (int)Globals.constant("TILE_SIZE"), (int)Globals.constant("TILE_SIZE"));
        }
    }

    //accessors and mutators
    public Color getOutlineColor() {
        return outlineColor;
    }

    public void setOutlineColor(Color outlineColor) {
        this.outlineColor = outlineColor;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public Color getTileColor() {
        return tileColor;
    }

    public void setTileColor(Color tileColor) {
        this.tileColor = tileColor;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
