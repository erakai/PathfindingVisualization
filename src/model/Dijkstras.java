package model;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Dijkstras {
    static final int totalNodes = 9;
    int minDistance(int dist[], Boolean sptSet[])
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < totalNodes; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    // function to print the distance array
    void printSolution(int dist[])
    {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < totalNodes; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }

    void dijkstra(int graph[][], int src)
    {
        int dist[] = new int[totalNodes]; //the result array, dist[i] is the distance from src to i
        

        // sptSet[i] will be set to true if vertex i is used an dprocessed
        Boolean sptSet[] = new Boolean[totalNodes];

        // Initialize all distances as INFINITE and stpSet[] as false
        for (int i = 0; i < totalNodes; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        // Distance of source vertex from itself is always 0
        dist[src] = 0;

        // Find shortest path for all vertices
        for (int count = 0; count < totalNodes - 1; count++) {
            //choose the unused vertex with the least distance to the current vertex
            int u = minDistance(dist, sptSet);

            // Mark the picked vertex as processed
            sptSet[u] = true;

            // Update dist value of the adjacent vertices of the picked vertex.
            for (int v = 0; v < totalNodes; v++)
                
                // ipdate the distance value if the new one is less than the old one
                if (!sptSet[v] && graph[u][v] != 0 && graph[u][v] != -1 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }

        // print the constructed distance array
        printSolution(dist);
    }

  public static void main(String[] args)
    {
        //test graph
        int graph[][] = new int[][] { 
                { 0, 4, -1, -1, -1, -1, -1, 8, -1 },
                { 4, 0, 8, -1, -1, -1, -1, 11, -1 },
                { -1, 8, 0, 7, -1, 4, -1, -1, 2 },
                { -1, -1, 7, 0, 9, 14, -1, -1, -1 },
                { -1, -1, -1, 9, 0, 10, -1, -1, -1 },
                { -1, -1, 4, 14, 10, 0, 2, -1, -1 },
                { -1, -1, -1, -1, -1, 2, 0, 1, 6 },
                { 8, 11, -1, -1, -1, -1, 1, 0, 7 },
                { -1, -1, 2, -1, -1, -1, 6, 7, 0 }
        };
        Dijkstras t = new Dijkstras();
        t.dijkstra(graph, 0);
    }
}
