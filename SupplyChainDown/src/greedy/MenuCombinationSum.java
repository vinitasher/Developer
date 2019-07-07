package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a menu (list of items prices),
 * find all possible combinations of items that sum a particular value K.
 * (A variation of the typical 2sum/Nsum questions).
 */
public class MenuCombinationSum {

    List<List<Double>> result;

    List<List<Double>> getCombos(double[] prices, double target){
        result = new ArrayList<>();
        Arrays.sort(prices);
        combinationSumHelper(prices, target, prices.length - 1, new ArrayList<>());
        return result;
    }

    void combinationSumHelper(double[] prices, double target, int index, List<Double> list){
        if(target > -0.00001 && target < 0.00001) {
            result.add(new ArrayList<>(list));
            return;
        }
        if(target < 0) return;
        for(int i = index; i >= 0; i--){
            list.add(prices[i]);
            combinationSumHelper(prices, target - prices[i], i - 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        MenuCombinationSum sol = new MenuCombinationSum();
        double[] prices = {10.02, 1.11, 2.22, 3.01, 4.02, 2.00, 5.03};
        List<List<Double>> combos = sol.getCombos(prices, 7.03);
        System.out.println(combos);
        System.out.println(2 == combos.size());
    }
}
