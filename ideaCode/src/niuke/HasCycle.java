package niuke;


//判断链表是否有环
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode left = head;
        ListNode right = head;

        while (right.next != null && right.next.next != null) {
            left = left.next;
            right = right.next.next;
            if (left == right) {
                return true;
            }
        }
        return false;
    }
}
