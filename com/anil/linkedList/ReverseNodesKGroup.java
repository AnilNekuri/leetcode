package com.anil.linkedList;

import java.util.List;

public class ReverseNodesKGroup extends BaseClass{
    public static void main(String[] args) {
        int[] l1Arr = {1,2,3,4,5};
        int k = 3;
        ReverseNodesKGroup r = new ReverseNodesKGroup();
        ListNode head = r.loadListNode(l1Arr);
        ListNode resultHead = r.reverseKGroup(head,k);
        System.out.println(r.singleLinkedListToString(resultHead));
        //System.out.println(r.singleLinkedListToString(r.reverseKGroup(head,k)));
    }
    public ListNode reverseKGroup(ListNode head, int k){
        ListNode dummyHead = new ListNode();
        ListNode ptr = dummyHead;
        ListNode tail = dummyHead;
        dummyHead.next = head;
        while(ptr!=null){
            ListNode newHead = ptr.next;
            for(int i = 0; i < k-1 && tail != null; i++)
                tail = tail.next;
            if(tail == null)
                return dummyHead.next;
            ListNode tmp = tail.next;
            ptr.next = reverseSingleLinkedList(newHead,k);
            newHead.next = tmp;
            ptr = newHead;
        }

        return dummyHead.next;
    }
    //recursive
    public ListNode reverseKGroupRecursive(ListNode head, int k){
        ListNode tail = head;
        for(int i = 0; i < k-1 && tail != null; i++)
            tail = tail.next;
        if(tail == null)
            return head;
        ListNode nextHead = tail.next;
        ListNode newHead = reverseSingleLinkedList(head,k);
        head.next = reverseKGroup(nextHead,k);
        return newHead;
    }

    private ListNode reverseSingleLinkedList(ListNode head,int k){
        ListNode ptr = head;
        ListNode newHead = null;
        while (k > 0){
            ListNode oldHead = newHead;
            newHead = ptr;
            ptr = ptr.next;
            newHead.next = oldHead;
            k--;
        }
        return newHead;
    }
    public ListNode reverseKGroupMine(ListNode head, int k) {
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
