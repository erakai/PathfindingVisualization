package main.entities;

import main.display.Tile;
import main.display.TileManager;
import model.BreadthFirst;
import model.service.Node;

import java.awt.*;
import java.util.List;
import java.util.HashMap;

public class EnemyController {
    public enum Controller {
        BreadthFirst, Dijkstra, AStar, Static;
    }

    private EnemyController() {}

    public static void runController(Controller controller, TileManager tileManager, TileManager.Quadrant quad) {
        switch (controller) {
            case BreadthFirst:
                runBreadthFirstVisualization(tileManager, quad);
                break;
            case Dijkstra:

                break;
            case AStar:

                break;
            case Static:

                break;
        }
    }

    private static void runBreadthFirstVisualization(TileManager tileManager, TileManager.Quadrant quad) {
        new Thread(() -> {
            try {
                Thread.sleep(10000);
                System.out.println("3 more seconds");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Tile[][] array = tileManager.getSubArray(quad);

            HashMap<Tile, Node> graph = new HashMap<>();
            Node start = new Node(graph, array, array[0][0]);
            Node goal = new Node(graph, array, array[array[0].length-1][array.length-1]);
            List<Tile> tiles = BreadthFirst.runFloodFill(start, goal);
            for (Tile t: tiles) t.setTileColor(Color.RED);
        }).start();
    }

}
