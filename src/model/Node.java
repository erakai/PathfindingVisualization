package model;

import main.display.Tile;
import main.display.TileManager;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public List<Node> neighbors;

    public Node(TileManager manager, Tile t) {
        neighbors = new ArrayList<>();

        if (t.getLocation().getTileX() > 0) {
            Tile leftNeighbor = manager.getTile(t.getLocation().getTileX() - 1, t.getLocation().getTileY());
            neighbors.add(new Node(manager, leftNeighbor));
        }
        if (t.getLocation().getTileX() < manager.getColumns()-1) {
            Tile rightNeighbor = manager.getTile(t.getLocation().getTileX()+1, t.getLocation().getTileY());
            neighbors.add(new Node(manager, rightNeighbor));
        }
        if (t.getLocation().getTileY() > 0) {
            Tile topNeighbor = manager.getTile(t.getLocation().getTileX(), t.getLocation().getTileY() - 1);
            neighbors.add(new Node(manager, topNeighbor));
        }
        if (t.getLocation().getTileY() < manager.getRows()-1) {
            Tile bottomNeighbor = manager.getTile(t.getLocation().getTileX(), t.getLocation().getTileY() + 1);
            neighbors.add(new Node(manager, bottomNeighbor));
        }
    }

}
