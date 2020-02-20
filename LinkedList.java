package datastructure.linkdelist_2;
//单向，不带环，不带傀儡节点的链表
public class LinkedList {
    //管理所有链表节点
    private Node head=null;//空链表


    //头插入
    public void addFirst(int data){
        //空链表
        Node node=new Node(data);
        if(head==null){
            head=node;
            return;
        }
        //不是空链表
        node.next=head;
        head=node;
    }


    //尾插入
    public void addLast(int data){
        Node node=new Node(data);
        if(head==null){
            head=node;
            return;
        }
        //如果链表非空，先找到链表末尾
        Node tail=head;
        while (true){
            if(tail.next==null){
                break;
            }
            tail=tail.next;
        }
        tail.next=node;
    }


    //把链表的每个元素都打印
    public void display(){
        if(head==null){
            System.out.println("链表为空");
            return;
        }
        for(Node cur=head;cur!=null;cur=cur.next){
            System.out.print(cur.data+"  ");
        }
        System.out.println();
    }


    //插入到指定位置
    public boolean addIndex(int index,int data){
        Node node=new Node(data);
        int size=getSize();
        //判断index是否有效
        if(index<0||index>size){
            return false;
        }
        //如果index是0那么就头插入
        if(index==0){
            addFirst(data);
            return true;
        }
        //如果index是size那就尾插
        if(index==size){
             addLast(data);
             return true;
        }
        //index是中间位置
        Node prev=getPos(index-1);
        //新节点插入
        node.next=prev.next;
        prev.next=node;
        return true;
    }


    //求链表的长度
    public int getSize(){
        int size=0;
        for(Node cur=head;cur!=null;cur=cur.next){
            size++;
        }
        return size;
    }


    //给定index下标，找到对应的节点
    private Node getPos(int index){
        Node cur=head;
        for(int i=0;i<index;i++){
            cur=cur.next;
        }
        return cur;
    }


    //判断一个数是否存在
    public boolean contains(int toFind){
        for(Node cur=head;cur!=null;cur=cur.next){
            if(cur.data==toFind){
                return true;
            }
        }
        return false;
    }


    //按值删除
    public void remove(int toRemove){
      //判断是否是头删
      if(head.data==toRemove){
          head=head.next;
      }
      //找到删除的节点的前一个节点
        Node prev=searchPrev(toRemove);
      Node toDelete=prev.next;
      prev.next=toDelete.next;
    }


    private  Node searchPrev(int toRemove){
        for(Node cur=head;cur!=null&&cur.next!=null;cur=cur.next){
            if(cur.next.data==toRemove){
                return cur;
            }
        }
        return null;
    }

    //删除把当前数字在链表中全部删除
    public void removeAll(int toRemove){
        //先删除后面的数字
         Node prev=head;
         Node cur=head.next;
         while (cur!=null){
             if(cur.data==toRemove){
                 prev.next=cur.next;
                 cur=prev.next;
             }else{
                 prev=cur;
                 cur=cur.next;
             }
         }
         //头节点
        if(head.data==toRemove){
            head=head.next;
        }
    }

    //清空链表
    public void clear(){
        head=null;
    }


}

class Node{
    public int data;
    public Node next=null;
    public Node(int data){
        this.data=data;
    }

}
