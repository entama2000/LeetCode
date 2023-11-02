/*
 * @lc app=leetcode id=104 lang=java
 *
 * [104] Maximum Depth of Binary Tree
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
    public int maxDepth(TreeNode root) {
        return maxDepthHelper(root);
    }

    public int maxDepthHelper(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepthHelper(root.left) + 1, maxDepthHelper(root.right) + 1);
    }
}
// @lc code=end

