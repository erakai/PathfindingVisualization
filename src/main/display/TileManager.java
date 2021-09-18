package main.display;

import main.util.Globals;
import main.util.Location;

import java.awt.*;

/** Basically just a grid setup of tiles for individual/mass manipulation and different colors and organization
 *
 * @author Kian Nowrouzi
 */
public class TileManager implements Renderable {
    private static Tile[][] tileArray;
    private static int rows, columns, fullSize;

    private TileManager() {
        rows = (int) Globals.constant("ROW_#");
        columns = (int) Globals.constant("COLUMN_#");
        fullSize = rows*columns;
        tileArray= new Tile[rows][columns];

        populateTiles();
    }

    private void populateTiles() {
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                tileArray[i][j] = new Tile(new Location(i, j));
            }
        }
    }

    @Override
    public void render(Graphics g) {
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                getTile(i, j).render(g);
            }
        }
    }

    public Tile getTile(int column, int row) {
        return tileArray[column][row];
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
