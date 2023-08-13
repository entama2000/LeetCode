/*
 * @lc app=leetcode id=226 lang=java
 *
 * [226] Invert Binary Tree
 */
import java.util.*;
// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(root);
        while (!que.isEmpty()) {
            TreeNode cur = que.poll();
            if (cur.left != null) {
                que.add(cur.left);
            }
            if (cur.right != null) {
                que.add(cur.right);
            }
            swapChild(cur);
        }
        return root;
    }

    public void swapChild(TreeNode head) {
        TreeNode temp = head.left;
        head.left = head.right;
        head.right = temp;
    }

    /*public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }*/
}
// @lc code=end
