package com.anil.linkedList;

public class BaseClass {

    protected ListNode loadListNode(int[] l1Arr){
        ListNode l1 = new ListNode();
        ListNode l1Tail = l1;
        for(int i1 = 0; i1 < l1Arr.length; i1++){
            l1Tail.val = l1Arr[i1];
            ListNode newT = (i1 == l1Arr.length -1) ? null : new ListNode();
            l1Tail.next = newT;
            l1Tail = newT;
        }
        return l1;
    }

    protected String singleLinkedListToString(ListNode l1){
        StringBuilder sb = new StringBuilder();
        ListNode l1Tail = l1;
        do{
            sb.append(l1Tail.val+" ");
        }while((l1Tail = l1Tail.next) != null);
        return sb.toString();
    }
}
