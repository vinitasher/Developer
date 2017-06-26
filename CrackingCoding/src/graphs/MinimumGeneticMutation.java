/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import io.IOUtil;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import string.StringUtil;

/**
 *
 * @author vasher A gene string can be represented by an 8-character long
 * string, with choices from "A", "C", "G", "T".
 *
 * Suppose we need to investigate about a mutation (mutation from "start" to
 * "end"), where ONE mutation is defined as ONE single character changed in the
 * gene string.
 *
 * For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.
 *
 * Also, there is a given gene "bank", which records all the valid gene
 * mutations. A gene must be in the bank to make it a valid gene string.
 *
 * Now, given 3 things - start, end, bank, your task is to determine what is the
 * minimum number of mutations needed to mutate from "start" to "end". If there
 * is no such a mutation, return -1.
 *
 * Note:
 *
 * Starting point is assumed to be valid, so it might not be included in the
 * bank. If multiple mutations are needed, all mutations during in the sequence
 * must be valid. You may assume start and end string is not the same.
 *
 * Example 1:
 *
 * start: "AACCGGTT" end: "AACCGGTA" bank: ["AACCGGTA"]
 *
 * return: 1
 *
 * Example 2:
 *
 * start: "AACCGGTT" end: "AAACGGTA" bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
 *
 * return: 2
 *
 * Example 3:
 *
 * start: "AAAAACCC" end: "AACCCCCC" bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
 *
 * return: 3
 *
 * Example 4: 
 * start: "AACCTTGG" 
 * end: "AATTCCGG" 
 * bank: ["AATTCCGG","AACCTGGG","AACCCCGG","AACCTACC"]
 */
public class MinimumGeneticMutation {

    private static final char[] VALID_GENES = {'A', 'C', 'G', 'T'};

    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        Set<String> visited = new HashSet<>();
        if (!bankSet.contains(end)) {
            return -1;
        }
        char[] endArr = end.toCharArray();
        int count = 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        queue.add(null);
        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (current != null) {
                char[] currArr = current.toCharArray();
                int currArrLen = currArr.length;
                for (int i = 0; i < currArrLen; i++) {
                    if (currArr[i] != endArr[i]) {
                        for (int j = 0; j < VALID_GENES.length; j++) {
                            if (currArr[i] != VALID_GENES[j]) {
                                char temp = currArr[i];
                                currArr[i] = VALID_GENES[j];
                                String newGene = String.valueOf(currArr);
                                if (newGene.equals(end)) {
                                    System.out.println("End: " + newGene
                                            + "\tcount: " + count);
                                    return count + 1;
                                } else if (bankSet.contains(newGene)
                                        && !visited.
                                        contains(newGene)) {
                                    System.out.println("Found: " + newGene
                                            + "\tcount: " + count);
                                    queue.add(newGene);
                                    visited.add(newGene);
                                }
                                currArr[i] = temp;
                            }
                        }
                    }
                }
            } else {
                count++;
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            }

        }

        return count;
    }

    public static void main(String[] args) {
        MinimumGeneticMutation mgm = new MinimumGeneticMutation();
//        String start = StringUtil.readInputString();
//        String end = StringUtil.readInputString();
//        int bankSize = IOUtil.readInteger("Enter bank size:");
//        String[] bank = new String[bankSize];
//        for (int i = 0; i < bankSize; i++) {
//            System.out.println("Enter val" + i + ": ");
//            bank[i] = StringUtil.readInputString();
//        }
        String start = "AAAAACCC";
        String end = "AACCCCCC";
        String[] bank = {"AAAACCCC", "AAACCCCC", "AACCCCCC"};
        int result = mgm.minMutation(start, end, bank);
        System.out.println("Minimum Gene Mutations: " + result);
    }
}
