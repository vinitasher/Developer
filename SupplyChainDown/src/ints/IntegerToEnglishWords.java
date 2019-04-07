package ints;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Convert a non-negative integer to its english words representation.
 * Given input is guaranteed to be less than 2^31 - 1.
 *
 * Example 1:
 *
 * Input: 123
 * Output: "One Hundred Twenty Three"
 * Example 2:
 *
 * Input: 12345
 * Output: "Twelve Thousand Three Hundred Forty Five"
 * Example 3:
 *
 * Input: 1234567
 * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * Example 4:
 *
 * Input: 1234567891
 * Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 */
public class IntegerToEnglishWords {
    Map<Integer, String> unitMap = new HashMap<>();
    Map<Integer, String> numMap = new HashMap<>();
    List<Integer> unitList = new ArrayList<>();

    public void initMap() {
        unitMap.put(2, "Hundred");
        unitMap.put(3, "Thousand");
        unitMap.put(6, "Million");
        unitMap.put(9, "Billion");

        unitList.add(9);
        unitList.add(6);
        unitList.add(3);
        unitList.add(2);

        //numMap.put(0, "Zero");
        numMap.put(1, "One");
        numMap.put(2, "Two");
        numMap.put(3, "Three");
        numMap.put(4, "Four");
        numMap.put(5, "Five");
        numMap.put(6, "Six");
        numMap.put(7, "Seven");
        numMap.put(8, "Eight");
        numMap.put(9, "Nine");
        numMap.put(10, "Ten");
        numMap.put(11, "Eleven");
        numMap.put(12, "Twelve");
        numMap.put(13, "Thirteen");
        numMap.put(14, "Fourteen");
        numMap.put(15, "Fifteen");
        numMap.put(16, "Sixteen");
        numMap.put(17, "Seventeen");
        numMap.put(18, "Eighteen");
        numMap.put(19, "Nineteen");
        numMap.put(20, "Twenty");
        numMap.put(30, "Thirty");
        numMap.put(40, "Forty");
        numMap.put(50, "Fifty");
        numMap.put(60, "Sixty");
        numMap.put(70, "Seventy");
        numMap.put(80, "Eighty");
        numMap.put(90, "Ninety");

    }

    public String numberToWords(int num) {
        if(unitMap.size() == 0){
            initMap();
        }
        if(num == 0) {
            return "Zero";
        }
        StringBuffer sb = new StringBuffer();
        sb = numberToWordsRecursive(num, sb, '.');
        return sb.toString();
    }

    public StringBuffer numberToWordsRecursive(int num, StringBuffer sb, char lastChar){
        if(num < 100) {
            if(numMap.containsKey(num)) {
                if(sb.length() > 0) sb.append(" ");
                sb.append(numMap.get(num));
            } else {
                if(num - num % 10 != 0) {
                    if(sb.length() > 0 && lastChar != ' ') sb.append(" ");
                    sb = numberToWordsRecursive(num - num % 10, sb, ' ');
                }
                if(num % 10 != 0) {
                    if(sb.length() > 0 && lastChar != ' ') sb.append(" ");
                    sb = numberToWordsRecursive(num % 10, sb, ' ');
                }
            }
        } else {
            for(Integer i: unitList) {
                if(num >= (int)Math.pow(10, i)) {
                    int a = num / (int) Math.pow(10, i);
                    num = num - a * (int) Math.pow(10, i);
                    if(a > 0 && sb.length() > 0 && lastChar != ' ') sb.append(" ");
                    sb = numberToWordsRecursive(a, sb, ' ');
                    if(sb.length() > 0) sb.append(" ");
                    sb.append(unitMap.get(i));
                }
            }
            if(num > 0 && sb.length() > 0 && lastChar != ' ') sb.append(" ");
            sb = numberToWordsRecursive(num , sb, ' ');
        }
        return sb;
    }

    public static void main(String[] args) {
        IntegerToEnglishWords instance = new IntegerToEnglishWords();
        int num = ThreadLocalRandom.current().nextInt(0, (int)Math.pow(10, 10));
        //num = 100;
        System.out.println(num);
        System.out.println(instance.numberToWords(num));
    }
}
