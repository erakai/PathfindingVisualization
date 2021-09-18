package model;

import main.display.Tile;
import model.service.Direction;
import model.service.Node;

import java.util.*;

/**
 * Simplest pathfinding Algorithm
 * https://www.redblobgames.com/pathfinding/a-star/introduction.html
 */
public class BreadthFirst {

    public static List<Tile> runFloodFill(Node start, Node goal) {
        Node current = start;
        Queue<Node> frontier = new LinkedList<>();
        Map<Node, Node> path = new HashMap<>();

        frontier.add(current);
        while (!frontier.isEmpty()) {
            current = frontier.poll();
            if (current == goal) break;
            for (Node n: current.neighbors().keySet()) {
                if (!path.containsValue(n)) {
                    frontier.add(n);
                    path.put(n, current);
                }
            }
        }

        current = goal;
        List<Node> pathBack = new ArrayList<>();
        while (current != start) {
            pathBack.add(current);
            current = path.get(current);
        }
        pathBack.add(start);

        List<Tile> tiles = new ArrayList<>();
        for (int i = pathBack.size()-1; i > 0; i--) {
            tiles.add(pathBack.get(i).tile());
        }

        return tiles;
    }

}
