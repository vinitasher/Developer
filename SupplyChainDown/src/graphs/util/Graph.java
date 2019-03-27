package graphs.util;

import java.util.List;
import java.util.Map;

public class Graph {

    public Map<Vertex, List<Vertex>> adjacencyMap;

    public Graph(){}

    public Graph(Map<Vertex, List<Vertex>> adjacencyMap){
        this.adjacencyMap = adjacencyMap;
    }

}
