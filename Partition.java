import java.util.*;

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Partition {
    public ListNode partition(ListNode pHead, int x) {
        // write code here
        if(pHead==null){
            return null;
        }
        ListNode smallHead=new ListNode(-1);
        ListNode bigHead=new ListNode(-1);
        ListNode smallTail=smallHead;
        ListNode bigTail=bigHead;
        ListNode cur=pHead;
        while(cur!=null){
            if(cur.val<x){
                smallTail.next=new ListNode(cur.val);
                smallTail=smallTail.next;
            }else{
                bigTail.next=new ListNode(cur.val);
                bigTail=bigTail.next;
            }
            cur=cur.next;
        }
        smallTail.next=bigHead.next;
        return smallHead.next;
    }
}
