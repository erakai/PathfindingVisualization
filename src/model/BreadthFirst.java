package model;

import main.display.Tile;
import main.util.Globals;
import model.service.Node;

import java.awt.*;
import java.util.List;
import java.util.Queue;
import java.util.*;

/**
 * Simplest pathfinding Algorithm
 * https://www.redblobgames.com/pathfinding/a-star/introduction.html
 */
public class BreadthFirst {

    public static List<Tile> runFloodFill(Node start, Node goal) {
        Node current;
        Queue<Node> frontier = new LinkedList<>();
        Map<Node, Node> path = new HashMap<>();

        path.put(start, null);
        frontier.add(start);
        while (!frontier.isEmpty()) {
            current = frontier.remove();
            if (current.equals(goal)) break;
            for (Node n: current.neighbors()) {

                n.tile().setTileColor(Color.BLUE);
                try {
                    Thread.sleep((int) Globals.constant("DELAY_IN_ALGORITHMS"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                n.tile().setTileColor(Color.lightGray);

                if (!path.containsKey(n)) {
                    frontier.add(n);
                    path.put(n, current);
                }
            }
        }

        Node point = goal;
        List<Node> pathBack = new ArrayList<>();
        while (!point.equals(start)) {
            pathBack.add(point);
            point = path.get(point);
        }
        pathBack.add(start);

        List<Tile> tiles = new ArrayList<>();
        for (int i = pathBack.size()-1; i > 0; i--) {
            tiles.add(pathBack.get(i).tile());
        }

        return tiles;
    }

}
