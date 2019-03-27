package greedy;

/**
 * Suppose you have a random list of people standing in a queue.
 * Each person is described by a pair of integers (h, k),
 * where h is the height of the person
 * and k is the number of people in front of this person who have a height greater than or equal to h.
 *
 * Write an algorithm to reconstruct the queue.
 *
 * Note:
 * The number of people is less than 1,100.
 *
 *
 * Example
 *
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 */
public class QueueReconstructionByHeight {

    public int[][] reconstructQueue(int[][] people) {
        final int _HEIGHT = 0;
        final int _RANK = 1;
        int[][] result = new int[people.length][2];
        int minHeight = Integer.MAX_VALUE;
        for(int i=0; i<people.length; i++){
            if(people[i][_HEIGHT] > minHeight){
                minHeight = people[i][_HEIGHT];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        QueueReconstructionByHeight instance = new QueueReconstructionByHeight();
        int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int[][] result = instance.reconstructQueue(people);
    }
}
