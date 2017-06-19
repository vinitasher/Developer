/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vasher
 */
public class Graph {
    
    private List<GraphNode> nodes;

    public Graph() {
        
    }
    
    public void addNode(GraphNode n){
        if(nodes == null){
            nodes = new ArrayList<GraphNode>();
        }
        nodes.add(n);
    }
    
    public List<GraphNode> getNodes(){
        return nodes;
    }
    
}
