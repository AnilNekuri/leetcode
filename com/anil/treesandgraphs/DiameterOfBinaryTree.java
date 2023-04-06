package com.anil.treesandgraphs;

public class DiameterOfBinaryTree {

    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        int d = calcDiameter(root);
        return diameter;
    }

    private int calcDiameter(TreeNode root) {
        if(root == null) return 0;
        int ld = (root.left != null ? 1 : 0 ) + calcDiameter(root.left);
        int rd = (root.right != null ? 1 : 0 ) + calcDiameter(root.right);
        diameter = Integer.max(ld+rd,diameter);
        return Integer.max(ld,rd);
    }
}
