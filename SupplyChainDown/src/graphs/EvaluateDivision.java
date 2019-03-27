package graphs;

import graphs.util.GraphNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Equations are given in the format A / B = k, where A and B are variables represented as strings,
 * and k is a real number (floating point number). Given some queries, return the answers.
 *
 * If the answer does not exist, return -1.0.
 *
 * Example:
 * Given a / b = 2.0, b / c = 3.0.
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 * return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 *
 * The input is:
 * vector<pair<string, string>> equations,
 * vector<double>& values,
 * vector<pair<string, string>> queries ,
 *
 * where equations.size() == values.size(), and the values are positive.
 *
 * This represents the equations. Return vector<double>.
 *
 * According to the example above:
 *
 * equations = [ ["a", "b"], ["b", "c"] ],
 * values = [2.0, 3.0],
 * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 * The input is always valid.
 * You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
 */
public class EvaluateDivision {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, GraphNode> graph = new HashMap<>();
        double[] result = new double[queries.length];

        for(int i = 0; i < equations.length; i++) {
            GraphNode source = graph.get(equations[i][0]);
            if(source == null){
                source = new GraphNode(equations[i][0]);
            }
            GraphNode dest = graph.get(equations[i][1]);
            if(dest == null){
                dest = new GraphNode(equations[i][1]);
            }
            source.addNeighbor(dest, values[i]);
            dest.addNeighbor(source, 1.0/values[i]);
            graph.put(source.getLabel(), source);
            graph.put(dest.getLabel(), dest);
        }

        for(int i = 0; i < queries.length; i++) {
            GraphNode source = graph.get(queries[i][0]);
            GraphNode dest = graph.get(queries[i][1]);
            if(source == null || dest == null){
                result[i] = -1.0;
                continue;
            }
            Set<String> visitedNodes = new HashSet<>();
            result[i] = depthFirstSearch(graph, source, dest, visitedNodes, 1.0);
        }
        return result;
    }

    public double depthFirstSearch(Map<String, GraphNode> graph, GraphNode source, GraphNode dest, Set<String> visitedNodes, double cost) {
        for(Map.Entry<String, Double> entry : source.getNeighbors().entrySet()) {
            if(entry.getKey().equals(dest.getLabel())){
                return cost * entry.getValue();
            }
            if(!visitedNodes.contains(entry.getKey())) {
                visitedNodes.add(entry.getKey());
                double result = depthFirstSearch(graph, graph.get(entry.getKey()), dest, visitedNodes, cost * entry.getValue());
                if(result != -1){
                    return result;
                }
            }
        }
        return -1.0;
    }

    public static void main(String[] args) {
        EvaluateDivision instance = new EvaluateDivision();
        String[][] equations = {{"a", "b"}, {"b", "c"}};
        double[] values = {2.0, 3.0};
        String[][] queries = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
        System.out.println(Arrays.toString(instance.calcEquation(equations, values, queries)));

    }
}
