package matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * For leftmost point A and rightmost point B assume a random point (x,y) is the answer
 * distance alone x-axis from A would be x - ax
 * distance alone x-axis from A would be bx - x
 *
 * sum of the distance travelled along x-axis from A and B would be x - ax + bx - x = bx - ax
 * similarly sum of the distance travelled along y-axis from A and B would be y - ay + by - y = by - ay
 *
 * similarly keep doing for next left/right and top/down points
 */
public class BestMeetingPointBetter {
    public int minTotalDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        List<Integer> I = new ArrayList<>(m);
        List<Integer> J = new ArrayList<>(n);

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    I.add(i);
                    J.add(j);
                }
            }
        }

        return getMin(I) + getMin(J);
    }

    private int getMin(List<Integer> list){
        int ret = 0;

        Collections.sort(list);

        int i = 0;
        int j = list.size() - 1;
        while(i < j){
            ret += list.get(j--) - list.get(i++);
        }

        return ret;
    }
}
