package com.anil.treesandgraphs;

import com.sun.source.tree.Tree;

import java.util.*;

public class LowestCommonAncestorBinaryTree {

    static TreeNode p = null;
    static TreeNode q = null;
    public static void main(String[] args) {
        Integer[] input = {3,5,1,6,2,0,8,null,null,7,4};
        LowestCommonAncestorBinaryTree l = new LowestCommonAncestorBinaryTree();
        TreeNode root = l.insertLevelOrder(input,0,5,4);


        TreeNode la = l.lowestCommonAncestor(root,p,q);

        System.out.println(la.val);

        la = l.lowestCommonAncestorRecursive(root,p,q);

        System.out.println(la.val);
    }
    public TreeNode insertLevelOrder(Integer[] arr, int i,int pv, int qv)
    {
        TreeNode root = null;
        // Base case for recursion
        if (i < arr.length) {
            if(arr[i]!=null){
            root = new TreeNode(arr[i]);
            if(pv == arr[i]) p = root;
            if(qv == arr[i]) q = root;

                // insert left child
            root.left = insertLevelOrder(arr, 2 * i + 1,pv,qv);

            // insert right child
            root.right = insertLevelOrder(arr, 2 * i + 2,pv,qv);
            }
        }
        return root;
    }
    public void inOrder(TreeNode root)
    {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }


    public TreeNode lowestCommonAncestorRecursive(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> pAncestors = new LinkedList<>();
        findChild(root,p,pAncestors);

        //ancestors.stream().forEach(t -> System.out.print("-"+t.val));
        //System.out.println();
        LinkedList<TreeNode> qAncestors = new LinkedList<>();
        findChild(root,q,qAncestors);
        int min = Integer.min(pAncestors.size(),qAncestors.size());
        TreeNode lowestAnc = root;
        for(int i = 0; i < min; i++){
            if(pAncestors.get(i) == qAncestors.get(i)){
                lowestAnc = pAncestors.get(i);
            }else{
                break;
            }
        }
        return lowestAnc;
    }

    private boolean findChild(TreeNode root, TreeNode c, LinkedList<TreeNode> ancestors){
        if(root == null) return false;
        ancestors.add(root);
        //System.out.println(root.val);

        if(c==root) return true;

        boolean found = findChild(root.left,c,ancestors);
        if(found) return true;
        if(root.left != null){
            ancestors.remove(ancestors.size()-1);
        }

        found = findChild(root.right,c,ancestors);
        if(found) return true;
        if(root.right != null) {
            ancestors.remove(ancestors.size() - 1);
        }
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode,TreeNode> parentMap = new HashMap<>();
        parentMap.put(root,null);
        Queue<TreeNode> stack = new LinkedList<>();
        stack.add(root);

        while(!stack.isEmpty()){
            TreeNode node = stack.poll();

            if(node.left!=null){
                parentMap.put(node.left,node);
                stack.add(node.left);
            }

            if(node.right!=null){
                parentMap.put(node.right,node);
                stack.add(node.right);
            }
        }

        List<TreeNode> ancestors = new ArrayList<>();

        while (p != null){
            ancestors.add(p);
            p = parentMap.get(p);
        }

        while (!ancestors.contains(q)){
            q = parentMap.get(q);
        }
        return q;
    }
}
