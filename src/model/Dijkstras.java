package model;

import main.display.Tile;
import model.service.Node;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Dijkstras {

    private static void initVertices(HashMap<Node, Integer> map, Collection<Node> graph) {
        for (Node n: graph) {
            map.put(n, Integer.MAX_VALUE);
        }
    }

    public static List<Tile> runDijkstras (Node start, Node goal, Collection<Node> graph) {
        HashMap<Node, Integer> nodeCosts = new HashMap<>();
        List<Node> visitedNodes = new ArrayList<>();

        nodeCosts.put(start, 0);
        initVertices(nodeCosts, graph);

        nodeCosts.put(start, 0);
        visitedNodes.add(start);

        while (nodeCosts.containsValue(Integer.MAX_VALUE)) {
            Node minimumNode = start;
            int minCost = Integer.MAX_VALUE;
            for (Node n: nodeCosts.keySet()) {
                if (nodeCosts.get(n) < minCost && !visitedNodes.contains(n)) {
                    minimumNode = n;
                    minCost = nodeCosts.get(n);
                }
            }

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            minimumNode.tile().setTileColor(Color.darkGray);

            visitedNodes.add(minimumNode);
            for (Node neighborNode: minimumNode.neighbors()) {
                if (!visitedNodes.contains(neighborNode)) {
                    int neighborCost = 1;
                    if (neighborNode.tile().isOccupied()) neighborCost = Integer.MAX_VALUE/2;
                    nodeCosts.put(neighborNode, minCost + neighborCost);
                }
            }
        }

        List<Tile> tiles = new ArrayList<>();

        return tiles;
    }

}
