/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author vasher
 */
public class FindRouteExists {

    public static HashSet<String> visited;
    public static Queue<Node> queue = new LinkedList<Node>();
    public static HashMap<String, ArrayList<Node>> adjacencyMap = new HashMap<>();
    public static boolean routeExists(HashMap<String, ArrayList<Node>> adjacencyMap, Node a, Node b) {
        FindRouteExists.adjacencyMap = adjacencyMap;
        if (!adjacencyMap.containsKey(a.value) || !adjacencyMap.containsKey(b.value)) {
            System.out.println("Incorrect Input");
            return false;
        }
        System.out.println("Checking... " + a.value);
        queue.add(a);
        return searchNode(b);
    }

    public static boolean searchNode(Node b) {
        while(!queue.isEmpty()) {
            Node n = queue.poll();
            if (!visited.contains(n.value)) {
                System.out.println("Checking... " + n.value);
                if (n.value.equals(b.value)) {
                    System.out.println("Route Exists!!!!");
                    return true;
                }
                visited.add(n.value);
                queue.addAll(adjacencyMap.get(n.value));
            }
        }
        return false;
    }

    public static void main(String[] args) {
        visited = new HashSet<String>();
        if (routeExists(GraphUtil.sampleDirectionalGraph(), new Node("A"), new Node("E"))) {
            System.out.println("Route Exists");
        } else {
            System.out.println("Route Does not Exists");
        }
    }
}
