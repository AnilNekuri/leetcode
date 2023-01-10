package com.anil.linkedList;

public class AddTwoNumbers {
    public static void main(String[] args) {


        int[] l1Arr = {2, 4, 3}, l2rArr = {5, 6, 4};
        AddTwoNumbers a = new AddTwoNumbers();
        ListNode l1 = a.loadListNode(l1Arr);
        ListNode l2 = a.loadListNode(l2rArr);
        System.out.println(a.singleLinkedListToString(l1));
        System.out.println(a.singleLinkedListToString(l2));
        ListNode r = a.addTwoNumbers(l1,l2);
        System.out.println(a.singleLinkedListToString(r));
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultHead = new ListNode();
        ListNode resultNode = resultHead;
        int cf = 0;
        do{
            int l1Val = l1!=null? l1.val: 0;
            int l2Val = l2!=null? l2.val: 0;
            int sum = cf + l1Val + l2Val;
            l1 = l1 != null && l1.next != null? l1.next: null;
            l2 = l2 != null && l2.next != null? l2.next: null;
            cf = sum/10;
            resultNode.val = sum%10;
            if(l1!=null || l2 != null || cf > 0) {
                resultNode.next = new ListNode();
                resultNode = resultNode.next;
                resultNode.val = cf;
            }
        }while(l1 != null || l2 != null);
        return resultHead;
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
