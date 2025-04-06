package _2025.subjects._11_graph_dfs;

import java.util.*;

/**
 * 重新安排行程
 *
 * @author 佳叙
 * @date 2025/4/6
 * @description <a href="https://leetcode.cn/problems/reconstruct-itinerary/description/"/>
 */
public class _332_reconstruct_itinerary {

    /**
     * 给你一份航线列表 tickets ，其中 tickets[i] = [fromi, toi] 表示飞机出发和降落的机场地点。请你对该行程进行重新规划排序。
     * 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。如果存在多种有效的行程，请你按字典排序返回最小的行程组合。
     *
     * 输入：tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
     * 输出：["JFK","MUC","LHR","SFO","SJC"]
     *
     * 如果没有保证至少存在一种合理的路径，我们需要判别这张图是否是欧拉图或者半欧拉图，具体地：
     * - 对于无向图 G，G 是欧拉图当且仅当 G 是连通的且没有奇度顶点。
     * - 对于无向图 G，G 是半欧拉图当且仅当 G 是连通的且 G 中恰有 0 个或 2 个奇度顶点。
     * - 对于有向图 G，G 是欧拉图当且仅当 G 的所有顶点属于同一个强连通分量且每个顶点的入度和出度相同。
     * - 对于有向图 G，G 是半欧拉图当且仅当
     *     - 如果将 G 中的所有有向边退化为无向边时，那么 G 的所有顶点属于同一个强连通分量；
     *     - 最多只有一个顶点的出度与入度差为 1；
     *     - 最多只有一个顶点的入度与出度差为 1；
     *     - 所有其他顶点的入度和出度相同。
     *
     * 因为本题保证至少存在一种合理的路径，也就告诉了我们，这张图是一个欧拉图或者半欧拉图。我们只需要输出这条欧拉通路的路径即可。
     *
     * 不妨倒过来思考。我们注意到只有那个入度与出度差为 1 的节点会导致死胡同。而该节点必然是最后一个遍历到的节点。
     * 我们可以改变入栈的规则，当我们遍历完一个节点所连的所有节点后，我们才将该节点入栈（即逆序入栈）。
     *
     * 对于当前节点而言，从它的每一个非「死胡同」分支出发进行深度优先搜索，都将会搜回到当前节点。
     * 而从它的「死胡同」分支出发进行深度优先搜索将不会搜回到当前节点。也就是说当前节点的死胡同分支将会优先于其他非「死胡同」分支入栈。
     *
     * 也就是，路径上的最后一个节点是确定的，一定是死胡同的这个节点，所以我们优先从最后一个节点出发，确定顺序。
     * 因此使用 Post-order，在递归回来的时候再插入，这样就确保了
     *
     * @param tickets
     * @return
     */
    public List<String> findItinerary(List<List<String>> tickets) {
        // Build graph
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            graph.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).offer(ticket.get(1));
        }

        // Traversal.
        List<String> route = new ArrayList<>();
        traversal(graph, route, "JFK");

        return route;
    }

    private void traversal(Map<String, PriorityQueue<String>> graph, List<String> route, String cur) {
        PriorityQueue<String> nextQueue = graph.getOrDefault(cur, new PriorityQueue<>());
        while (!nextQueue.isEmpty()) {
            traversal(graph, route, nextQueue.poll());
        }

        route.add(0, cur);
    }
}