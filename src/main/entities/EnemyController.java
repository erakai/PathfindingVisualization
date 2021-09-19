package main.entities;

import main.display.Tile;
import main.display.TileManager;
import model.BreadthFirst;
import model.service.Node;

import java.awt.*;
import java.util.List;
import java.util.HashMap;

public class EnemyController {
    private EnemyController() {}

    public static void runBreadthFirstVisualization(TileManager tileManager) {
        new Thread(() -> {
            try {
                Thread.sleep(15000);
                System.out.println("5 more seconds");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            HashMap<Tile, Node> graph = new HashMap<>();
            Node start = new Node(graph, tileManager, tileManager.getTile(1,1));
            Node goal = new Node(graph, tileManager, tileManager.getTile(11,6));
            List<Tile> tiles = BreadthFirst.runFloodFill(start, goal);
            for (Tile t: tiles) t.setTileColor(Color.RED);
            start.tile().setTileColor(Color.GREEN);
            goal.tile().setTileColor(Color.BLUE);
        }).start();
    }

}
