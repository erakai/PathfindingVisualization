package model;

import main.display.Tile;
import model.service.Node;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class AStar {

    private static int heuristic(Node current, Node goal) {
        return Math.abs(current.tile().getLocation().getTileX() - goal.tile().getLocation().getTileX()) +
                Math.abs(current.tile().getLocation().getTileY() - goal.tile().getLocation().getTileY());
    }

    public static List<Tile> runAStar (Node start, Node goal, Collection<Node> graph) {
        HashMap<Node, Integer> nodeCosts = new HashMap<>();
        List<Node> visitedNodes = new ArrayList<>();
        HashMap<Node, Node> path = new HashMap<>();
        List<Node> pathToGoal = new ArrayList<>();

        nodeCosts.put(start, 0);
        initVertices(nodeCosts, graph);

        nodeCosts.put(start, 0);

        while (visitedNodes.size() <= graph.size()) {
            Node minimumNode = null;
            int minCost = Integer.MAX_VALUE;
            for (Node n: nodeCosts.keySet()) {
                if (nodeCosts.get(n) < minCost && !visitedNodes.contains(n)) {
                    minimumNode = n;
                    minCost = nodeCosts.get(n);
                }
            }

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
                int newCost = nodeCosts.get(minimumNode) + 1; // Old Cost + movement costs 1
                if (!visitedNodes.contains(neighborNode)) {
                    if (!neighborNode.tile().isOccupied()) {
                        int calculated = newCost + (heuristic(neighborNode, goal));
//                        System.out.println(neighborNode.tile().getLocation()  + " === " + nodeCosts.get(minimumNode) + " + 1 + " + heuristic(neighborNode, goal));
//                        System.out.println(heuristic(neighborNode, goal) + " distance from " + neighborNode.tile().getLocation().getTileX() + ", " + neighborNode.tile().getLocation().getTileY() + " to " + goal.tile().getLocation().getTileX() + " , " + goal.tile().getLocation().getTileY());

                        nodeCosts.put(neighborNode, calculated);
                        neighborNode.tile().setTileColor(new Color( (calculated > 0 && (calculated / 2) < 255) ? calculated / 2 : 255,  (calculated > 0 && (calculated / 2) < 255) ? calculated / 2 : 255, (calculated > 0 && (calculated / 2) < 255) ? calculated / 2 : 255));

                        try {
                            Thread.sleep(20 / minimumNode.neighbors().size());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        nodeCosts.put(neighborNode, Integer.MAX_VALUE);
                    }
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
