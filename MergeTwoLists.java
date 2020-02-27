/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        //也可以设置一个傀儡节点
        ListNode newHead=null;
        ListNode cur1=l1;
        ListNode cur2=l2;
        ListNode newtail=newHead;
        while(cur1!=null&&cur2!=null){
             if(cur1.val<=cur2.val){
                 if(newtail==null){
                     newtail=cur1;
                     newHead=cur1;
                 }else{
                     newtail.next=cur1;
                     newtail=newtail.next;
                 }
                 cur1=cur1.next;
             }else{
                 if(newtail==null){
                     newtail=cur2;
                     newHead=cur2;
                 }else{
                     newtail.next=cur2;
                     newtail=newtail.next;
                 }
                 cur2=cur2.next;
             }  
        }
        if(cur1!=null){
            newtail.next=cur1;
        }
        if(cur2!=null){
            newtail.next=cur2;
        }
       return newHead;
    }
}    
