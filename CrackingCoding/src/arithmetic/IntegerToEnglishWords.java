/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arithmetic;

import io.IOUtil;
import java.util.HashMap;

/**
 *
 * @author vasher Convert a non-negative integer to its english words
 * representation. Given input is guaranteed to be less than 231 - 1.
 *
 * For example, 123 -> "One Hundred Twenty Three" 12345 -> "Twelve Thousand
 * Three Hundred Forty Five" 1234567 -> "One Million Two Hundred Thirty Four
 * Thousand Five Hundred Sixty Seven"
 *
 */
public class IntegerToEnglishWords {

    HashMap<Long, String> ones = new HashMap<>();
    HashMap<Long, String> tens = new HashMap<>();
    HashMap<Long, String> teens = new HashMap<>();
    HashMap<Long, String> power = new HashMap<>();

    public void buildMap() {
        ones.put(1L, "One");
        ones.put(2L, "Two");
        ones.put(3L, "Three");
        ones.put(4L, "Four");
        ones.put(5L, "Five");
        ones.put(6L, "Six");
        ones.put(7L, "Seven");
        ones.put(8L, "Eight");
        ones.put(9L, "Nine");

        tens.put(1L, "Ten");
        tens.put(2L, "Twenty");
        tens.put(3L, "Thirty");
        tens.put(4L, "Forty");
        tens.put(5L, "Fifty");
        tens.put(6L, "Sixty");
        tens.put(7L, "Seventy");
        tens.put(8L, "Eighty");
        tens.put(9L, "Ninety");

        teens.put(11L, "Eleven");
        teens.put(12L, "Twelve");
        teens.put(13L, "Thirteen");
        teens.put(14L, "Fourteen");
        teens.put(15L, "Fifteen");
        teens.put(16L, "Sixteen");
        teens.put(17L, "Seventeen");
        teens.put(18L, "Eighteen");
        teens.put(19L, "Nineteen");

        power.put(2L, "Hundred");
        power.put(3L, "Thousand");
        power.put(6L, "Million");
        power.put(9L, "Billion");
    }

    public StringBuffer numberToWordsRecursive(long num) {
        if (ones.isEmpty()) {
            buildMap();
        }
        StringBuffer result = new StringBuffer();
        if (num >= Math.pow(10, 9)) {
            result.append(numberToWordsRecursive(num / (long) Math.pow(10, 9)));
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(power.get(9L));
            num = num % (long) Math.pow(10, 9);
        }
        if (num >= Math.pow(10, 6)) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(numberToWordsRecursive(num / (long) Math.pow(10, 6)));
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(power.get(6L));
            num = num % (long) Math.pow(10, 6);
        }
        if (num >= Math.pow(10, 3)) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(numberToWordsRecursive(num / (long) Math.pow(10, 3)));
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(power.get(3L));
            num = num % (long) Math.pow(10, 3);
        }
        if (num >= Math.pow(10, 2)) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(numberToWordsRecursive(num / (long) Math.pow(10, 2)));
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(power.get(2L));
            num = num % (long) Math.pow(10, 2);
        }
        if (num > 9 && num < 100) {
            if (num > 10 && num < 20) {
                if (result.length() > 0) {
                    result.append(" ");
                }
                result.append(teens.get(num));
            } else if (num / 10 > 0) {
                if (result.length() > 0) {
                    result.append(" ");
                }
                result.append(tens.get(num / 10));
                result.append(" ");
                result.append(numberToWordsRecursive(num % 10));
            }
        }
        if (num > 0 && num < 9) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(ones.get(num));
        }
        return result;
    }

    public String numberToWords(long num) {
        if (num == 0) {
            System.out.println("Zero");
        }
        return numberToWordsRecursive(num).toString();
    }

    public static void main(String[] args) {
        IntegerToEnglishWords instance = new IntegerToEnglishWords();
        while (true) {
            long input = IOUtil.readLong(
                    "Enter long to be converted to words: ");
            System.out.println(instance.numberToWords(input));
        }
    }

}
