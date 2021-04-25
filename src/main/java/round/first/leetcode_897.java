package round.first;

import java.util.Stack;


/**
 * tree easy
 *
 * time: 2021-04-25
 */
public class leetcode_897 {

    public class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Preorder traversal:
     *     middle left right
     *
     * Inorder traversal:
     *     left middle right
     *
     * PostOrder traversal:
     *     left right midlle
     *
     * @param root
     * @return
     */
    public TreeNode increasingBST(TreeNode root) {
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();

        TreeNode currentNode = root;
        nodeStack.push(currentNode);

        TreeNode finalRootNode = new TreeNode();
        TreeNode finalRecordNode = finalRootNode;

        while (currentNode != null && !nodeStack.isEmpty()) {
            // dig the left to the bottom
            while (currentNode.left != null) {
                currentNode = currentNode.left;
                nodeStack.push(currentNode);
            }

            currentNode = nodeStack.pop();
            currentNode.left = null;

            finalRecordNode.right = new TreeNode();
            finalRecordNode = finalRecordNode.right;
            finalRecordNode.val = currentNode.val;

            // go dig the right side for one step
            if (currentNode.right != null) {
                currentNode = currentNode.right;
                nodeStack.push(currentNode);
            }
        }

        return finalRootNode.right;
    }



}
