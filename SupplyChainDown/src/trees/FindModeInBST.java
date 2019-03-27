package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * For example:
 * Given BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 *
 *
 * return [2].
 *
 * Note: If a tree has more than one mode, you can return them in any order.
 *
 * Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count
 */
public class FindModeInBST {

    public int[] findMode(TreeNode root) {
        Map<Integer, Integer>  modeMap = new HashMap<>();
        findModeRecursive(root, modeMap);

        int maxCount = 0;
        List<Integer> modeList = new ArrayList<>();
        for(int node: modeMap.keySet()){

            int value = modeMap.get(node).intValue();
            if(value > maxCount){
                //System.out.println(node + "\t"+modeMap.get(node));
                maxCount = value;
                modeList.clear();
                modeList.add(node);
            } else if(value == maxCount){
                //System.out.println(node + "\t"+modeMap.get(node));
                modeList.add(node);
            }
        }
        int[] result = new int[modeList.size()];
        for(int i=0;i<modeList.size(); i++){
            result[i]=modeList.get(i);
        }
        return result;
    }

    public void findModeRecursive(TreeNode root, Map<Integer, Integer> modeMap){
        if(root == null){
            return;
        }
        if(!modeMap.containsKey(root.val)){
            modeMap.put(root.val, 1);
        } else {
            modeMap.put(root.val, modeMap.get(root.val).intValue()+1);
        }
        findModeRecursive(root.left, modeMap);
        findModeRecursive(root.right, modeMap);
    }

    public static void main(String[] args) {

    }
}
