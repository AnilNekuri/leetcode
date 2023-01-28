package com.anil.treesandgraphs;

import org.w3c.dom.Node;

import java.util.Deque;
import java.util.LinkedList;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {

    }

    public boolean validate(TreeNode root, Integer lowLimit, Integer upLimit){
        if(root == null) {return true;}
        if((lowLimit != null && root.val <= lowLimit)
            || (upLimit != null && root.val >= upLimit)){
            return false;
        }
        return validate(root.left,lowLimit, root.val) && validate(root.right, root.val, upLimit);
    }
    public boolean isValidBSTRecursive1(TreeNode root) {
        Integer lowLimit = null;
        Integer upLimit = null;
        return validate(root,lowLimit,upLimit);
    }

    private Deque<TreeNode> stack = new LinkedList<>();
    private Deque<Integer> lowLimits = new LinkedList<>();
    private Deque<Integer> upLimits = new LinkedList<>();

    private void update(TreeNode root, Integer lowLimit, Integer upLimit){
        if(root!=null){
            stack.add(root);
            lowLimits.add(lowLimit);
            upLimits.add(upLimit);
        }
    }

    public boolean isValidBSTAproach1(TreeNode root) {
        Integer lowLimit = null, upLimit = null, val = null;

        if(root != null){
            update(root,lowLimit,upLimit);
        }
        while (!stack.isEmpty()){

            TreeNode node = stack.poll();
            lowLimit = lowLimits.poll();
            upLimit = upLimits.poll();
            val = node.val;
            if((lowLimit !=null && val <= lowLimit) ||
                    (upLimit !=null && val >= upLimit)){
                return false;
            }
            update(node.left,lowLimit,val);
            update(node.right,val,upLimit);
        }
        return true;
    }

    private Integer prev = null;
    public boolean isValidBST(TreeNode root) {
        return inOrder(root);
    }

    private boolean inOrderRecursive(TreeNode root){
        if(root == null) return true;
        if(!inOrder(root.left)) return false;
        if(prev!=null && root.val <= prev) return false;
        prev = root.val;
        return inOrder(root.right);
    }

    private Deque<TreeNode> stackItr = new LinkedList<>();
    private boolean inOrder(TreeNode root){
        if(root == null) return true;
        while (!stack.isEmpty() || root != null){
            while(root!=null){
                stackItr.push(root);
                root = root.left;
            }
            root = stackItr.poll();
            if(prev != null && root.val <= prev) return false;
            prev = root.val;
            root = root.right;
        }
        return true;
    }

}
