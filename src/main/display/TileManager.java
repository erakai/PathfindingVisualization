package main.display;

import main.util.Globals;
import main.util.Location;

import java.awt.*;

/** Basically just a grid setup of tiles for individual/mass manipulation and different colors and organization
 *
 * @author Kian Nowrouzi
 */
public class TileManager implements Renderable {
    private final Tile[][] tileArray;
    private Tile[][] TLArray, BLArray, TRArray, BRArray;
    private int rows, columns, subRows, subColumns;

    public enum Quadrant {
        TL, BL, TR, BR;
    }

    public TileManager() {
        rows = (int) Globals.constant("ROW_#");
        columns = (int) Globals.constant("COLUMN_#");
        tileArray = new Tile[columns][rows];

        populateMainArray();
        populateSubArrays();
    }

    public Tile[][] getSubArray(Quadrant quad) {
        return switch (quad) {
            case TL -> getTLArray();
            case BL -> getBLArray();
            case TR -> getTRArray();
            case BR -> getBRArray();
        };
    }

    private void populateSubArrays() {
        subRows = ((int) Globals.constant("ROW_#") - 1) / 2;
        subColumns = ((int) Globals.constant("COLUMN_#") - 1) / 2;
        TLArray = new Tile[subColumns][subRows];
        BLArray = new Tile[subColumns][subRows];
        TRArray = new Tile[subColumns][subRows];
        BRArray = new Tile[subColumns][subRows];

        for (int i = 0; i < subRows; i++) {
            for (int j = 0; j < subColumns; j++) {
                TLArray[j][i] = getTile(j, i);
                BLArray[j][i] = getTile(j, i + subRows + 1);
                TRArray[j][i] = getTile(j + subColumns + 1, i);
                BRArray[j][i] = getTile(j + subColumns + 1, i + subColumns + 1);
            }
        }
    }

    private void populateMainArray() {
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

    public int getTranslatedTileX(int tileX, Quadrant quad) {
        return switch (quad) {
            case TL, BL -> tileX;
            case TR, BR -> tileX - subRows - 1;
        };
    }

    public int getTranslatedTileY(int tileY, Quadrant quad) {
        return switch (quad) {
            case TL, TR -> tileY;
            case BL, BR -> tileY - subColumns - 1;
        };
    }

    public Tile getTile(int column, int row) {
        return tileArray[column][row];
    }

    //accessors
    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Tile[][] getTileArray() {
        return tileArray;
    }

    public Tile[][] getTLArray() {
        return TLArray;
    }

    public void setTLArray(Tile[][] TLArray) {
        this.TLArray = TLArray;
    }

    public Tile[][] getBLArray() {
        return BLArray;
    }

    public void setBLArray(Tile[][] BLArray) {
        this.BLArray = BLArray;
    }

    public Tile[][] getTRArray() {
        return TRArray;
    }

    public void setTRArray(Tile[][] TRArray) {
        this.TRArray = TRArray;
    }

    public Tile[][] getBRArray() {
        return BRArray;
    }

    public void setBRArray(Tile[][] BRArray) {
        this.BRArray = BRArray;
    }

    //makes a tile green and impassable (a wall)
    public void setWall(int row, int column) {
        tileArray[column][row].setOccupied(true);
    }
}
