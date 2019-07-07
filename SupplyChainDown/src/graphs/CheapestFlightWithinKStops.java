package graphs;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * There are n cities connected by m flights. Each fight starts from city u and arrives at v with a price w.
 *
 * Now given all the cities and flights, together with starting city src and the destination dst,
 * your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.
 *
 * Example 1:
 * Input:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 1
 * Output: 200
 * Explanation:
 * The graph looks like this:
 *
 *
 * The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
 * Example 2:
 * Input:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 0
 * Output: 500
 * Explanation:
 * The graph looks like this:
 *
 *
 * The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.
 * Note:
 *
 * The number of nodes n will be in range [1, 100], with nodes labeled from 0 to n - 1.
 * The size of flights will be in range [0, n * (n - 1) / 2].
 * The format of each flight will be (src, dst, price).
 * The price of each flight will be in the range [1, 10000].
 * k is in the range of [0, n - 1].
 * There will not be any duplicated flights or self cycles.
 */
public class CheapestFlightWithinKStops {
    public static final int SRC = 0;
    public static final int DEST = 1;
    public static final int COST = 2;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        Map<Integer, Map<Integer, Integer>> flightMap = new HashMap<>();
        for (int[] f : flights) {
            if (!flightMap.containsKey(f[SRC])) flightMap.put(f[SRC], new HashMap<>());
            flightMap.get(f[SRC]).put(f[DEST], f[COST]);
        }

        PriorityQueue<Destination> pq = new PriorityQueue<>();

        pq.add(new Destination(0, src, K));

        //BFS kind of
        while(!pq.isEmpty()){
            Destination d = pq.poll();
            if(dst == d.city) {
                return d.cost;
            }
            if(d.stopsLeft >= 0){
                for(Map.Entry<Integer, Integer> entry: flightMap.getOrDefault(d.city, new HashMap<>()).entrySet()){
                    pq.add(new Destination(d.cost + entry.getValue(), entry.getKey().intValue(), d.stopsLeft - 1));
                }
            }
        }

        return -1;
    }

    public class Destination implements Comparable<Destination> {
        public int cost;
        public int city;
        public int stopsLeft;

        public Destination(int cost, int city, int stopsLeft) {
            this.cost = cost;
            this.city = city;
            this.stopsLeft = stopsLeft;
        }

        @Override
        public int compareTo(Destination o) {
            return this.cost - o.cost;
        }
    }
}
