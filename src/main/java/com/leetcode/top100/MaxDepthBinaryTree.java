package com.leetcode.top100;

import com.leetcode.TreeNode;

public class MaxDepthBinaryTree {

    public static void main(String[] args) {
        TreeNode tree = createTree1(new TreeNode(3));
        System.out.println(maxDepth(tree));
    }

    private static TreeNode createTree1(TreeNode root) {
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        return root;
    }

    private static int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }

}
