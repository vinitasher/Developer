package trees;

/**
 * Convert a BST to a sorted circular doubly-linked list in-place.
 * Think of the left and right pointers as synonymous to the previous and next pointers in a doubly-linked list.
 *
 * Let's take the following BST as an example, it may help you understand the problem better:
 *
 *                  4
 *                 / \
 *                2   5
 *               / \
 *              1   3
 *
 * We want to transform this BST into a circular doubly linked list.
 * Each node in a doubly linked list has a predecessor and successor.
 * For a circular doubly linked list, the predecessor of the first element is the last element,
 * and the successor of the last element is the first element.
 *
 * The figure below shows the circular doubly linked list for the BST above.
 * The "head" symbol means the node it points to is the smallest element of the linked list.
 *
 *        head
 *           \
 *          =1 = 2 = 3 = 4 = 5 =
 *         //                  \\
 *        //===================\\
 *
 * Specifically, we want to do the transformation in place. After the transformation,
 * the left pointer of the tree node should point to its predecessor,
 * and the right pointer should point to its successor.
 * We should return the pointer to the first element of the linked list.
 *
 * The figure below shows the transformed BST. The solid line indicates the successor relationship,
 * while the dashed line means the predecessor relationship.
 *
 *
 */
public class ConvertBinarySearchTreeToDoublyLinkedList {
    TreeNode head, tail;
    public TreeNode treeToDoublyList(TreeNode root) {
        head = null;
        tail = null;
        treeToDoublyListRecursive(root);
        return head;
    }

    public void treeToDoublyListRecursive(TreeNode root) {
        if(root == null) return;
        treeToDoublyListRecursive(root.left);
        if(head == null || tail == null) {
            head = root;
            tail = root;
        } else {
            tail.right = root;
            root.left = tail;
            tail = root;
        }
        treeToDoublyListRecursive(root.right);
    }

    public static void main(String[] args) {
        ConvertBinarySearchTreeToDoublyLinkedList instance = new ConvertBinarySearchTreeToDoublyLinkedList();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(instance.treeToDoublyList(root).val);
    }
}
