package graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;

/**
 *
 * A group of friends went on holiday and sometimes lent each other money. For example, Alice paid for Bill's lunch for $10. Then later Chris gave Alice $5 for a taxi ride. We can model each transaction as a tuple (x, y, z) which means person x gave person y $z. Assuming Alice, Bill, and Chris are person 0, 1, and 2 respectively (0, 1, 2 are the person's ID), the transactions can be represented as [[0, 1, 10], [2, 0, 5]].
 *
 * Given a list of transactions between a group of people, return the minimum number of transactions required to settle the debt.
 *
 * Note:
 *
 * A transaction will be given as a tuple (x, y, z). Note that x ≠ y and z > 0.
 * Person's IDs may not be linear, e.g. we could have the persons 0, 1, 2 or we could also have the persons 0, 2, 6.
 * Example 1:
 *
 * Input:
 * [[0,1,10], [2,0,5]]
 *
 * Output:
 * 2
 *
 * Explanation:
 * Person #0 gave person #1 $10.
 * Person #2 gave person #0 $5.
 *
 * Two transactions are needed. One way to settle the debt is person #1 pays person #0 and #2 $5 each.
 * Example 2:
 *
 * Input:
 * [[0,1,10], [1,0,1], [1,2,5], [2,0,5]]
 *
 * Output:
 * 1
 *
 * Explanation:
 * Person #0 gave person #1 $10.
 * Person #1 gave person #0 $1.
 * Person #1 gave person #2 $5.
 * Person #2 gave person #0 $5.
 *
 * Therefore, person #1 only need to give person #0 $4, and all debt is settled.
 *
 */
public class OptimalAccountBalancing {
    static final int  LENDER = 0;
    static final int  BORROWER = 1;
    static final int  AMOUNT = 2;

    class Person implements Comparable<Person> {
        int value;
        int amount;

        Person(int value, int amount){
            this.amount = amount;
            this.value = value;
        }

        @Override
        public int compareTo(Person o) {
            return this.amount - o.amount;
        }
    }

    public int minTransfers(int[][] transactions) {
        if(transactions.length <= 1) return transactions.length;
        Map<Integer, Integer> persons= new HashMap<>();
        Map<Integer, List<Integer>> reverseMap = new HashMap<>();
        PriorityQueue<Person> lenders = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Person> borrowers = new PriorityQueue<>();
        int minTransfers = 0;

        int max = Integer.MIN_VALUE;

        for(int[] transaction: transactions) {
            int lender      = transaction[LENDER];
            int borrower    = transaction[BORROWER];
            int amount      = transaction[AMOUNT];

            persons.put(lender, persons.getOrDefault(lender, 0) + amount);
            persons.put(borrower, persons.getOrDefault(borrower, 0) - amount);
        }

        for(Integer person: persons.keySet()){
            Integer amount = persons.get(person);
            max = Math.max(max, Math.abs(amount));
            if(!reverseMap.containsKey(amount)) reverseMap.put(amount, new ArrayList<>());
            List<Integer> list = reverseMap.get(amount);
            list.add(person);
        }

        int[] arr = new int[max+1];
        for(Integer person: persons.keySet()){
            Integer amount = persons.get(person);
            if(amount > 0) arr[Math.abs(amount)]++;
            else if(amount < 0) arr[Math.abs(amount)]--;
        }

        for(int i=max; i>=0;) {
            if(arr[i] > 0) {
                int j = i-1;
                while(arr[j] >= 0 || arr[i-j] >= 0){
                    j--;
                }
                arr[i]--;
                arr[j]++;
                arr[i-j]++;
                minTransfers = minTransfers + 2;
            } else if(arr[i] < 0) {
                int j = i-1;
                while(arr[j] <= 0 || arr[i-j] <= 0){
                    j--;
                }
                arr[i]++;
                arr[j]--;
                arr[i-j]--;
                minTransfers = minTransfers + 2;
            } else {
                i--;
            }
        }

//        //exact match
//        for(Integer amount: reverseMap.keySet()){
//            if(amount > 0 && reverseMap.containsKey(amount * -1)){
//                persons.remove(reverseMap.get(amount).get(0));
//                persons.remove(reverseMap.get(amount*-1).get(0));
//                minTransfers++;
//            }
//        }

//        for(Integer person: persons.keySet()){
//            if(persons.get(person) > 0){
//                lenders.add(new Person(person, persons.get(person)));
//            } else {
//                borrowers.add(new Person(person, persons.get(person)));
//            }
//        }
//
//
//        List<Person> ignoreBorrowers = new ArrayList<>();
//        List<Person> ignoreLenders = new ArrayList<>();
//        newLoop: while(!lenders.isEmpty() && !borrowers.isEmpty()){
//
//            Person lender = lenders.poll();
//            Person borrower = borrowers.poll();
//
//            if(reverseMap.get(borrower.amount*-1 - lender.amount) == null || reverseMap.get(borrower.amount*-1 - lender.amount).isEmpty()){
//                ignoreBorrowers.add(borrower);
//                lenders.add(lender);
//                continue newLoop;
//            } else if(reverseMap.get(lender.amount + borrower.amount) == null || reverseMap.get(borrower.amount + lender.amount).isEmpty()){
//                ignoreLenders.add(lender);
//                borrowers.add(borrower);
//                continue newLoop;
//            }
//            borrowers.addAll(ignoreBorrowers);
//            lenders.addAll(ignoreLenders);
//            int transactionAmount = Math.min(lender.amount, Math.abs(borrower.amount));
//
//            lender.amount -= transactionAmount;
//            borrower.amount += transactionAmount;
//
//            if(lender.amount != 0) lenders.add(lender);
//            if(borrower.amount != 0) borrowers.add(borrower);
//
//            minTransfers++;
//        }

        return Math.min(minTransfers, transactions.length);

    }

    public static void main(String[] args) {
        OptimalAccountBalancing instance = new OptimalAccountBalancing();
//        int[][] transfers = {{0,1,10}, {2,0,5}};
        int[][] transfers = {{0,3,9},{1,4,2},{2,5,5},{3,4,6},{4,5,2}};
        System.out.println(instance.minTransfers(transfers));
    }

}
