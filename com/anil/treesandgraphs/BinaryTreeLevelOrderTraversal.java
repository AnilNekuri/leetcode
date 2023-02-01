package com.anil.treesandgraphs;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {

    }
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrderRec(TreeNode root) {
        int order = 0;
        setOrder(root,order);
        return result;
    }

    private void setOrder(TreeNode root,Integer order){
        if(root == null) return;
        if(result.size() < order+1){
            result.add(new ArrayList<>());
        }
        result.get(order).add(root.val);
        setOrder(root.left,order+1);
        setOrder(root.right,order+1);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return result;
        List<List<TreeNode>> resultTree = new ArrayList<>();
        result.add(new ArrayList<>());
        result.get(0).add(root.val);
        resultTree.add(new ArrayList<>());
        resultTree.get(0).add(root);
        for(int i = 1; resultTree.size() == i; i++){
            List<TreeNode> ctn = new ArrayList<>();
            List<Integer> ci = new ArrayList<>();
            for (TreeNode node: resultTree.get(i-1)) {
                if(node.left!=null){
                    ctn.add(node.left);
                    ci.add(node.left.val);
                }
                if(node.right!=null) {
                    ctn.add(node.right);
                    ci.add(node.right.val);
                }
            }
            if(ctn.size()>0){
                resultTree.add(ctn);
                result.add(ci);
            }
        }
        return result;
    }

}
