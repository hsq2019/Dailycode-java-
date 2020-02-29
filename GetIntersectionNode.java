/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA=size(headA);
        int sizeB=size(headB);
        ListNode A=headA;
        ListNode B=headB;
        int sub=0;
        if(sizeA>sizeB){
            sub=sizeA-sizeB;
            for(int i=0;i<sub;i++){
                A=A.next;
            }
        }else{
            sub=sizeB-sizeA;
            for(int i=0;i<sub;i++){
                B=B.next;
            }
        }
        while(A!=null){
            if(A==B){
                return A;
            }
            A=A.next;
            B=B.next;
        }
        return null;

    }
    //求链表的长度
    public int size(ListNode head){
        int size=0;
        ListNode cur=head;
        while(cur!=null){
            size++;
            cur=cur.next;
        }
        return size;
    }
}
