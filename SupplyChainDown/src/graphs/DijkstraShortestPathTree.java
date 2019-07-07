package graphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
 * Given a graph and a source vertex in the graph, find shortest paths from source to all vertices in the given graph.
 * <p>
 * Dijkstra’s algorithm is very similar to Prim’s algorithm for minimum spanning tree.
 * Like Prim’s MST, we generate a SPT (shortest path tree) with given source as root.
 * We maintain two sets, one set contains vertices included in shortest path tree,
 * other set includes vertices not yet included in shortest path tree.
 * At every step of the algorithm, we find a vertex which is in the other set (set of not yet included)
 * and has a minimum distance from the source.
 * <p>
 * Below are the detailed steps used in Dijkstra’s algorithm to find the shortest path from a single source vertex
 * to all other vertices in the given graph.
 * Algorithm
 * 1) Create a set sptSet (shortest path tree set) that keeps track of vertices included in shortest path tree,
 * i.e., whose minimum distance from source is calculated and finalized. Initially, this set is empty.
 * 2) Assign a distance value to all vertices in the input graph. Initialize all distance values as INFINITE.
 * Assign distance value as 0 for the source vertex so that it is picked first.
 * 3) While sptSet doesn’t include all vertices
 * ….a) Pick a vertex u which is not there in sptSet and has minimum distance value.
 * ….b) Include u to sptSet.
 * ….c) Update distance value of all adjacent vertices of u. To update the distance values,
 * iterate through all adjacent vertices. For every adjacent vertex v, if sum of distance value of u (from source)
 * and weight of edge u-v, is less than the distance value of v, then update the distance value of v.
 */
public class DijkstraShortestPathTree {

    // Driver method
    public static void main(String[] args) {
        /* Let us create the example graph discussed above */
        int[][] graph = new int[][]{
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        DijkstraShortestPathTree t = new DijkstraShortestPathTree();
        t.dijkstra(graph, 0);
    }

    void dijkstra(int[][] graph, int src) {
        Set<Integer> shortestPathTreeSet = new HashSet<>();
        int[] distance = new int[graph.length];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[src] = 0;
        //System.out.println(Arrays.toString(distance));
        dijkstraRecursive(graph, distance, shortestPathTreeSet);
        System.out.println(Arrays.toString(distance));
    }

    void dijkstraRecursive(int[][] graph, int[] distance, Set<Integer> shortestPathTreeSet) {
        if (shortestPathTreeSet.size() == graph.length) {
            return;
        }
        int minDistanceValue = Integer.MAX_VALUE;
        int minDistanceIndex = -1;
        for (int i = 0; i < distance.length; i++) {
            if (minDistanceValue > distance[i] && !shortestPathTreeSet.contains(i)) {
                minDistanceValue = distance[i];
                minDistanceIndex = i;
                //System.out.println(minDistanceIndex+" "+minDistanceValue);
            }
        }
        shortestPathTreeSet.add(minDistanceIndex);

        for (int i = 0; i < graph[minDistanceIndex].length; i++) {
            if (graph[minDistanceIndex][i] != 0 && !shortestPathTreeSet.contains(i)) {
                distance[i] = Math.min(distance[minDistanceIndex] + graph[minDistanceIndex][i], distance[i]);
            }
        }
        //System.out.println(Arrays.toString(distance));
        dijkstraRecursive(graph, distance, shortestPathTreeSet);
    }
}
