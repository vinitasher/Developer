package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to},
 * reconstruct the itinerary in order.
 *
 * All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
 *
 * Note:
 *
 * If there are multiple valid itineraries,
 * you should return the itinerary that has the smallest lexical order when read as a single string.
 *
 * For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * Example 1:
 *
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * Example 2:
 *
 * Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
 *              But it is larger in lexical order.
 */
public class ReconstructItinerary {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, List<String>> destMap = new HashMap<>();
        for(int i=0; i<tickets.length; i++) {
            if(!destMap.containsKey(tickets[i][0])){
                List<String> destination = new ArrayList<>();
                destination.add(tickets[i][1]);
                destMap.put(tickets[i][0], destination);
                continue;
            }
            destMap.get(tickets[i][0]).add(tickets[i][1]);
        }

        for(Map.Entry<String, List<String>> entry: destMap.entrySet()) {
            entry.getValue().sort(String::compareTo);
        }

        List<String> result = new ArrayList<>();
        int num = 1;
        int total = tickets.length + 1;
        traverseUsingDFS(destMap, "JFK", result, total, num);
        return result;
    }

    public boolean traverseUsingDFS(Map<String, List<String>> destMap, String start, List<String> result, int total, int num) {
        result.add(start);
        if(num >= total){
            return true;
        }
        if(!destMap.containsKey(start)){
            return false;
        }
        List<String> destinations = destMap.get(start);
        if(destinations == null || destinations.size() == 0) {
            return false;
        }
        int i = 0;
        while(i < destinations.size()){
            String dest = destinations.get(i);
            destMap.get(start).remove(dest);
            if(destMap.get(start).size() == 0) {
                destMap.remove(start);
            }
            if(traverseUsingDFS(destMap, dest, result, total, num + 1)){
                return true;
            }
            if(!destMap.containsKey(start)){
                List<String> dl = new ArrayList<>();
                dl.add(dest);
                destMap.put(start, dl);
            } else {
                destMap.get(start).add(dest);
                destMap.get(start).sort(String::compareTo);
            }
            result.remove(result.size() - 1);
            i++;
        }
        return false;
    }

    public static void main(String[] args) {
        ReconstructItinerary instance = new ReconstructItinerary();
        String[][] tickets = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
        System.out.println(instance.findItinerary(tickets));
    }

}
