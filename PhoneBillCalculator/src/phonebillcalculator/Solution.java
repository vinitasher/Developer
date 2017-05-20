/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebillcalculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 *
 * @author vasher
 */
public class Solution {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String input = "23:58:08,400-234-090\n23:59:01,701-080-080\n23:59:00,400-234-091\n23:59:00,400-234-092\n23:59:00,400-234-093\n23:59:00,400-234-094\n23:59:00,400-234-095\n23:59:00,400-234-096\n23:59:00,400-234-097\n23:59:00,400-234-098\n23:59:00,400-234-099";
        Scanner sc = new Scanner(System.in);
        System.out.println(solution(sc.next()));
//        System.out.println(solution(input));
        
    }

    public static int solution(String S) {
        Map<String, Integer> callLog = new HashMap<String, Integer>();
        String lines[] = S.split("\\r?\\n");
        for (int i = 0; i < lines.length; i++) {
            String[] logs = lines[i].split(",");
            int seconds = timeInSeconds(logs[0]);
            String phoneNumber = logs[1];
            if(!callLog.containsKey(phoneNumber)){
                callLog.put(phoneNumber, seconds);
            } else {
                callLog.put(phoneNumber, callLog.get(phoneNumber)+seconds);
            }
        }
        List<Entry<String,Integer>> sortedEntries = new ArrayList<Entry<String,Integer>>(callLog.entrySet());

        Collections.sort(sortedEntries, 
                new Comparator<Entry<String,Integer>>() {
                    @Override
                    public int compare(Entry<String,Integer> e1, Entry<String,Integer> e2) {
                        int value = e2.getValue().compareTo(e1.getValue());
                        if(value == 0){
                            return comparePhoneNumbers(e1.getKey(), e2.getKey());
                        }
                        return value;
                }
                }
        );
        
        int billAmount = 0;
        for(int i=0; i<sortedEntries.size(); i++){
            if(i == 0){
                continue;
            }
            Entry<String, Integer> entry = sortedEntries.get(i);
            int seconds = entry.getValue();
            if(seconds < 300){
                billAmount += seconds*3;
            } else {
                billAmount += (seconds/60)*150;
                if(seconds%60 > 0){
                    billAmount += 150;
                }
            }
        }
        return billAmount;
    }

    public static int timeInSeconds(String time) {
        String[] h1 = time.split(":");

        int hour = Integer.parseInt(h1[0]);
        int minute = Integer.parseInt(h1[1]);
        int second = Integer.parseInt(h1[2]);

        int temp;
        temp = second + (60 * minute) + (3600 * hour);
        return temp;
    }
    
    public static int comparePhoneNumbers(String p1, String p2){
        int p1int = Integer.parseInt(p1.replaceAll("[-]", ""));
        int p2int = Integer.parseInt(p2.replaceAll("[-]", ""));
        return p1int - p2int;
    }

}
