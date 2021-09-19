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
    public Node(HashMap<Tile, Node> graph, Tile[][] array, Tile t) {
        this.tile = t;
        neighbors = new ArrayList<>();
        graph.put(t, this);

        if (t.getLocation().getTileY() > 0) {
            Tile topNeighbor = array[t.getLocation().getTileX()][t.getLocation().getTileY() - 1];
            if (!topNeighbor.isOccupied()) {
                if (graph.containsKey(topNeighbor)) {
                    neighbors.add(graph.get(topNeighbor));
                } else {
                    neighbors.add(new Node(graph, array, topNeighbor));
                }
            }
        }
        if (t.getLocation().getTileX() > 0) {
            Tile leftNeighbor = array[t.getLocation().getTileX() - 1][t.getLocation().getTileY()];
            if (!leftNeighbor.isOccupied()) {
                if (graph.containsKey(leftNeighbor)) {
                    neighbors.add(graph.get(leftNeighbor));
                } else if (!leftNeighbor.isOccupied()) {
                    neighbors.add(new Node(graph, array, leftNeighbor));
                }
            }
        }
        if (t.getLocation().getTileY() < array.length-1) {
            Tile bottomNeighbor = array[t.getLocation().getTileX()][t.getLocation().getTileY() + 1];
            if (!bottomNeighbor.isOccupied()) {
                if (graph.containsKey(bottomNeighbor)) {
                    neighbors.add(graph.get(bottomNeighbor));
                } else if (!bottomNeighbor.isOccupied()) {
                    neighbors.add(new Node(graph, array, bottomNeighbor));
                }
            }
        }
        if (t.getLocation().getTileX() < array[0].length -1) {
            Tile rightNeighbor = array[t.getLocation().getTileX()+1][t.getLocation().getTileY()];
            if (!rightNeighbor.isOccupied()) {
                if (graph.containsKey(rightNeighbor)) {
                    neighbors.add(graph.get(rightNeighbor));
                } else if (!rightNeighbor.isOccupied()) {
                    neighbors.add(new Node(graph, array, rightNeighbor));
                }
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
