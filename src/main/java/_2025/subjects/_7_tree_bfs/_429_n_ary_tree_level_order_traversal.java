package _2025.subjects._7_tree_bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * N 叉树的层序遍历
 *
 * @author 佳叙
 * @date 2025/4/4
 * @description <a href="https://leetcode.cn/problems/n-ary-tree-level-order-traversal/"/>
 */
public class _429_n_ary_tree_level_order_traversal {

    /**
     * BFS
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> ans = new LinkedList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> values = new LinkedList<>();

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                values.add(node.val);

                if (node.children != null) {
                    queue.addAll(node.children);
                }
            }

            ans.add(values);
        }

        return ans;
    }

    private class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

}