/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author vasher
 */
public class GraphUtil {

    public static HashMap<String, ArrayList<Node>> sampleDirectionalGraph() {
        HashMap<String, ArrayList<Node>> map = new HashMap<>();
        ArrayList<Node> list = new ArrayList<Node>();
        list.add(new Node("B"));
        list.add(new Node("D"));
        map.put("A", list);
        list = new ArrayList<Node>();
        list.add(new Node("C"));
        list.add(new Node("D"));
        map.put("B", list);
        list = new ArrayList<Node>();
        map.put("C", list);
        map.put("D", list);
        list = new ArrayList<Node>();
        list.add(new Node("A"));
        list.add(new Node("C"));
        list.add(new Node("D"));
        map.put("E", list);
        return map;
    }

    public static Graph sampleGraph() {
        GraphNode A = new GraphNode("A");
        GraphNode B = new GraphNode("B");
        GraphNode C = new GraphNode("C");
        GraphNode D = new GraphNode("D");
        GraphNode E = new GraphNode("E");
        GraphNode F = new GraphNode("F");

        GraphNode[] a = {B, C};
        ArrayList<GraphNode> adj = new ArrayList(Arrays.asList(a));
        A.setAdjacentNodes(adj);

        GraphNode[] b = {A, F, D};
        adj = new ArrayList(Arrays.asList(b));
        B.setAdjacentNodes(adj);

        GraphNode[] c = {A, B, F, E};
        adj = new ArrayList(Arrays.asList(c));
        C.setAdjacentNodes(adj);
        
        GraphNode[] d = {B, F};
        adj = new ArrayList(Arrays.asList(d));
        D.setAdjacentNodes(adj);
        
        GraphNode[] e = {C, F};
        adj = new ArrayList(Arrays.asList(e));
        E.setAdjacentNodes(adj);
        
        GraphNode[] f = {D, C, E};
        adj = new ArrayList(Arrays.asList(f));
        F.setAdjacentNodes(adj);
        
        Graph g = new Graph();
        g.addNode(A);
        g.addNode(B);
        g.addNode(C);
        g.addNode(D);
        g.addNode(E);
        g.addNode(F);
        
        return g;
    }

}
