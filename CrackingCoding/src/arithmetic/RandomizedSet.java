/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arithmetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author vasher Design a data structure that supports all following operations
 * in average O(1) time.
 *
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present. getRandom: Returns
 * a random element from current set of elements. Each element must have the
 * same probability of being returned. Example:
 *
 * // Init an empty set. RandomizedSet randomSet = new RandomizedSet();
 *
 * // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomSet.insert(1);
 *
 * // Returns false as 2 does not exist in the set. randomSet.remove(2);
 *
 * // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomSet.insert(2);
 *
 * // getRandom should return either 1 or 2 randomly. randomSet.getRandom();
 *
 * // Removes 1 from the set, returns true. Set now contains [2].
 * randomSet.remove(1);
 *
 * // 2 was already in the set, so return false. randomSet.insert(2);
 *
 * // Since 2 is the only number in the set, getRandom always return 2.
 * randomSet.getRandom();
 */
public class RandomizedSet {

    List<Integer> arr;
    Map<Integer, Integer> map;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        arr = new ArrayList<>();
        map = new HashMap<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already
     * contain the specified element.
     * @param val
     * @return 
     */
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        int len = arr.size();
        map.put(val, len);
        arr.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the
     * specified element.
     * @param val
     * @return 
     */
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int position = map.get(val);
        int size = arr.size();
        arr.set(position, arr.get(size-1));
        if(!arr.isEmpty()){
            map.put(arr.get(position), position);
        }
        arr.remove(arr.size()-1);
        map.remove(val);
        return true;
    }

    /**
     * Get a random element from the set.
     * @return 
     */
    public int getRandom() {
        int random = 0;
        Random ran = new Random();
        random = ran.nextInt(arr.size());
        return arr.get(random);
    }

    public static void main(String[] args) {
        // Init an empty set.
        RandomizedSet randomSet = new RandomizedSet();

//        // Inserts 1 to the set. Returns true as 1 was inserted successfully.
//        System.out.println(randomSet.insert(3));
//        System.out.println(randomSet.insert(-2));
//        // Returns false as 2 does not exist in the set.
//        System.out.println(randomSet.remove(2));
//
//        // Inserts 2 to the set, returns true. Set now contains [1,2].
//        System.out.println(randomSet.insert(1));
//        System.out.println(randomSet.insert(-3));
//        System.out.println(randomSet.insert(-2));
//        //System.out.println(randomSet.insert(3));
//        System.out.println(randomSet.remove(-2));
//        System.out.println(randomSet.remove(3));
//        System.out.println(randomSet.insert(-1));
//        
//        System.out.println(randomSet.remove(-3));
//        System.out.println(randomSet.insert(1));
//        System.out.println(randomSet.insert(-2));
//        System.out.println(randomSet.insert(-2));
//        System.out.println(randomSet.insert(-2));
//        System.out.println(randomSet.insert(1));
//        // getRandom should return either 1 or 2 randomly.
//        System.out.println(randomSet.getRandom());
//        System.out.println(randomSet.insert(-2));
//        // Removes 1 from the set, returns true. Set now contains [2].
//        System.out.println(randomSet.remove(0));
//        System.out.println(randomSet.insert(-3));
//        System.out.println(randomSet.insert(1));
        // 2 was already in the set, so return false.
        
        
//        System.out.println(randomSet.remove(0));
//        System.out.println(randomSet.remove(0));
//        System.out.println(randomSet.insert(0));
//        System.out.println(randomSet.getRandom());
//        System.out.println(randomSet.remove(0));
//        System.out.println(randomSet.insert(0));

        System.out.println(randomSet.insert(3));
        System.out.println(randomSet.insert(3));
        System.out.println(randomSet.getRandom());
        System.out.println(randomSet.getRandom());
        System.out.println(randomSet.insert(1));
        System.out.println(randomSet.insert(3));
        System.out.println(randomSet.getRandom());
        System.out.println(randomSet.getRandom());
        System.out.println(randomSet.insert(0));
        System.out.println(randomSet.remove(0));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet(); boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val); int param_3 = obj.getRandom();
 */
