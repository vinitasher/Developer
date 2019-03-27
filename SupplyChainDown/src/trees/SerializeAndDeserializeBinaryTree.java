package trees;

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
public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        int height = heightOfTree(root);
        return"";
    }

    public StringBuffer serializeRecursive(TreeNode root, int height) {
        StringBuffer left, right;
        if(height == 0){
            return new StringBuffer("");
        }
        if(root == null) {
            left = new StringBuffer("null");
            right = new StringBuffer("null");
        } else {
            left = serializeRecursive(root.left, height - 1);
            right = serializeRecursive(root.right, height - 1);
        }
        return left;
    }

    public int heightOfTree(TreeNode root){
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(heightOfTree(root.left), heightOfTree(root.right));
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return new TreeNode(1);
    }

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree instance = new SerializeAndDeserializeBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(4);
        System.out.println(instance.serialize(root));
    }
}
