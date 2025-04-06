package _2025.subjects._11_graph_dfs;

/**
 * Lesson 12: Graph DFS
 *
 * @author 佳叙
 * @date 2025/4/6
 * @description <a href="https://www.bilibili.com/video/BV1vv411q769/?spm_id_from=333.337.search-card.all.click&vd_source=d24bd83b5f103b2a3d84330964df0011"/>
 */
public class GraphDFS {

    /**
     * 通常， DFS Traversal graph 不允许访问同一个节点非"常数次"，所以 Time complexity O(n * k)，k == max(time(b), time(d))
     * - b: pre-order,  do things before recursion.
     * - d: post-order, do things after recursion.
     */
    public void template() {
        // 1. Initialize HashSet to record visited nodes.

        // 2. For all entry nodes, call dfs(Recursion)
            // a. Validate current node, if visited or invalid or answer node, return. (Or can choose i)
            // b. Do something. (Pre-order)

            // c. For each neighbor node:
                // i:  Validate neighbor node, if visited or invalid or answer node, don't recurse on it or return answer
                // ii: Recurse down on neighbor node -> dfs(neighbor)

            // d. Do something. (Post-order)
    }

}