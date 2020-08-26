package niuke;

import java.util.List;

public class ReverseLinkedList{
    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        ListNode head=ReverseList(node1);
        ListNode node=head;
        while (node!=null){
            System.out.println(node.val);
            node=node.next;
        }
    }
    public static ListNode ReverseList(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        ListNode prev=null;
        ListNode cur=head;

        while (cur!=null){
            ListNode next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
    }
}

class ListNode {
      int val;
    ListNode next;
    ListNode(int x) { val = x; }
}