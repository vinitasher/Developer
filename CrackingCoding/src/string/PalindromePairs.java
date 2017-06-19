/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author vasher
 */
public class PalindromePairs {

    HashMap<String, ArrayList<Integer>> wordsMap;
    Set<List<String>> outputSet;

    private void generateMap(String[] input) {
        wordsMap = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            String reverse = StringUtil.reverse(input[i]);
            if (wordsMap.containsKey(reverse)) {
                ArrayList<Integer> list = wordsMap.get(reverse);
                list.add(i);
                wordsMap.put(reverse, list);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                wordsMap.put(reverse, list);
            }
        }
    }

    public Set<List<String>> checkPalindromePairs(String[] input) {
        outputSet = new HashSet<>();
        generateMap(input);
        for (int i = 0; i < input.length; i++) {
            String str = input[i];
            for (int j = 0; j <= str.length(); j++) {
                String prefix = str.substring(0, j);
                String postfix = str.substring(j);
                if (StringUtil.isPalindrome(postfix) && wordsMap.containsKey(prefix)) {
                    if(!str.equals(StringUtil.reverse(prefix)) || wordsMap.get(prefix).size() > 1) {
                        for (Integer index : wordsMap.get(prefix)) {
                            List<String> list = new ArrayList<>();
                            list.add(str);
                            list.add(input[index]);
                            outputSet.add(list);
                        }
                    }
                } else if (StringUtil.isPalindrome(prefix) && wordsMap.containsKey(postfix)) {
                    if(!str.equals(StringUtil.reverse(postfix)) || wordsMap.get(postfix).size() > 1) {
                        for (Integer index : wordsMap.get(postfix)) {
                            List<String> list = new ArrayList<>();
                            list.add(str);
                            list.add(input[index]);
                            outputSet.add(list);
                        }
                    }
                }
            }
        }
        return outputSet;
    }

    public static void main(String[] args) {
        PalindromePairs pp = new PalindromePairs();
        String[] input = {"abc", "cba", "c", "c", "dedcba", "bab", ""};
        Set<List<String>> set = pp.checkPalindromePairs(input);
        for (List<String> pair : set) {
            System.out.println(pair);
        }
    }

}
