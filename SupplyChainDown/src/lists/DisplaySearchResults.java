package lists;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Given an array of CSV strings representing search results, output results sorted by a score initially.
 * A given host may have several listings that show up in these results. Suppose we want to show 12 results per page,
 * but we don’t want the same host to dominate the results.
 *
 * Write a function that will reorder the list so that a host shows up at most once on a page if possible,
 * but otherwise preserves the ordering.
 *
 * Your program should return the new array and print out the results in blocks representing the pages.
 *
 * Given an array of csv strings, output results separated by a blank line.
 */
public class DisplaySearchResults {

    public List<String> displayPages(List<String> inputList, int pageSize){
        List<String> cache = new ArrayList<>();
        Set<Integer> visitedHosts = new HashSet<>();
        List<String> result = new ArrayList<>();
        int pageCount = 0, currentPos = 0;
        boolean reachEnd = false;
        Iterator<String> it = inputList.iterator();

        while(it.hasNext()){
            String str = it.next();
            Integer host = getHost(str);

            if(!visitedHosts.contains(host) || reachEnd){
                result.add(str);
                pageCount++;
                it.remove();
                visitedHosts.add(host);
            }

            if(pageCount == pageSize){
                if(!inputList.isEmpty()) result.add(" ");
                pageCount = 0;
                visitedHosts.clear();
                it = inputList.iterator();
            }

            if(!it.hasNext()){
                reachEnd = true;
                it = inputList.iterator();
            }

        }

        return result;
    }

    public Integer getHost(String input){
        return Integer.parseInt(input.substring(0, input.indexOf(',')));
    }

    public static void main(String[] args) {
        DisplaySearchResults sol = new DisplaySearchResults();
        String[] strs = new String[]{
                "1,28,300.1,SanFrancisco",
                "4,5,209.1,SanFrancisco",
                "20,7,208.1,SanFrancisco",
                "23,8,207.1,SanFrancisco",
                "16,10,206.1,Oakland",
                "1,16,205.1,SanFrancisco",
                "6,29,204.1,SanFrancisco",
                "7,20,203.1,SanFrancisco",
                "8,21,202.1,SanFrancisco",
                "2,18,201.1,SanFrancisco",
                "2,30,200.1,SanFrancisco",
                "15,27,109.1,Oakland",
                "10,13,108.1,Oakland",
                "11,26,107.1,Oakland",
                "12,9,106.1,Oakland",
                "13,1,105.1,Oakland",
                "22,17,104.1,Oakland",
                "1,2,103.1,Oakland",
                "28,24,102.1,Oakland",
                "18,14,11.1,SanJose",
                "6,25,10.1,Oakland",
                "19,15,9.1,SanJose",
                "3,19,8.1,SanJose",
                "3,11,7.1,Oakland",
                "27,12,6.1,Oakland",
                "1,3,5.1,Oakland",
                "25,4,4.1,SanJose",
                "5,6,3.1,SanJose",
                "29,22,2.1,SanJose",
                "30,23,1.1,SanJose"
        };
        List<String> input = new ArrayList<>(Arrays.asList(strs));
        List<String> result = sol.displayPages(input, 12);
        System.out.println(32 == result.size());
        System.out.println("1,28,300.1,SanFrancisco".equals(result.get(0)));
        System.out.println("11,26,107.1,Oakland".equals(result.get(11)));
        System.out.println(" ".equals(result.get(12)));
        System.out.println("1,16,205.1,SanFrancisco".equals(result.get(13)));
        System.out.println("2,30,200.1,SanFrancisco".equals(result.get(14)));
        System.out.println("25,4,4.1,SanJose".equals(result.get(24)));
        System.out.println(" ".equals(result.get(25)));
        System.out.println("1,2,103.1,Oakland".equals(result.get(26)));
        System.out.println("3,11,7.1,Oakland".equals(result.get(27)));
        System.out.println("30,23,1.1,SanJose".equals(result.get(30)));
        System.out.println("1,3,5.1,Oakland".equals(result.get(31)));
    }

}
