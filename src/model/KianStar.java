package model;

import main.display.Tile;
import model.service.Node;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class KianStar {
    public static List<Tile> runHeadlessChicken(Node start, Node goal) {
        Node current;
        Node neighbor;
        Queue<Node> frontier = new LinkedList<>();
        Map<Node, Node> path = new HashMap<>();
        int randomNum;
        List<Tile> tiles = new ArrayList<>();

        current = start;
        while (current != goal) {
            if (current.equals(goal)) break;
            randomNum = ThreadLocalRandom.current().nextInt(0,  current.neighbors().size());
            current = current.neighbors().get(randomNum);
            if(!current.tile().isOccupied()) {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tiles.add(current.tile());
                if (current.tile().getTileColor() == Color.black)
                    current.tile().setTileColor(Color.white);
                else
                    current.tile().setTileColor(current.tile().getTileColor().darker());
            }
        }


        return tiles;
    }
}
/*
Node current;
        Node neighbor;
        Queue<Node> frontier = new LinkedList<>();
        Map<Node, Node> path = new HashMap<>();
        int randomNum;

        path.put(start, null);
        frontier.add(start);
        while (!frontier.isEmpty()) {
            current = frontier.remove();
            if (current.equals(goal)) break;

            neighbor = current.neighbors().get(ThreadLocalRandom.current().nextInt(0,  current.neighbors().size()));

            neighbor.tile().setTileColor(Color.BLUE);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            neighbor.tile().setTileColor(Color.darkGray);

            if (!path.containsKey(neighbor)) {
                frontier.add(neighbor);
                path.put(neighbor, current);
            }
        }

        Node point = goal;
        List<Node> pathBack = new ArrayList<>();
        //substituted "start" for "goal" [didn't work]
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
 */