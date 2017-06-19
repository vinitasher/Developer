/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author vasher
 */
public class BreadthFirstSearch {
    
    Queue<GraphNode> queue;
    
    public void breadthFirstSearch(GraphNode root){
        queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            GraphNode n = queue.poll();
            if(!n.isVisited()){
                n.visit();
                queue.addAll(n.getAdjacentNodes());
                System.out.println(n);
            }
        }
    }
    
    public static void main(String[] args){
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        Graph g = GraphUtil.sampleGraph();
        bfs.breadthFirstSearch(g.getNodes().get(0));
    }
}
