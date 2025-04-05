package _2025.subjects._9_graph_bfs;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 单词接龙
 *
 * @author 佳叙
 * @date 2025/4/5
 * @description <a href="https://leetcode.cn/problems/word-ladder/description/"/>
 */
public class _127_word_ladder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        Map<String, List<String>> graph = buildGraph(beginWord, wordList);
        Map<String, Boolean> visited = new HashMap<>();

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return level;
                }

                List<String> near = graph.getOrDefault(word, new ArrayList<>());
                if (near.isEmpty()) {
                    return 0;
                }

                for (String str : near) {
                    if (!visited.getOrDefault(str, false)) {
                        queue.offer(str);
                        visited.put(str, true);
                    }
                }
            }

            level++;
        }

        return 0;
    }

    /**
     * 这是一个无向图
     *
     * @param words
     * @return
     */
    private Map<String, List<String>> buildGraph(String begin, List<String> words) {
        Map<String, List<String>> graph = new HashMap<>();

        words.add(begin);
        for (int i = 0; i < words.size(); i++) {
            for (int j = i + 1; j < words.size(); j++) {
                String wordA = words.get(i);
                String wordB = words.get(j);

                if (near(wordA, wordB)) {
                    graph.computeIfAbsent(wordA, k -> new ArrayList<>()).add(wordB);
                    graph.computeIfAbsent(wordB, k -> new ArrayList<>()).add(wordA);
                }
            }
        }

        return graph;
    }

    /**
     * 相邻字符串
     *
     * @param strA
     * @param strB
     * @return
     */
    private boolean near(String strA, String strB) {
        int diffCnt = 0;

        for (int i = 0; i < strA.length(); i++) {
            if (strA.charAt(i) != strB.charAt(i)) {
                diffCnt++;
            }
        }

        return diffCnt == 1;
    }

}