package model;

import main.display.Tile;
import main.util.Globals;
import model.service.Node;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Dijkstras {

    public static List<Tile> runDijkstras (Node start, Node goal, Collection<Node> graph) {
        HashMap<Node, Integer> nodeCosts = new HashMap<>();
        List<Node> visitedNodes = new ArrayList<>();
        HashMap<Node, Node> path = new HashMap<>();
        List<Node> pathToGoal = new ArrayList<>();


        nodeCosts.put(start, 0);
        initVertices(nodeCosts, graph);

        nodeCosts.put(start, 0);
        visitedNodes.add(start);

        while (visitedNodes.size() <= graph.size()) {
            Node minimumNode = start;
            int minCost = Integer.MAX_VALUE;
            for (Node n: nodeCosts.keySet()) {
                if (nodeCosts.get(n) < minCost && !visitedNodes.contains(n)) {
                    minimumNode = n;
                    minCost = nodeCosts.get(n);
                }
            }

            try {
                Thread.sleep((int) Globals.constant("DELAY_IN_ALGORITHMS"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            minimumNode.tile().setTileColor(Color.darkGray);

            visitedNodes.add(minimumNode);
            if (minimumNode.equals(goal)) {
                Node current = minimumNode;
                while (path.containsKey(current)) {
                    pathToGoal.add(current);
                    current = path.get(current);
                }
                break;
            }

            for (Node neighborNode: minimumNode.neighbors()) {
                if (!visitedNodes.contains(neighborNode)) {
                    int neighborCost = 1;
                    if (neighborNode.tile().isOccupied()) neighborCost = Integer.MAX_VALUE - minCost;
                    nodeCosts.put(neighborNode, minCost + neighborCost);
                    path.put(neighborNode, minimumNode);
                }
            }

        }

        pathToGoal.add(start);
        List<Tile> tiles = new ArrayList<>();
        for (int i = pathToGoal.size()-1; i > 0; i--) {
            tiles.add(pathToGoal.get(i).tile());
        }
        return tiles;
    }

    private static void initVertices(HashMap<Node, Integer> map, Collection<Node> graph) {
        for (Node n: graph) {
            map.put(n, Integer.MAX_VALUE);
        }
    }

}
