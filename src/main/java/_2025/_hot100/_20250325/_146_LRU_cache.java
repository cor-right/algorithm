package _2025._hot100._20250325;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * LRU 缓存
 *
 * @author 佳叙
 * @date 2025/3/25
 * @description <a href="https://leetcode.cn/problems/lru-cache/description/"/>
 */
public class _146_LRU_cache {

    private Map<Integer, ListNode> nodesMap = new HashMap<>();

    private ListNode head = null;
    private ListNode tail = null;

    private int maxCapacity;

    /**
     *
     * @param capacity
     */
    public _146_LRU_cache(int capacity) {
        this.maxCapacity = capacity;
    }

    public int get(int key) {
        ListNode node = nodesMap.get(key);
        if (node == null) {
            return -1;
        }

        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        ListNode currentNode = nodesMap.get(key);

        if (currentNode == null) {
            createNode(key, value);
        }
        else {
            modifyNode(currentNode, value);
        }
    }

    private void createNode(int key, int value) {
        if (nodesMap.size() == maxCapacity) {
            removeTail();
        }

        ListNode node = new ListNode();
        node.key = key;
        node.val = value;

        node.next = head;
        if (head != null) {
            head.pre = node;
        }

        if (tail == null) {
            tail = node;
        }

        head = node;
        nodesMap.put(key, node);
    }

    private void modifyNode(ListNode node, int value) {
        node.val = value;

        // move to head
        moveToHead(node);
    }


    private void moveToHead(ListNode node) {
        if (head == node) {
            return ;
        }

        // leave
        if (node.pre != null) {
            node.pre.next = node.next;
        }
        if (node.next != null) {
            node.next.pre = node.pre;
        }

        if (head != null) {
            head.pre = node;
        }

        if (tail == node) {
            tail = tail.pre;
        }

        node.pre  = null;
        node.next = head;
        head = node;
    }

    private void removeTail() {
        // remove map
        nodesMap.remove(tail.key);

        if (head == tail) {
            head = null;
            tail = null;
        }
        else {
            tail.pre.next = tail.next;
            tail = tail.pre;
        }
    }

    private class ListNode {
        Integer  key;
        Integer  val;
        ListNode pre;
        ListNode next;
    }

}