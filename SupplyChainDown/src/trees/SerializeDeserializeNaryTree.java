package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits
 * so that it can be stored in a file or memory buffer,
 * or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize an N-ary tree.
 * An N-ary tree is a rooted tree in which each node has no more than N children.
 * There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that an N-ary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * For example, you may serialize the following 3-ary tree
 *
 *
 *
 *
 *
 *
 *
 * as [1 [3[5 6] 2 4]]. You do not necessarily need to follow this format,
 * so please be creative and come up with different approaches yourself.
 *
 *
 *
 * Note:
 *
 * N is in the range of [1, 1000]
 * Do not use class member/global/static variables to store states.
 * Your serialize and deserialize algorithms should be stateless.
 */
public class SerializeDeserializeNaryTree {

    public Node deserialize(String data){
        Stack<Node> stack = new Stack<>();
        return deserializeUtil(data.toCharArray(), stack, 0, null);
    }

    public Node deserializeUtil(char[] data, Stack<Node> stack, int index, Node current){
        if(index >= data.length) return current;
        char cChar = data[index];
        if(cChar >= '0' && cChar <= '9'){
            Node node = new Node(Integer.parseInt(cChar+""));
            if(!stack.empty()){
                Node parent = stack.peek();
                parent.children.add(node);
            } else {
                return deserializeUtil(data, stack, index + 1, node);
            }
        } else if(data[index] == ']'){
            Node node = null;
            if(!stack.empty()) node = stack.pop();
            return deserializeUtil(data, stack, index + 1, node);
        } else if(cChar == '['){
            if(current != null) stack.push(current);
            return deserializeUtil(data, stack, index + 1, null);
        } else {
            return deserializeUtil(data, stack, index + 1, current);
        }
        return null;
    }

    public String serialize(Node root) {
        return "["+serializeUtil(root)+"]";
    }

    private String serializeUtil(Node root) {
        StringBuilder builder = new StringBuilder("");
        if(root==null){
            return builder.toString();
        }

        builder.append(root.val);
        List<Node> children = root.children;
        if(root.children!=null) {
            builder.append("[");
            for (int i = 0; i < children.size(); i++) {
                String child = serializeUtil(children.get(i));
                builder.append(child);
                if(i<children.size()-1) {
                    builder.append(",");
                }
            }
            builder.append("]");
            return builder.toString();
        } else{
            return builder.toString();
        }
    }
    public class Node {
        public int val;
        public List<Node> children;
        public Node parent;

        public Node(int val) {
            this.val = val;
            this.children = new ArrayList<>();
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static void main(String[] args){
        SerializeDeserializeNaryTree instance = new SerializeDeserializeNaryTree();
        Node root = instance.new Node(1);

        Node child1 = instance.new Node(2);

        Node child1child1 = instance.new Node(4);

        Node child1child2 = instance.new Node(5);

        Node child1child3 = instance.new Node(6);

        Node child2 = instance.new Node(3);

        List<Node> childrenchild1 = new ArrayList<>();
        childrenchild1.add(child1child1);
        childrenchild1.add(child1child2);
        childrenchild1.add(child1child3);

        child1.children = childrenchild1;

        List<Node> children = new ArrayList<>();
        children.add(child1);
        children.add(child2);
        root.children = children;



        String res = instance.serialize(root);
        System.out.println(res);
        Node n = instance.deserialize("[1 [3[5 6] 2 4]]");
        System.out.println(n);
    }
}
