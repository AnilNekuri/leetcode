package com.anil.treesandgraphs;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {

    }

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return result;
        List<List<TreeNode>> resultTree = new ArrayList<>();
        resultTree.add(new ArrayList<>());
        resultTree.get(0).add(root);
        result.add(new ArrayList<>());
        result.get(0).add(root.val);
        for(int i = 1; resultTree.size() == i; i++){

            List<TreeNode> nodeList = new ArrayList<>();
            List<Integer> integerList = new ArrayList<>();
            for(TreeNode node : resultTree.get(i-1)){
                if(i%2==0){
                    if(node.left!=null){
                        nodeList.add(node.left);
                        integerList.add(node.left.val);
                    }
                    if(node.right!=null) {
                        nodeList.add(node.right);
                        integerList.add(node.right.val);
                    }

                }else{
                    if(node.left!=null){
                        nodeList.add(node.left);
                        integerList.add(0,node.left.val);
                    }
                    if(node.right!=null) {
                        nodeList.add(node.right);
                        integerList.add(0,node.right.val);
                    }

                }
            }
            if(nodeList.size() > 0){
                resultTree.add(nodeList);
                result.add(integerList);
            }
        }
        return result;
    }
    public List<List<Integer>> zigzagLevelOrderRec(TreeNode root) {
        int level = 0;
        zigZag(root,level);
        return result;
    }

    private void zigZag(TreeNode root, int level){
        if(root == null) return;
        if(result.size() < level+1)
            result.add(new ArrayList<>());
        if(level%2 == 0){
            result.get(level).add(root.val);
        }else {
            result.get(level).add(0,root.val);
        }
        zigZag(root.left,level+1);
        zigZag(root.right,level+1);
    }
}
