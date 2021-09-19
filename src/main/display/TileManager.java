package main.display;

import main.util.Globals;
import main.util.Location;
import model.BreadthFirst;
import model.service.Node;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/** Basically just a grid setup of tiles for individual/mass manipulation and different colors and organization
 *
 * @author Kian Nowrouzi
 */
public class TileManager implements Renderable {
    private final Tile[][] tileArray;
    private Tile[][] TLArray, BLArray, TRArray, BRArray;
    private final int rows, columns;

    public enum Quadrant {
        TL, BL, TR, BR;
    }

    public TileManager() {
        rows = (int) Globals.constant("ROW_#");
        columns = (int) Globals.constant("COLUMN_#");
        tileArray= new Tile[columns][rows];

        populateMainArray();
        populateSubArrays();
    }

    public Tile[][] getSubArray(Quadrant quad) {
        switch (quad) {
            case TL:
                return getTLArray();
            case BL:
                return getBLArray();
            case TR:
                return getTRArray();
            case BR:
                return getBRArray();
        }
        return null;
    }

    private void populateSubArrays() {
        int subRows = ((int) Globals.constant("ROW_#") - 1) / 2;
        int subColumns = ((int) Globals.constant("COLUMN_#") - 1) / 2;
        TLArray = new Tile[subColumns][subRows];
        BLArray = new Tile[subColumns][subRows];
        TRArray = new Tile[subColumns][subRows];
        BRArray = new Tile[subColumns][subRows];

        for (int i = 0; i < subRows; i++) {
            for (int j = 0; j < subColumns; j++) {
                TLArray[j][i] = getTile(j, i);
                BLArray[j][i] = getTile(j, i + subRows);
                TRArray[j][i] = getTile(j + subColumns, i);
                BRArray[j][i] = getTile(j + subColumns, i + subColumns);
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
