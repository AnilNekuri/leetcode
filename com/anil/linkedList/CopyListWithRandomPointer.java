package com.anil.linkedList;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer{
    public static void main(String[] args) {
        CopyListWithRandomPointer c= new CopyListWithRandomPointer();
        int[][] arr = {{7,-1},{13,0},{11,4},{10,2},{1,0}};
    }

    public Node copyRandomList(Node head) {
        Node original = head;
        Node curr = original;
        Node duplicate = new Node(-1);
        Node ptr = duplicate;
        Map<Node,Node> nodeMap = new HashMap<>();
        nodeMap.put(null,null);
        while(curr!=null){
            Node newNode = new Node(curr.val);
            nodeMap.put(curr,newNode);
            ptr.next = newNode;
            curr = curr.next;
            ptr = ptr.next;
        }
        curr = original;
        ptr = duplicate.next;
        while(curr!=null){
            ptr = ptr.next;
            ptr.random = nodeMap.get(curr.random);
            curr = curr.next;
        }
        return duplicate.next;
    }

    public Node loadArrayToLinkedList(int[][] arr){
        Node dummyHead = new Node(-1);
        Node ptr = dummyHead;
        Node[] nodes = new Node[arr.length];
        for (int i = 0; i < arr.length; i++) {
            Node newNode = new Node(arr[i][0]);
            ptr.next = newNode;
            ptr = ptr.next;
        }
        ptr.next = null;
        ptr = dummyHead;
        for(int i = 0; i < arr.length; i++){
            ptr = ptr.next;
            ptr.random = nodes[arr[i][1]];
        }
        return  dummyHead.next;
    }

    protected String linkedListToString(ListNode l1){
        StringBuilder sb = new StringBuilder();
        ListNode l1Tail = l1;
        do{
            sb.append(l1Tail.val+" ");
        }while((l1Tail = l1Tail.next) != null);
        return sb.toString();
    }

}
