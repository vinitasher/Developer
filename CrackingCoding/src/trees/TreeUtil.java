/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

/**
 *
 * @author vasher
 */
public class TreeUtil {

    public static Node sampleInput() {
        Node root = new Node(1);

        root.left = new Node(10);

        root.left.left = new Node(105);
        root.left.left.left = new Node(106);
        root.left.left.right = new Node(104);

        root.right = new Node(1);

        root.right.left = new Node(55);

        root.right.right = new Node(77);
        return root;
    }

    public static Node sampleBinarySearchTree() {
        Node root = new Node(50);

        root.left = new Node(30);
        root.left.right = new Node(40);
        root.left.right.left = new Node(35);
        root.left.right.right = new Node(60);

        root.left.left = new Node(20);
//        root.left.left.right = new Node(31);
        //root.left.right = new Node(40);
        root.right = new Node(70);

        root.right.right = new Node(90);
        return root;
    }

    public static Node sampleBinarySumTree() {
        Node root = new Node(26);
        root.left = new Node(10);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(6);
        root.right.right = new Node(3);
        return root;
    }

    public static Node sampleNonBalancedTree() {
        Node root = new Node(1);

        root.left = new Node(2);

        root.left.left = new Node(4);

        root.left.right = new Node(5);

        root.right = new Node(3);

        root.right.left = new Node(6);

        root.right.right = new Node(7);
        root.right.right.right = new Node(8);
        root.right.right.right.right = new Node(9);
        return root;
    }
}
