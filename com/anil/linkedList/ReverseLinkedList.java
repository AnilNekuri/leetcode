package com.anil.linkedList;

public class ReverseLinkedList extends BaseClass{
    public static void main(String[] args) {
        ReverseLinkedList r = new ReverseLinkedList();
        int[] arr = {1,2,3,4,5};
        ListNode head = r.loadListNode(arr);
        ListNode newHead = r.reverseList(head);
        System.out.println(r.singleLinkedListToString(newHead));
    }

    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        ListNode ptr = head;

        while (ptr!=null){
            ListNode cur = ptr;
            ptr = ptr.next;
            cur.next = newHead;
            newHead = cur;
        }
        return  newHead;
    }
}
