package com.practice.etc;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode node) {
        return recursion(node, 0);
    }

    public int recursion(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }

        return Math.max(recursion(node.left, depth + 1), recursion(node.right, depth + 1));
    }

    public void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.println(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.val);
        inOrder(node.right);
    }

    public void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.val);
    }

    static class TreeNode {
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

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree solution = new MaximumDepthOfBinaryTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(solution.maxDepth(root));
    }
}
