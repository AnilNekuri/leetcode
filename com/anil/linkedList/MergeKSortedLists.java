package com.anil.linkedList;

import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static void main(String[] args) {

    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyhead = new ListNode();
        ListNode ptr = dummyhead;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((o1, o2) -> o1.val - o2.val);
        for (ListNode l: lists) {
            if(l!=null)
                pq.add(l);
        }
        while (!pq.isEmpty()){
            ListNode cur = pq.poll();
            ptr.next = cur;
            ptr = ptr.next;
            if(cur.next!=null)
                pq.add(cur.next);
        }
        return dummyhead.next;
    }
}
