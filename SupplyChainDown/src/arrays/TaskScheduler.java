package arrays;

/**
 * Given a char array representing tasks CPU need to do.
 * It contains capital letters A to Z where different letters represent different tasks.
 * Tasks could be done without original order. Each task could be done in one interval.
 * For each interval, CPU could finish one task or just be idle.
 *
 * However, there is a non-negative cooling interval n that means between two same tasks,
 * there must be at least n intervals that CPU are doing different tasks or just be idle.
 *
 * You need to return the least number of intervals the CPU will take to finish all the given tasks.
 *
 *
 *
 * Example:
 *
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 *
 *
 * Note:
 *
 * The number of tasks is in the range [1, 10000].
 * The integer n is in the range [0, 100].
 */
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        if( n == 0) return tasks.length;
        int[] charCountArr = new int[26];
        //count task count
        for(char c: tasks) {
            charCountArr[c - 'A']++;
        }
        //find max/others
        int max = 0, maxCount = 1, othersCount = 0;
        for(int i: charCountArr) {
            if(i > max) {
                //add older max count to others
                othersCount += maxCount * max;
                //new max value
                max = i;
                maxCount = 1;
            } else if(i == max) {
                maxCount++;
            } else {
                //count less than max
                othersCount += i;
            }
        }
        int result = 0, idleCount = 0;
        result += max;
        result += othersCount;
        if(othersCount/n < max - 1) {
            idleCount = n * (max - 1) - othersCount;
        }
        result += idleCount;
        result = result + maxCount - 1;
        return result;
    }

    public static void main(String[] args) {
        TaskScheduler instance = new TaskScheduler();
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 3;
        int result = instance.leastInterval(tasks, n);
        System.out.println(result);
    }
}
