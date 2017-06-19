/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

/**
 *
 * @author vasher
 */
public class DepthFirstSearch {
    
    public void depthFirstSearch(GraphNode node){
        if(!node.isVisited()){
            node.visit();
            System.out.println(node);
            for(GraphNode adj: node.getAdjacentNodes()){
                depthFirstSearch(adj);
            }
        }
    }
    
    public static void main(String[] args){
        DepthFirstSearch dfs = new DepthFirstSearch();
        Graph g = GraphUtil.sampleGraph();
        dfs.depthFirstSearch(g.getNodes().get(0));
    }
    
}
