package com.anil.linkedList;

import java.util.List;

public class ReverseNodesKGroup extends BaseClass{
    public static void main(String[] args) {
        int[] l1Arr = {1,2,3,4,5};
        int k = 2;
        ReverseNodesKGroup r = new ReverseNodesKGroup();
        ListNode head = r.loadListNode(l1Arr);
        ListNode resultHead = r.reverseKGroup(head,k);
        System.out.println(r.singleLinkedListToString(resultHead));

    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode();
        ListNode prevTail = dummyHead;
        prevTail.next = head;
        ListNode newHead = head;
        while(newHead != null){
            ListNode tail = newHead;
            for(int i = 0; i < k-1 && newHead != null; i++){
                newHead = newHead.next;
            }
            if(newHead == null)
                break;
            ListNode cNode = tail;
            while(cNode != newHead){
                prevTail.next = cNode.next;
                ListNode temp = newHead.next;
                newHead.next = cNode;
                cNode.next = temp;
                cNode = prevTail.next;
            }
            prevTail = tail;
            newHead = tail.next;
        }
        return dummyHead.next;
    }
}
