package lists;

import lists.utils.DoublyLinkedListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 */
public class LRUCache {

    int capacity;
    DoublyLinkedListNode head, tail;
    Map<Integer, DoublyLinkedListNode> cacheMap;

    public LRUCache(int capacity) {
        this.cacheMap = new HashMap<>();
        this.capacity = capacity;
        head = null;
        tail = null;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* capacity */);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));      // returns 3
        System.out.println(cache.get(4));       // returns 4
    }

    public int get(int key) {
        DoublyLinkedListNode node = cacheMap.get(key);
        if (node == null) {
            return -1;
        }
        int value = node.val;
        //bounce node to top of DLL
        removeNodeFromDLL(node);
        addNodeToDLL(node);
        return value;
    }

    public void removeNodeFromDLL(DoublyLinkedListNode node) {
        if (node == null) {
            return;
        }
        if (!cacheMap.containsKey(node.key)) {
            return;
        }
//        System.out.println("Remove node "+node.key);
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            }
        }
        cacheMap.remove(node.key);
    }

    public void addNodeToDLL(DoublyLinkedListNode node) {
//        System.out.println("Add node "+node.key);
        if (head == null) {
            head = node;
            tail = node;
            //head.next = tail;
            //tail.prev = head;
        } else {
            node.next = head;
            head.prev = node;
            node.prev = null;
            head = node;
        }
        cacheMap.put(node.key, node);
    }

    public void put(int key, int value) {
        DoublyLinkedListNode node = new DoublyLinkedListNode(key, value);
        if (cacheMap.containsKey(key)) {
            //repeat value
            DoublyLinkedListNode oldNode = cacheMap.get(key);
            removeNodeFromDLL(oldNode);
            oldNode.val = value;
            addNodeToDLL(oldNode);
        } else {
            //new value
            addNodeToDLL(node);
        }

        if (cacheMap.size() > capacity) {
            //cache is full remove tail of queue and insert element at head
            removeNodeFromDLL(tail);
        }

    }
}
