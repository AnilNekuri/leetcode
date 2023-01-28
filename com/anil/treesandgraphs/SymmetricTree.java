package com.anil.treesandgraphs;

import java.util.Deque;
import java.util.LinkedList;

public class SymmetricTree {
    public static void main(String[] args) {

    }

    public boolean isSymmetricRecursive(TreeNode root) {
        if(root == null) return true;
        return areSymmentric(root.left,root.right);
    }

    private boolean areSymmentric(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null) return true;
        if((root1 == null && root2 != null) ||
                (root1 != null && root2 == null))
            return false;
        if(root1.val != root2.val){
            return false;
        }
        return areSymmentric(root1.left,root2.right) && areSymmentric(root1.right,root2.left);
    }

    private Deque<TreeNode> stack1 = new LinkedList<>();
    private Deque<TreeNode> stack2 = new LinkedList<>();
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        stack1.push(root.left);
        stack2.push(root.right);
        return areSymmentricIterative();
    }

    private boolean areSymmentricIterative(){
        while(!stack1.isEmpty() && !stack2.isEmpty()){
            TreeNode root1 = stack1.poll();
            TreeNode root2 = stack2.poll();
            if((root1 == null && root2 != null) ||
                    (root1 != null && root2 == null))
                return false;
            if(root1.val != root2.val){
                return false;
            }
            if(root1.left != null || root2.right != null) {
                stack1.push(root1.left);
                stack2.push(root2.right);
            }
            if(root2.left != null || root1.right != null) {
                stack1.push(root1.right);
                stack2.push(root2.left);
            }
        }
        return true;
    }
}
