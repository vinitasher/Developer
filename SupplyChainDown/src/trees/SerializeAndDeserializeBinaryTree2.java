package trees;

import java.util.Arrays;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that
 * it can be stored in a file or memory buffer, or transmitted across a network connection link to be
 * reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree.
 * There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized
 * to the original tree structure.
 *
 * Example:
 *
 * You may serialize the following tree:
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * as "[1,2,3,null,null,4,5]"
 * Clarification: The above format is the same as how LeetCode serializes a binary tree.
 * You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 *
 * Note: Do not use class member/global/static variables to store states.
 * Your serialize and deserialize algorithms should be stateless.
 */
public class SerializeAndDeserializeBinaryTree2 {
    static final String EMPTY_NODE = "$";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        int height = findHeight(root);
        String[] nodes = new String[(int)Math.pow(2,height) - 1];
        Arrays.fill(nodes, EMPTY_NODE);
        serializeHelper(root, 0, nodes);
        int nonZeroIndex = 0;
        for(int i = nodes.length - 1; i > 0; i--){
            if(!nodes[i].equals(EMPTY_NODE)) {
                nonZeroIndex = i;
                break;
            }
        }
        if(nonZeroIndex > 0) {
            nodes = Arrays.copyOf(nodes, nonZeroIndex + 1);
        }
        return Arrays.toString(nodes);
    }

    public void serializeHelper(TreeNode root, int index, String[] nodes) {
        if(root != null){
            nodes[index] = ""+root.val;
            serializeHelper(root.left, 2 * index + 1, nodes);
            serializeHelper(root.right,2 * index + 2, nodes);
        }
    }

    public int findHeight(TreeNode root){
        if(root == null) return 0;
        int left = findHeight(root.left);
        int right = findHeight(root.right);
        return Math.max(left, right) + 1;
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = data.substring(1, data.length() - 1);
        if(data.length() == 0) return null;
        String[] nodes = data.split(", ");
        int height = 0;
        for(int i = 1; i < nodes.length; i++){
            if(nodes.length < (int)Math.pow(2, i) - 1){
                height = i;
                break;
            }
        }
        if(nodes == null || nodes.length == 0) return null;
        TreeNode root = deserializeHelper(nodes, 0);
        return root;
    }

    public TreeNode deserializeHelper(String[] nodes, int index){
        TreeNode root = null;
        if(index < nodes.length && !nodes[index].equals(EMPTY_NODE)) {
            root = new TreeNode(Integer.parseInt(nodes[index]));
            root.left = deserializeHelper(nodes, index * 2 + 1);
            root.right = deserializeHelper(nodes, index * 2 + 2);
        }
        return root;
    }

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree2 instance = new SerializeAndDeserializeBinaryTree2();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        root.right.right.right.right = new TreeNode(5);
        root.right.right.right.right.right = new TreeNode(6);
        String str = instance.serialize(root);
        System.out.println(str);
        instance.deserialize("[]");
    }
}
