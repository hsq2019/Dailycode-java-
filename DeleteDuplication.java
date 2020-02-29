/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public ListNode deleteDuplication(ListNode pHead){
        if(pHead==null){
            return null;
        }
        ListNode cur=pHead;
        ListNode newHead=new ListNode(-1);
        ListNode newTail=newHead;
        while(cur!=null){
            if(cur.next!=null&&cur.val==cur.next.val){
                while(cur.next!=null&&cur.val==cur.next.val){
                    cur=cur.next;
                }
                 cur=cur.next;
            }else{
                newTail.next=new ListNode(cur.val);
                newTail=newTail.next;
                cur=cur.next;
            }
        }
        return newHead.next;
    }
}
