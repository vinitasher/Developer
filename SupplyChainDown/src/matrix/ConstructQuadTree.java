package matrix;

/**
 * We want to use quad trees to store an N x N boolean grid. Each cell in the grid can only be true or false.
 * The root node represents the whole grid. For each node, it will be subdivided into four children nodes until the
 * values in the region it represents are all the same.
 *
 * Each node has another two boolean attributes : isLeaf and val. isLeaf is true if and only if the node is a leaf node.
 * The val attribute for a leaf node contains the value of the region it represents.
 *
 * Your task is to use a quad tree to represent a given grid. The following example may help you understand the
 * problem better:
 *
 * Given the 8 x 8 grid below, we want to construct the corresponding quad tree:
 *
 *
 *
 * It can be divided according to the definition above:
 *
 *
 *
 *
 *
 * The corresponding quad tree should be as following, where each node is represented as a (isLeaf, val) pair.
 *
 * For the non-leaf nodes, val can be arbitrary, so it is represented as *.
 *
 *
 *
 * Note:
 *
 * N is less than 1000 and guaranteened to be a power of 2.
 * If you want to know more about the quad tree, you can refer to its wiki.
 */
public class ConstructQuadTree {

    public static void main(String[] args) {
        int[][] grid = {{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0}};

        ConstructQuadTree instance = new ConstructQuadTree();
        QuadNode result = instance.construct(grid);
    }

    public QuadNode construct(int[][] grid) {
        return construct(grid, 0, 0, grid.length);
    }

    public QuadNode construct(int[][] grid, int x, int y, int N){
        if(N == 1){
            if(grid[x][y] == 0) return new QuadNode(false, true, null, null, null, null);
            else return new QuadNode(true, true, null, null, null, null);
        }
        QuadNode topLeft        = construct(grid, x, y, N/2);
        QuadNode topRight       = construct(grid, x, y + N/2, N/2);
        QuadNode bottomLeft     = construct(grid, x + N/2, y, N/2);
        QuadNode bottomRight    = construct(grid, x + N/2, y + N/2, N/2);
        if(topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf){
            if(topLeft.val && topRight.val && bottomLeft.val && bottomRight.val){
                return new QuadNode(true, true, null, null, null, null);
            } else if(!topLeft.val && !topRight.val && !bottomLeft.val && !bottomRight.val){
                return new QuadNode(false, true, null, null, null, null);
            }
        }
        return new QuadNode(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }

}
