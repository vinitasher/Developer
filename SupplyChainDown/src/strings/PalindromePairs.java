//package strings;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.PriorityQueue;
//
///**
// * Given a string s, return all the palindromic permutations (without duplicates) of it.
// * Return an empty list if no palindromic permutation could be form.
// *
// * Example 1:
// *
// * Input: "aabb"
// * Output: ["abba", "baab"]
// * Example 2:
// *
// * Input: "abc"
// * Output: []
// */
//public class PalindromePairs {
//
//    public List<String> generatePalindromes(String s) {
//        Map<Character, Integer> map = new HashMap<>();
//        List<String> result = new ArrayList<>();
//        List<String> list = new ArrayList<>();
//        for(char c: s.toCharArray()){
//            map.put(c, map.getOrDefault(c, 0) + 1);
//        }
//
//        StringBuffer center = new StringBuffer();
//
//        if(map.entrySet().stream().filter(e -> e.getValue()%2 == 1).count() > 1){
//            return new ArrayList<>();
//        } else if(map.entrySet().stream().filter(e -> e.getValue()%2 == 1).count() == 1){
//            Map.Entry<Character, Integer> entry = map.entrySet().stream().filter(e -> e.getValue()%2 == 1).findFirst().get();
//            center.append(entry.getKey());
//            if(entry.getValue() > 1){
//                map.put(entry.getKey(), entry.getValue() - 1);
//            } else {
//                map.remove(entry.getKey());
//            }
//
//        }
//
//        generatePalindromesUtil(list, map, result, center.toString());
//
//    }
//
//    public void generatePalindromesUtil(List<String> list, Map<Character, Integer> map, List<String> result, String center){
//        List<String> newList = new ArrayList<>();
//        Map.Entry<Character, Integer> e = map.entrySet().stream().findFirst().get();
//        if(e.getValue() > 2){
//            map.put(e.getKey(), map.get(e.getValue()) - 2);
//        }
//        if(list.isEmpty()){
//            newList.add(e.getKey()+"");
//        } else {
//            for(String s: list){
//                StringBuilder sb = new StringBuilder(s);
//                for(int i=0; i<sb.length(); i++){
//                    //sb.append
//                }
//            }
//        }
//    }
//
//    public List<String> getNewList(List<String> list, Character c){
//        List<String> newList = new ArrayList<>();
//        if(list.isEmpty()) {
//            newList.add(c+"");
//            return newList;
//        }
//
//    }
//
//    class Node implements Comparable<Node>{
//        char val;
//        int count;
//
//        Node(char val){
//            this.val = val;
//            this.count = 1;
//        }
//
//        @Override
//        public int compareTo(Node o) {
//            return this.count - o.count;
//        }
//    }
//
//}
