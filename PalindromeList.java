import java.util.*;

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class PalindromeList {
    public boolean chkPalindrome(ListNode A) {
        // write code here
        if(A==null||A.next==null){
            return true;
        }
        int mid=size(A)/2;
        ListNode B=A;
        for(int i=0;i<mid;i++){
            B=B.next;
        }
        ListNode prev=null;
        ListNode cur=B;
         ListNode next=null;
        while(cur!=null){
            next=cur.next;
            if(next==null){
                B=cur;
            }
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        while(B!=null){
            if(A.val!=B.val){
                return false;
            }
            A=A.next;
            B=B.next;
        }
        return true;
    }
    public int size(ListNode A){
        ListNode cur=A;
        int size=0;
        while(cur!=null){
            size++;
            cur=cur.next;
       }
        return size;
    }
}
