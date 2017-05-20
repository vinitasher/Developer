/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author vasher
 */
public class GraphUtil {
    
    public static HashMap<String, ArrayList<Node>> sampleDirectionalGraph(){
        HashMap<String,ArrayList<Node>> map = new HashMap<>();
        ArrayList<Node> list = new ArrayList<Node>();
        list.add(new Node("B"));
        list.add(new Node("D"));
        map.put("A", list);
        list = new ArrayList<Node>();
        list.add(new Node("C"));
        list.add(new Node("D"));
        map.put("B", list);
        list = new ArrayList<Node>();
        map.put("C", list);
        map.put("D", list);
        list = new ArrayList<Node>();
        list.add(new Node("A"));
        list.add(new Node("C"));
        list.add(new Node("D"));
        map.put("E", list);
        return map;
    }
    
}
