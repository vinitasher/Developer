package graphs;

import graphs.util.Graph;
import graphs.util.Vertex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DepthFirstSearch {

    Set<Vertex> visitedVertices = new HashSet<>();
    Set<Vertex> remainingVertices = new HashSet<>();
    public void traverseDisjointGraphUsingDFS(Graph g, Vertex v){
        //StringBuffer bf = new StringBuffer();
        if(g == null)
            return;
        if(v == null)
            return;

        if(!visitedVertices.contains(v)){
            System.out.println(v.value+"\t");
            visitedVertices.add(v);
            remainingVertices.remove(v);
            for(Vertex neighborOfV : g.adjacencyMap.get(v)){
                traverseDisjointGraphUsingDFS(g, neighborOfV);
            }
        }

        if(!remainingVertices.isEmpty()){
            Iterator<Vertex> iv = remainingVertices.iterator();
            while(iv.hasNext()){
                Vertex vr = iv.next();
                traverseDisjointGraphUsingDFS(g, vr);
            }
        }
    }

    public StringBuffer traverseGraphUsingDFS(Graph g, Vertex v){
        StringBuffer bf = new StringBuffer();
        if(g == null)
            return bf;
        if(v == null)
            return bf;

        if(!visitedVertices.contains(v)){
            bf.append(v.value+" ");
            visitedVertices.add(v);
            for(Vertex neighborOfV : g.adjacencyMap.get(v)){
                bf.append(traverseGraphUsingDFS(g, neighborOfV));
            }
        }
        return bf;
    }

    public static void main(String[] args) {
        DepthFirstSearch dfs = new DepthFirstSearch();
        Graph g = new Graph();

        Map<Vertex, List<Vertex>> adjMap = new HashMap<>();
        Vertex vertex0 = new Vertex(0);
        Vertex vertex1 = new Vertex(1);
        Vertex vertex2 = new Vertex(2);
        Vertex vertex3 = new Vertex(3);

        List<Vertex> neighbors0 = new ArrayList<>();
        neighbors0.add(vertex1);
        neighbors0.add(vertex2);
        adjMap.put(vertex0, neighbors0);

        List<Vertex> neighbors1 = new ArrayList<>();
        neighbors1.add(vertex2);
        adjMap.put(vertex1, neighbors1);

        List<Vertex> neighbors2 = new ArrayList<>();
        neighbors2.add(vertex0);
//        neighbors2.add(vertex3);
        adjMap.put(vertex2, neighbors2);

        List<Vertex> neighbors3 = new ArrayList<>();
        neighbors3.add(vertex3);
        adjMap.put(vertex3, neighbors3);

        g.adjacencyMap = adjMap;
        dfs.remainingVertices = new HashSet<>(g.adjacencyMap.keySet());
        dfs.traverseDisjointGraphUsingDFS(g, vertex2);
    }
}
