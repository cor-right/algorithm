package _2025.subjects._11_graph_dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 克隆图
 *
 * @author 佳叙
 * @date 2025/4/7
 * @description <a href=""/>
 */
public class _133_clone_graph {

    /**
     * 在图论中，图的连通性是图的基本性质。连通图基于连通的概念。
     * 在一个无向图 G 中，若从顶点i到顶点j有路径相连（当然从j到i也一定有路径），则称i和j是连通的。如果 G 是有向图，那么连接i和j的路径中所有的边都必须同向。
     * 如果图中任意两点都是连通的，那么图被称作连通图。
     * 如果此图是有向图，则称为强连通图（注意：需要双向都有路径）。
     *
     * @param node
     * @return
     */
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> visited = new HashMap<>();

        recursion(visited, node);
        return visited.get(node);
    }

    /**
     * 这是个连通图，所以递归的返回，一定是从访问到的最后一个节点开始的，所以使用 Post-Order 可以的
     *
     * @param visited
     * @param node
     */
    private void recursion(Map<Node, Node> visited, Node node) {
        Node copy = new Node(node.val);
        visited.put(node, copy);

        for (Node neighbor : node.neighbors) {
            if (!visited.containsKey(neighbor)) {
                recursion(visited, neighbor);
            }
        }

        copy.neighbors = new ArrayList<>();
        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(visited.get(neighbor));
        }
    }

    private class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

}