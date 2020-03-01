/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode y=hasCycle(head);
        if(y==null){
            return null;
        }
       ListNode x=head;
       while(x!=y){
           x=x.next;
           y=y.next;
       }
       return x;      
    }
     public ListNode hasCycle(ListNode head){
          if(head==null||head.next==null){
            return null;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                return slow;
            }
        }
        return null;
     }
}
