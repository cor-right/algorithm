package _2025.subjects._10_graph_bfs_2;

/**
 * NonUniform 是指路径的权重不同
 *
 * <p>
 *     Best First Search（最优优先）
 *     - 核心思想是优先展开最“优”的节点
 *     - 使用“堆”来快速计算最优
 *     - 最有名的找最短路径的算法是迪杰斯特拉算法（Dijisktra's Algorithm）
 * </p>
 *
 * <p>
 *     迪杰斯特拉算法能够找出从一个特定起始点到图中所有其他节点的最短路径，借助自驾游规划的场景，其核心步骤如下。
 *     准备：明确起始点，创建 “确定清单” 和 “待定清单”。起始点放入 “确定清单”，其余节点放入 “待定清单”。由于起始点到自身距离为 0，此时标记其距离为 0。
 *     探索：查看从起始点出发的所有路径，记录起始点到相邻节点的距离。将距离起始点最近的节点，从 “待定清单” 移至 “确定清单”。以新确定的节点为基点，检查其与其他节点间的路径。若通过新基点中转，能让其他节点到起始点的距离更短，就更新该距离。
 *     更新：持续从 “待定清单” 中找出距离起始点最近的节点，移至 “确定清单”。以新节点为中心，探索其连接的所有节点，更新这些节点到起始点的最短距离。重复这一操作，直至 “待定清单” 为空。
 *     结果：“待定清单” 为空时，每个节点到起始点的最短距离便已确定。通过记录每个节点最短路径的前一个节点，就能还原出具体路线。
 * </p>
 *
 *
 * @author 佳叙
 * @date 2025/4/6
 * @description <a href=""/>
 */
public class NonUniformCostGraph {

    /**
     * Time: O((E + V)logV)
     * Space: O(V)
     *
     * @see {@link _743_network_delay_time}
     *
     */
    private void template() {
        // 1. Initialize a Heap with all starting points marked with some initial costs, and a HashSet to record visited nodes.

        // 2. While heap is not empty.

            // a. Pull out one node.
            // b. If it has been visited, skip it
            // c. Otherwise mark the node as visited, update its cost.
            // d. If this is the destination node, return.
            // e. For all of its neighbors, offer them in to the heap with current node cost + edge cost.

    }

    /**
     *
     */
}