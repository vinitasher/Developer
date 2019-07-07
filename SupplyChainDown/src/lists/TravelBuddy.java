package lists;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;


/**
 * WaterLunchAndBath
 * 5 Travel Buddy
 *
 * I have a wish list of cities that I want to visit to,
 * my friends also have city wish lists that they want to visit to.
 * If one of my friends share more than 50% (over his city count in his wish list), he is my buddy.
 *
 * Given a list of city wish list, output buddy list sorting by similarity.
 */

public class TravelBuddy {

    public class Friend implements Comparable<Friend> {
        String name;
        double match;
        double total;

        public Friend(String name, double match, double total){
            this.name = name;
            this.match = match;
            this.total = total;
        }

        @Override
        public int compareTo(Friend o) {
            return (int)(this.match/this.total - o.match/o.total);
        }
    }



    public List<String> getTravelBuddies(Set<String> myWishList, Map<String, Set<String>> friendWishLists){
        Map<String, Set<String>> cityBuddiesMap = new HashMap<>();
        Map<String, Integer> buddySimilarityMap = new HashMap<>();
        for(String city: myWishList){
            cityBuddiesMap.put(city, new HashSet<>());
            for(String friend: friendWishLists.keySet()){
                if(friendWishLists.get(friend).contains(city)){
                    cityBuddiesMap.get(city).add(friend);
                    buddySimilarityMap.put(friend, buddySimilarityMap.getOrDefault(friend, 0) + 1);
                }
            }
        }

        PriorityQueue<Friend> pq = new PriorityQueue<>();
        for(String buddy: buddySimilarityMap.keySet()){
            if((double)buddySimilarityMap.get(buddy)/(double)friendWishLists.get(buddy).size() > 0.5){
                pq.add(new Friend(buddy, buddySimilarityMap.get(buddy), friendWishLists.get(buddy).size()));
            }
        }

        List<String> result = new ArrayList<>();
        while(!pq.isEmpty()){
            result.add(pq.poll().name);
        }
        return result;
    }

//    public static void main(String[] args){
//        Set<String> myWishList = new HashSet<>(Arrays.asList(new String[]{"a", "b", "c", "d"}));
//        Set<String> wishList1 = new HashSet<>(Arrays.asList(new String[]{"a", "b", "e", "f"}));
//        Set<String> wishList2 = new HashSet<>(Arrays.asList(new String[]{"a", "c", "d", "g"}));
//        Set<String> wishList3 = new HashSet<>(Arrays.asList(new String[]{"c", "f", "e", "g"}));
//        Map<String, Set<String>> friendWishLists = new HashMap<>();
//        friendWishLists.put("Buddy1", wishList1);
//        friendWishLists.put("Buddy2", wishList2);
//        friendWishLists.put("Buddy3", wishList3);
//        List<String> result = new TravelBuddy().getTravelBuddies(myWishList, friendWishLists);
//        assertEquals(3, result.size());
//        assertEquals("g", result.get(0));
//        assertEquals("e", result.get(1));
//        assertEquals("f", result.get(2));
//
//    }

//    public static class UnitTest {
//        @Test
//        public void test1() {
//            Set<String> myWishList = new HashSet<>(Arrays.asList(new String[]{"a", "b", "c", "d"}));
//            Set<String> wishList1 = new HashSet<>(Arrays.asList(new String[]{"a", "b", "e", "f"}));
//            Set<String> wishList2 = new HashSet<>(Arrays.asList(new String[]{"a", "c", "d", "g"}));
//            Set<String> wishList3 = new HashSet<>(Arrays.asList(new String[]{"c", "f", "e", "g"}));
//            Map<String, Set<String>> friendWishLists = new HashMap<>();
//            friendWishLists.put("Buddy1", wishList1);
//            friendWishLists.put("Buddy2", wishList2);
//            friendWishLists.put("Buddy3", wishList3);
//            List<String> res= new TravelBuddy().getTravelBuddies(myWishList, friendWishLists);
//            assertEquals(3, res.size());
//            assertEquals("g", res.get(0));
//            assertEquals("e", res.get(1));
//            assertEquals("f", res.get(2));
//        }
//    }
}
