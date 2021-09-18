/** Basically just a grid setup of tiles for individual/mass manipulation and different colors and organization
 *
 * @author Kian Nowrouzi
 */


package main.display;

public class TileManager {
    private static Tile[][] tileArray;
    private static int rows, columns, fullSize;

    private TileManager() {
        rows = 8;
        columns = 8;
        fullSize = rows*columns;
        tileArray= new Tile[rows][columns];
    }

    public Tile getTile(int row, int column) {
        return tileArray[row][column];
    }

    //accessors
    public static int getRows() {
        return rows;
    }

    public static int getColumns() {
        return columns;
    }

    public static int getFullSize() {
        return fullSize;
    }
}
