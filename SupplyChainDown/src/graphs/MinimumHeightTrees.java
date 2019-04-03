package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * For an undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.
 * <p>
 * Format
 * The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).
 * <p>
 * You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 * <p>
 * Example 1 :
 * <p>
 * Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 * <p>
 * 0
 * |
 * 1
 * / \
 * 2   3
 * <p>
 * Output: [1]
 * Example 2 :
 * <p>
 * Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 * <p>
 * 0  1  2
 * \ | /
 * 3
 * |
 * 4
 * |
 * 5
 * <p>
 * Output: [3, 4]
 * Note:
 * <p>
 * According to the definition of tree on Wikipedia:
 * “a tree is an undirected graph in which any two vertices are connected by exactly one path.
 * In other words, any connected graph without simple cycles is a tree.”
 * The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 */
public class MinimumHeightTrees {

    public static void main(String[] args) {
        MinimumHeightTrees instance = new MinimumHeightTrees();
//        int n = 4;
//        int n = 6;
        int n = 0;
//        int[][] edges = {{1, 0}, {1, 2}, {1, 3}};
//        int[][] edges = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
        int[][] edges = {};
        System.out.println(instance.findMinHeightTrees(n, edges));
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, Set<Integer>> nodeMap = new HashMap<>();
        Queue<Integer> nodeQueue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            nodeMap.put(i, new HashSet<>());
        }

        for (int[] edge : edges) {
            nodeMap.get(edge[0]).add(edge[1]);
            nodeMap.get(edge[1]).add(edge[0]);
        }

        reduceTree(nodeMap, nodeQueue);

        return new ArrayList<>(nodeMap.keySet());
    }

    public void findLeaves(Map<Integer, Set<Integer>> nodeMap, Queue<Integer> nodeQueue) {
        nodeQueue.add(-1);
        for (Integer node : nodeMap.keySet()) {
            if (nodeMap.get(node).size() == 1) {
                nodeQueue.add(node);
            }
        }
        nodeQueue.add(-1);
    }

    public void removeNode(Map<Integer, Set<Integer>> nodeMap, Integer node) {
        nodeMap.remove(node);

        for (Integer key : nodeMap.keySet()) {
            nodeMap.get(key).remove(node);
        }
    }

    public void reduceTree(Map<Integer, Set<Integer>> nodeMap, Queue<Integer> nodeQueue) {

        findLeaves(nodeMap, nodeQueue);

        while (!nodeQueue.isEmpty()) {
            Integer node = nodeQueue.poll();
            if (nodeMap.size() < 3 && node == -1) {
                break;
            }
            if (node == -1) {
                nodeQueue.add(-1);
                continue;
            }
            Set<Integer> neighbors = nodeMap.get(node);
            for (Integer neighbor : neighbors) {
                nodeMap.get(neighbor).remove(node);
                if (nodeMap.get(neighbor).size() == 1) {
                    nodeQueue.add(neighbor);
                }
            }
            nodeMap.remove(node);

        }

    }
}
