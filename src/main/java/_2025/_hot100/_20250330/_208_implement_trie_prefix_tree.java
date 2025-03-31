package _2025._hot100._20250330;

import javax.swing.tree.TreeNode;

/**
 * 实现Trie - 一种前缀树
 *
 * @author 佳叙
 * @date 2025/3/30
 * @description <a href="https://leetcode.cn/problems/implement-trie-prefix-tree/"/>
 */
public class _208_implement_trie_prefix_tree {

    /**
     * 其实就是按照字母从上到下安排树状结构
     */
    TrieNode tree;

    public _208_implement_trie_prefix_tree() {
         this.tree = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = tree;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }

            node = node.children[index];
        }
        node.leaf = true;
    }

    public boolean search(String word) {
        TrieNode node = tree;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }

        return node.leaf;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = tree;

        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';

            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }

        return true;
    }

    private class TrieNode {
        boolean leaf;
        TrieNode[] children = new TrieNode[26];
    }



}