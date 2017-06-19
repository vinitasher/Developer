/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import java.util.List;

/**
 *
 * @author vasher
 */
public class GraphNode {

    public GraphNode(String value, boolean visited, List<GraphNode> adjacentNodes) {
        this.value = value;
        this.visited = visited;
        this.adjacentNodes = adjacentNodes;
    }
    
    public GraphNode(String value){
        this.value = value;
    }
    
    public boolean isVisited(){
        return this.visited;
    }
    
    public void visit(){
        this.visited = true;
    }
    
    public List<GraphNode> getAdjacentNodes(){
        return this.adjacentNodes;
    }
    
    public void setAdjacentNodes(List<GraphNode> nodes){
        this.adjacentNodes = nodes;
    }
    
    @Override
    public String toString(){
        return this.value;
    }
    
    private String value;
    private boolean visited;
    private List<GraphNode> adjacentNodes;
    
}
