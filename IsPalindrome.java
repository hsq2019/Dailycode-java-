/**
 * Definition for singly-linked list.
 /* public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null){
            return true;
        }
        Stack<ListNode> stack=new Stack<ListNode>();
        ListNode cur=head;
        while(cur!=null){
            stack.push(cur);
            cur=cur.next;
        }
        cur=head;
        while(stack.size()>0){
            ListNode prev=stack.pop();
            if(cur.val!=prev.val){
                return false;
            }
            cur=cur.next;
        }
        return true;
    }
}
