package com.anil.treesandgraphs;

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
    public boolean isValidBST(TreeNode root) {
        Integer lowLimit = null;
        Integer upLimit = null;
        return validate(root,lowLimit,upLimit);
    }
}
