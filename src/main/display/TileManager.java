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
    private Tile[][] tileArray;
    private int rows, columns, fullSize;

    public TileManager() {
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
    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int getFullSize() {
        return fullSize;
    }

    //makes a tile green and impassable (a wall)
    public void setWall(int row, int column) {
        tileArray[column][row].setTileColor(Color.green);
        tileArray[column][row].setOccupied(true);
    }
}
