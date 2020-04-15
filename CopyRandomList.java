/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        //建立hashMap 键值对是 原节点--新节点
        Map<Node,Node> map=new HashMap<>();
        for(Node cur=head;cur!=null;cur=cur.next){
            // 原节点--新节点 的map添加东西
            map.put(cur,new Node(cur.val));
        }
        for(Node cur=head;cur!=null;cur=cur.next){
            Node newCur=map.get(cur);
            newCur.next=map.get(cur.next);
            newCur.random=map.get(cur.random);
        }
        //返回头节点
        return map.get(head);
    }
}