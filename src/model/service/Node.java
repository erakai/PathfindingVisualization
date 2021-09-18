package model.service;

import main.display.Tile;
import main.display.TileManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node {
    private Map<Node, Direction> neighbors;
    private Tile tile;

    public Node(TileManager manager, Tile t) {
        this.tile = t;
        neighbors = new HashMap<>();

        if (t.getLocation().getTileX() > 0) {
            Tile leftNeighbor = manager.getTile(t.getLocation().getTileX() - 1, t.getLocation().getTileY());
            if (!leftNeighbor.isOccupied()) neighbors.put(new Node(manager, leftNeighbor), Direction.LEFT);
        }
        if (t.getLocation().getTileX() < manager.getColumns()-1) {
            Tile rightNeighbor = manager.getTile(t.getLocation().getTileX()+1, t.getLocation().getTileY());
            if (!rightNeighbor.isOccupied()) neighbors.put(new Node(manager, rightNeighbor), Direction.RIGHT);
        }
        if (t.getLocation().getTileY() > 0) {
            Tile topNeighbor = manager.getTile(t.getLocation().getTileX(), t.getLocation().getTileY() - 1);
            if (!topNeighbor.isOccupied()) neighbors.put(new Node(manager, topNeighbor), Direction.UP);
        }
        if (t.getLocation().getTileY() < manager.getRows()-1) {
            Tile bottomNeighbor = manager.getTile(t.getLocation().getTileX(), t.getLocation().getTileY() + 1);
            if (!bottomNeighbor.isOccupied())  neighbors.put(new Node(manager, bottomNeighbor), Direction.DOWN);
        }
    }

    public Map<Node, Direction> neighbors() {
        return neighbors;
    }

    public Tile tile() {
        return tile;
    }

}
