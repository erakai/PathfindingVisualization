package main.entities;

import main.display.Tile;
import main.display.TileManager;
import model.AStar;
import model.BreadthFirst;
import model.Dijkstras;
import model.KianStar;
import model.service.Node;

import java.awt.*;
import java.util.List;
import java.util.HashMap;

public class EntityController {
    public enum Controller {
        BreadthFirst, Dijkstra, AStar, KianStar;
    }

    private EntityController() {}

    public static void runController(Controller controller, TileManager tileManager, TileManager.Quadrant quad) {
        switch (controller) {
            case BreadthFirst -> runBreadthFirstVisualization(tileManager, quad);
            case Dijkstra -> runDijkstrasVisualization(tileManager, quad);
            case AStar -> runAStarVisualization(tileManager, quad);
            case KianStar -> runKianStarVisualization(tileManager, quad);
        }
    }

    private static void runBreadthFirstVisualization(TileManager tileManager, TileManager.Quadrant quad) {
        new Thread(() -> {
            Tile[][] array = tileManager.getSubArray(quad);

            HashMap<Tile, Node> graph = new HashMap<>();
            Node start = new Node(graph, array, array[0][0], quad, tileManager);
            Node goal = new Node(graph, array, array[array[0].length-1][array.length-1], quad, tileManager);
            List<Tile> tiles = BreadthFirst.runFloodFill(start, goal);
            if (!tiles.isEmpty() && !tiles.contains(goal.tile())) tiles.add(goal.tile());
            for (Tile t: tiles) t.setTileColor(Color.RED);
        }).start();
    }

    private static void runDijkstrasVisualization(TileManager tileManager, TileManager.Quadrant quad) {
        new Thread(() -> {
            Tile[][] array = tileManager.getSubArray(quad);

            HashMap<Tile, Node> graph = new HashMap<>();
            Node start = new Node(graph, array, array[array.length-1][0], quad, tileManager);
            Node goal = new Node(graph, array, array[0][array.length-1], quad, tileManager);
            List<Tile> tiles = Dijkstras.runDijkstras(start, goal, graph.values());
            if (!tiles.isEmpty() && !tiles.contains(goal.tile())) tiles.add(goal.tile());
            for (Tile t: tiles) t.setTileColor(Color.RED);
        }).start();
    }

    private static void runAStarVisualization(TileManager tileManager, TileManager.Quadrant quad) {
        new Thread(() -> {
            Tile[][] array = tileManager.getSubArray(quad);

            HashMap<Tile, Node> graph = new HashMap<>();
            Node start = new Node(graph, array, array[0][array.length - 1], quad, tileManager);
            Node goal = new Node(graph, array, array[array.length-1][0], quad, tileManager);
            List<Tile> tiles = AStar.runAStar(start, goal, graph.values());
            if (!tiles.isEmpty() && !tiles.contains(goal.tile())) tiles.add(goal.tile());
            for (Tile t : tiles) t.setTileColor(Color.RED);
        }).start();
    }

    private static void runKianStarVisualization(TileManager tileManager, TileManager.Quadrant quad) {
        new Thread(() -> {
            Tile[][] array = tileManager.getSubArray(quad);

            HashMap<Tile, Node> graph = new HashMap<>();
            Node start = new Node(graph, array, array[array[0].length-1][array.length-1], quad, tileManager);
            Node goal = new Node(graph, array, array[0][0], quad, tileManager);
            List<Tile> tiles = KianStar.runHeadlessChicken(start, goal);
            if (!tiles.isEmpty() && !tiles.contains(goal.tile())) tiles.add(goal.tile());
            for (Tile t: tiles) t.setTileColor(Color.RED);
        }).start();
    }

}


