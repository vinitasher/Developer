package graphs.util;

import java.util.HashMap;
import java.util.Map;

public class GraphNode {


    String label;


    Map<String, Double> neighbors;

    public GraphNode(String label) {
        this.label = label;
        this.neighbors = new HashMap<>();
    }

    public void addNeighbor(GraphNode g, double edgeWeight) {
        neighbors.put(g.label, edgeWeight);
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Map<String, Double> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(Map<String, Double> neighbors) {
        this.neighbors = neighbors;
    }

}
