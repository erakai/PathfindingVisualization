/**Tile class, just rectangles with different shapes, colors, and locations
 *
 * @author Kian Nowrouzi
 */

package main.display;

import java.awt.*;


public class Tile implements Renderable{
    private int x,y,width,height;
    private Color tileColor;
    private boolean occupied;

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    //accessors and mutators
    public Color getTileColor() {
        return tileColor;
    }

    public void setTileColor(Color tileColor) {
        this.tileColor = tileColor;
    }

    //drawMe
    public void render(Graphics g) {
        g.fillRect(x,y,width,height);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
