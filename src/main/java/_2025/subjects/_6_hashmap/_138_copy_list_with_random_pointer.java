package _2025.subjects._6_hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 随机链表的复制
 *
 * @author 佳叙
 * @date 2025/4/4
 * @description <a href="https://leetcode.cn/problems/copy-list-with-random-pointer/"/>
 */
public class _138_copy_list_with_random_pointer {


    /**
     * 注意，这里随机节点的新节点创建和赋值需要一起进行的，
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();

        Node origin = head;

        Node target = new Node(0);
        Node node   = target;

        while (origin != null) {
            Node next = Optional.ofNullable(map.get(origin)).orElse(new Node(origin.val));
            map.put(origin, next);

            if (origin.random != null) {
                Node random = Optional.ofNullable(map.get(origin.random)).orElse(new Node(origin.random.val));
                next.random = random;
                map.put(origin.random, random);
            }

            node.next = next;

            origin = origin.next;
            node = next;
        }

        return target.next;
    }



    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}