package geometry;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * A move consists of taking a point (x, y) and transforming it to either (x, x+y) or (x+y, y).
 *
 * Given a starting point (sx, sy) and a target point (tx, ty),
 * return True if and only if a sequence of moves exists to transform the point (sx, sy) to (tx, ty). Otherwise, return False.
 *
 * Examples:
 * Input: sx = 1, sy = 1, tx = 3, ty = 5
 * Output: True
 * Explanation:
 * One series of moves that transforms the starting point to the target is:
 * (1, 1) -> (1, 2)
 * (1, 2) -> (3, 2)
 * (3, 2) -> (3, 5)
 *
 * Input: sx = 1, sy = 1, tx = 2, ty = 2
 * Output: False
 *
 * Input: sx = 1, sy = 1, tx = 1, ty = 1
 * Output: True
 *
 * Note:
 *
 * sx, sy, tx, ty will all be integers in the range [1, 10^9].
 */
public class ReachingPoints {


    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        Queue<Point> pointQueue = new LinkedList<>();
        return reachingPointsRecursive(new Point(sx, sy), new Point(tx, ty), pointQueue);
    }

    // going from start to end is slow and results in time limit exceeded
    public boolean reachingPointsRecursive(Point s, Point t, Queue<Point> pointQueue) {
        pointQueue.add(s);
        while(!pointQueue.isEmpty()){
            Point p = pointQueue.poll();
            if(p.compareTo(t) == 0) return true;

            if(p.x > t.x || p.y > t.y) continue;

            pointQueue.add(new Point(p.x, p.x + p.y));
            pointQueue.add(new Point(p.x + p.y, p.y));
        }
        return false;
    }

    // going from end to start
    public boolean reachingPointsRecursive(int sx, int sy, int tx, int ty   ) {
        if (sx > tx || sy > ty) return false;
        if (sx == tx && (ty - sy) % sx == 0) return true;
        if (sy == ty && (tx - sx) % sy == 0) return true;
        return reachingPoints(sx, sy, tx % ty, ty % tx);
    }

    public class Point implements Comparable<Point> {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            int xdiff = this.x - o.x;
            if(xdiff != 0) return xdiff;
            return this.y - o.y;
        }
    }
    public static void main(String[] args) {

    }
}
