package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a reference of a node in a connected undirected graph,
 * return a deep copy (clone) of the graph.
 *
 * Each node in the graph contains a val (int) and a list (List[Node]) of its destinations.
 *
 *
 *
 * Example:
 *
 *
 * Input:
 * {"$id":"1","destinations":[{"$id":"2","destinations":[{"$ref":"1"},{"$id":"3","destinations":[{"$ref":"2"},
 * {"$id":"4","destinations":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}
 *
 * Explanation:
 * Node 1's value is 1, and it has two destinations: Node 2 and 4.
 * Node 2's value is 2, and it has two destinations: Node 1 and 3.
 * Node 3's value is 3, and it has two destinations: Node 2 and 4.
 * Node 4's value is 4, and it has two destinations: Node 1 and 3.
 *
 *
 * Note:
 *
 * The number of nodes will be between 1 and 100.
 * The undirected graph is a simple graph, which means no repeated edges and no self-loops in the graph.
 * Since the graph is undirected, if node p has node q as neighbor, then node q must have node p as neighbor too.
 * You must return the copy of the given node as a reference to the cloned graph.
 */
public class CloneGraph {

    public Node cloneGraph(Node node) {
        Map<Integer,Node> visited = new HashMap<>();
        return cloneGraphRecursive(node, visited);
    }

    public Node cloneGraphRecursive(Node node, Map<Integer,Node> visited){
        Node startNode = null;
        if(!visited.containsKey(node.val)){
            startNode = new Node();
            startNode.val = node.val;
            startNode.neighbors = new ArrayList<>();
            visited.put(startNode.val, startNode);
            for(Node neighbor: node.neighbors){
                startNode.neighbors.add(cloneGraphRecursive(neighbor, visited));
            }
        } else {
            startNode = visited.get(node.val);
        }
        return startNode;
    }

    public Node init() {
        Node n1 = new Node();
        n1.neighbors = new ArrayList<>();
        n1.val = 1;

        Node n2 = new Node();
        n2.neighbors = new ArrayList<>();
        n2.val = 2;

        Node n3 = new Node();
        n3.neighbors = new ArrayList<>();
        n3.val = 3;

        Node n4 = new Node();
        n4.neighbors = new ArrayList<>();
        n4.val = 4;
        n1.neighbors.add(n2);
        n1.neighbors.add(n4);
        n2.neighbors.add(n1);
        n2.neighbors.add(n3);
        n3.neighbors.add(n2);
        n3.neighbors.add(n4);
        n4.neighbors.add(n1);
        n4.neighbors.add(n3);

        return n1;
    }

    public static void main(String[] args) {
        CloneGraph instance = new CloneGraph();
        instance.cloneGraph(instance.init());
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    };
}
