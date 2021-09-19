package main.util;

/**
 * This is just a location class that stores the location of something. If we have some enemy at (3,3) on the grid
 * we want to be able to record where it is.
 */
public class Location {
    private int x, y;
    private int tileX, tileY;

    /**
     * This constructor creates the Location given the coordinates on the tile grid, and then multiples those by the
     * size of the tile in order to figure out the raw x and y values.
     *
     * For example, if given (1,1) on the grid, it would record that and then figure out that it's raw x and y on the
     * screen was (32, 32) if tiel size was 32.
     */
    public Location(int tileX,int tileY) {
        this((int) (tileX * Globals.constant("TILE_SIZE")), (int) (tileY * Globals.constant("TILE_SIZE"))
                , tileX, tileY);
    }

    public Location(int x, int y, int tileX, int tileY) {
        this.x = x;
        this.y = y;
        this.tileX = tileX;
        this.tileY = tileY;
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                ", tileX=" + tileX +
                ", tileY=" + tileY +
                '}';
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

    public int getTileX() {
        return tileX;
    }

    public void setTileX(int tileX) {
        this.tileX = tileX;
    }

    public int getTileY() {
        return tileY;
    }

    public void setTileY(int tileY) {
        this.tileY = tileY;
    }
}
