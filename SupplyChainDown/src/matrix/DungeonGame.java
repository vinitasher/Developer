package matrix;

/**
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon.
 * The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the
 * top-left room and must fight his way through the dungeon to rescue the princess.
 *
 * The knight has an initial health point represented by a positive integer.
 * If at any point his health point drops to 0 or below, he dies immediately.
 *
 * Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms;
 * other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
 *
 * In order to reach the princess as quickly as possible,
 * the knight decides to move only rightward or downward in each step.
 *
 *  -2(k)   |   -3       |   3
 *  -5      |   -10      |   1
 *  10      |   30       |   -5(P)
 *
 * Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
 *
 * For example, given the dungeon below, the initial health of the knight must be at least 7
 * if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
 *
 * -2 (K)	-3	    3
 * -5	    -10	    1
 * 10   	30	    -5 (P)
 *
 *
 * Note:
 *
 * The knight's health has no upper bound.
 * Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room
 * where the princess is imprisoned.
 */
public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int rows = dungeon.length;
        int cols = dungeon[0].length;
        dungeon[rows-1][cols-1] = Math.min(dungeon[rows-1][cols-1],0);
        for(int i=rows-1; i>=0; i--){
            for(int j=cols-1; j>=0; j--){
                if(i==rows-1 && j==cols-1){
                    continue;
                } else if(i==rows-1){
                    dungeon[i][j] += dungeon[i][j+1];
                    if(dungeon[i][j]>0){
                        dungeon[i][j]=0;
                    }
                } else if(j==cols-1){
                    dungeon[i][j] += dungeon[i+1][j];
                    if(dungeon[i][j]>0){
                        dungeon[i][j]=0;
                    }
                } else {
                    dungeon[i][j]+=Math.max(dungeon[i][j+1], dungeon[i+1][j]);
                    if(dungeon[i][j]>0){
                        dungeon[i][j]=0;
                    }
                }
            }
        }
        return (-(dungeon[0][0])+1)<0?1:(-(dungeon[0][0])+1);
    }
}
