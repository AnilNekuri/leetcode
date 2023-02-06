package com.anil.treesandgraphs;

public class BinaryTreeMaximumPathSum {
    public static void main(String[] args) {

    }

    int maxSum = -3001;
    public int maxPathSum(TreeNode root) {
        sum(root);
        return maxSum;
    }

    private int sum(TreeNode root){
        if(root == null) return 0;
        int sum = root.val;
        int left = sum(root.left);
        int right = sum(root.right);
        int leftSum = sum + left;
        int rightSum = sum + right;
        sum = root.val + left + right;
        int max = Math.max(root.val,Math.max(leftSum,rightSum));
        if(Math.max(sum,max) > maxSum) maxSum = Math.max(sum,max);
        return max;
    }
}
