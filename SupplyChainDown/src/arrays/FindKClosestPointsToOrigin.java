package arrays;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 *
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 *
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 *
 *
 *
 * Example 1:
 *
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 * Example 2:
 *
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 *
 *
 * Note:
 *
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 */
public class FindKClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int K) {
        return kClosestHelper(points, K, 0, points.length-1);
    }

    public int[][] kClosestHelper(int[][] points, int K, int start, int end){
        int pivot = ThreadLocalRandom.current().nextInt(start, end + 1);
        pivot = quickSort(points, start, end, pivot);
        if(pivot < K){
            return kClosestHelper(points, K, pivot, K);
        } else if(pivot > K){
            return kClosestHelper(points, K, K, pivot);
        } else {
            return Arrays.copyOfRange(points, 0, K);
        }
    }

    public int quickSort(int[][] points, int start, int end, int pivot){
        swap(points, start, pivot);
        int i = start;
        int j = end;
        while(true){
            nextI: while(distance(points[start]) < distance(points[i])) {
                i++;
                if(i <= j) continue nextI;
            }

            nextJ: while(distance(points[start]) > distance(points[j])) {
                j--;
                if(i <= j) continue nextJ;
            }

            if(i < j) swap(points, i, j);
            else break;
        }
        swap(points, start, i);
        return i;
    }

    public void swap(int[][] points, int x, int y){
        int[] temp = points[x];
        points[x] = points[y];
        points[y] = temp;
    }

    public int distance(int[] point){
        return (int)Math.pow(point[0], 2) + (int)Math.pow(point[1], 2);
    }

    public static void main(String[] args) {
        FindKClosestPointsToOrigin instance = new FindKClosestPointsToOrigin();
        int[][] points = {{1,3},{-2,2}};
        System.out.println(Arrays.toString(instance.kClosest(points, 1)));
    }
}
