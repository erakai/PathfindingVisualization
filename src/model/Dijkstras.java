package model;

import main.display.Tile;
import model.service.Node;

import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.List;

public class Dijkstras {

    private static HashMap<Node, Integer> initVertices(HashMap<Node, Integer> map) {
        boolean updated = false;
        for (Node node: map.keySet()) {
            for (Node neigh: node.neighbors()) {
                if (!map.containsKey(neigh)) {
                    map.put(neigh, Integer.MAX_VALUE);
                    updated = true;
                }
            }
        }

        if (updated) initVertices(map);
        return map;
    }

    public static List<Tile> runDijkstras (Node start, Node goal) {
        HashMap<Node, Integer> nodeCosts = new HashMap<>();
        List<Node> visitedNodes = new ArrayList<>();

        nodeCosts.put(start, 0);
        nodeCosts = initVertices(nodeCosts);

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
