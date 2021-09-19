package model.service;

import main.display.Tile;
import main.display.TileManager;

import java.util.*;

public class Node {
    private Node parent;
    private List<Node> neighbors;
    private Tile tile;


    /*
        Example of usage:
            HashMap<Tile, Node> graph = new HashMap<>();
            Node start = new Node(graph, tileManager, tileManager.getTile(1,1));
            Node goal = new Node(graph, tileManager, tileManager.getTile(10,5));
            List<Tile> tiles = BreadthFirst.runFloodFill(start, goal);
     */
    public Node(HashMap<Tile, Node> graph, TileManager manager, Tile t) {
        this.tile = t;
        neighbors = new ArrayList<>();
        graph.put(t, this);

        if (t.getLocation().getTileY() > 0) {
            Tile topNeighbor = manager.getTile(t.getLocation().getTileX(), t.getLocation().getTileY() - 1);
            if (graph.containsKey(topNeighbor)) {
                neighbors.add(graph.get(topNeighbor));
            } else if (!topNeighbor.isOccupied()) {
                neighbors.add(new Node(graph, manager, topNeighbor));
            }
        }
        if (t.getLocation().getTileX() > 0) {
            Tile leftNeighbor = manager.getTile(t.getLocation().getTileX() - 1, t.getLocation().getTileY());
            if (graph.containsKey(leftNeighbor)) {
                neighbors.add(graph.get(leftNeighbor));
            } else if (!leftNeighbor.isOccupied()) {
                neighbors.add(new Node(graph, manager, leftNeighbor));
            }
        }
        if (t.getLocation().getTileY() < manager.getRows()-1) {
            Tile bottomNeighbor = manager.getTile(t.getLocation().getTileX(), t.getLocation().getTileY() + 1);
            if (graph.containsKey(bottomNeighbor)) {
                neighbors.add(graph.get(bottomNeighbor));
            } else if (!bottomNeighbor.isOccupied()) {
                neighbors.add(new Node(graph, manager, bottomNeighbor));
            }
        }
        if (t.getLocation().getTileX() < manager.getColumns()-1) {
            Tile rightNeighbor = manager.getTile(t.getLocation().getTileX()+1, t.getLocation().getTileY());
            if (graph.containsKey(rightNeighbor)) {
                neighbors.add(graph.get(rightNeighbor));
            } else if (!rightNeighbor.isOccupied()) {
                neighbors.add(new Node(graph, manager, rightNeighbor));
            }
        }
    }

    public List<Node> neighbors() {
        return neighbors;
    }

    public Tile tile() {
        return tile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(tile, node.tile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tile);
    }
}
