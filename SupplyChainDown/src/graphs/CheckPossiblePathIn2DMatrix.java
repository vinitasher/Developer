package graphs;

/**
 * Given a 2D array(m x n), check if there is any path from top left to certain index which is pointed by number 9.
 * In the matrix, 1 is considered as road cell and 0 is considered as no road cell(can’t go through this cell).
 * Return true or false if there is path like the description above.
 * You can traverse up, down, right and left.
 *
 * Input : arr[][] = {
 *                  {1, 1, 0, 1, 0},
 *                  {1, 0, 0, 1, 1},
 *                  {1, 0, 1, 9, 1},
 *                  {1, 1, 1, 0, 0},
 *                  {1, 0, 1, 1, 1}}
 * Output : Yes
 *
 * Input : arr[][] = {{1, 0, 0, 1, 0},
 *                   {1, 0, 0, 1, 1},
 *                   {0, 0, 0, 1, 0},
 *                   {1, 0, 1, 9, 1},
 *                   {1, 0, 1, 0, 1}}
 * Output : No
 */
public class CheckPossiblePathIn2DMatrix {

    public boolean traverse2DMatrix(int[][] arr, int target, int x, int y){
        System.out.println(x+"\t"+y);
        if(arr[x][y] == 9){
            return true;
        }
        if(arr[x][y] == -1 || arr[x][y] == 0){
            arr[x][y] = -1;
            return false;
        } else if(arr[x][y] == 1){
            arr[x][y] = -1;
        }
        if(x > 0 && traverse2DMatrix(arr, target,x-1, y)){
            return true;
        }
        if(x < arr.length-1 && traverse2DMatrix(arr, target,x+1, y)){
            return true;
        }
        if(y > 0 && traverse2DMatrix(arr, target,x, y-1)){
            return true;
        }
        if(x > 0 && y < arr[0].length-1 && traverse2DMatrix(arr, target,x, y + 1)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CheckPossiblePathIn2DMatrix instance = new CheckPossiblePathIn2DMatrix();
        int[][] arr =
                    {{1, 0, 0, 1, 0},
                    {1, 0, 0, 1, 1},
                    {0, 0, 0, 1, 0},
                    {1, 0, 1, 9, 1},
                    {1, 0, 1, 0, 1}};
        System.out.println(instance.traverse2DMatrix(arr, 9, 0,0));
    }
}
