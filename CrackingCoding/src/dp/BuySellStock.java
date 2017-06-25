/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dp;

import arrays.ArrayUtil;
import java.util.Scanner;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many
 * transactions as you like (ie, buy one and sell one share of the stock
 * multiple times). However, you may not engage in multiple transactions at the
 * same time (ie, you must sell the stock before you buy again).
 *
 * Input: [7, 1, 5, 3, 6, 4] Output: 7 = 5 - 1 + 6 - 3
 *
 *
 *
 * Input: [7, 6, 4, 3, 1]
 *
 * @author vasher
 */
public class BuySellStock {

    public int maxProfit(int[] prices) {
        int maxProfit1 = 0;
        int maxProfit2 = 0;
        int diff = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                diff += prices[i] - prices[i - 1];
            } else {
                if (diff > maxProfit2 || diff > maxProfit1) {
                    if (maxProfit1 < maxProfit2) {
                        maxProfit1 = maxProfit2;
                        maxProfit2 = 0;
                    }
                    if (diff > maxProfit2) {
                        maxProfit2 = diff;
                    }
                }
                diff = 0;
            }
        }
        if (diff > maxProfit2 || diff > maxProfit1) {
            if (maxProfit1 < maxProfit2) {
                maxProfit1 = maxProfit2;
                maxProfit2 = 0;
            }
            if (diff > maxProfit2) {
                maxProfit2 = diff;
            }
        }
        return maxProfit1 + maxProfit2;
    }

    public static void main(String[] args) {
        BuySellStock bss = new BuySellStock();
        System.out.println("Buy Sell Stock: Maximum Profit Calculator");
        Scanner sc = new Scanner(System.in);
//        int[] prices = ArrayUtil.readArray();
//        int[] prices = {7, 1, 5, 17, 8, 12};
        int[] prices = {1,2,4,2,5,7,2,4,9,0};
        System.out.println(bss.maxProfit(prices));
    }

}
