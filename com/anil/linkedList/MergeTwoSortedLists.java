package com.anil.linkedList;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        int[] l1Arr = {1,2,4}, l2rArr = {1,3,4};
        MergeTwoSortedLists m = new MergeTwoSortedLists();
        ListNode l1 = m.loadListNode(l1Arr);
        ListNode l2 = m.loadListNode(l2rArr);
        ListNode r = m.mergeTwoLists(l1,l2);
        System.out.println(m.singleLinkedListToString(r));
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode currentNode = dummyHead;
        while(list1 != null || list2 != null){
            int l1Val = list1 != null ? list1.val : 101;
            int l2Val = list2 != null ? list2.val : 101;
            if(l1Val < l2Val) {
                currentNode.next = list1;
                list1 = list1.next != null? list1.next: null;
            }else {
                currentNode.next = list2;
                list2 = list2.next != null? list2.next: null;
            }
            currentNode = currentNode.next;
        }
        return dummyHead.next;
    }
    private ListNode loadListNode(int[] l1Arr){
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

    private String singleLinkedListToString(ListNode l1){
        StringBuilder sb = new StringBuilder();
        ListNode l1Tail = l1;
        do{
            sb.append(l1Tail.val+" ");
        }while((l1Tail = l1Tail.next) != null);
        return sb.toString();
    }
}
