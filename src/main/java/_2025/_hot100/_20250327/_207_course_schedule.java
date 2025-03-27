package _2025._hot100._20250327;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 课程表
 *
 * @author 佳叙
 * @date 2025/3/27
 * @description <a href="https://leetcode.cn/problems/course-schedule/description/"/>
 */
public class _207_course_schedule {

    /**
     * 成环检测：拓扑排序/DFS
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        return canFinishByTopologicalSorting(numCourses, prerequisites);
    }

    /**
     * 拓扑排序
     *
     * <p>
     *     利用入度数组和队列，从入度为0的节点开始，逐步移除节点并减少其后续节点的入度，若所有节点都能被移除，则无环，可以完成所有课程。
     * </p>
     *
     * @return
     */
    private boolean canFinishByTopologicalSorting(int numCourses, int[][] prerequisites) {
        if (numCourses == 1 || prerequisites == null || prerequisites.length == 0) {
            return false;
        }

        // Init
        List<List<Integer>> dependencies = new ArrayList<>(numCourses);
        List<Integer> inDegrees = new ArrayList<>(numCourses);

        for (int i = 0; i < numCourses; i++) {
            dependencies.set(i, new ArrayList<>());
            inDegrees.set(i, 0);
        }

        // Prepare
        for (int i = 0; i < prerequisites.length; i++) {
            int before = prerequisites[i][0];
            int after  = prerequisites[i][1];

            dependencies.get(before).add(after);
            inDegrees.set(before, inDegrees.get(before) + 1);
        }

    }


    /**
     * DFS
     *
     * <p>
     *     通过递归遍历图，用状态数组标记节点状态（未访问、正在访问、已访问且安全），若遇到正在访问的节点，则存在环，无法完成所有课程。
     *
     * </p>
     * @param numCourses
     * @param prerequisites
     * @return
     */
    private boolean canFinishByDFS(int numCourses, int[][] prerequisites) {

    }


}