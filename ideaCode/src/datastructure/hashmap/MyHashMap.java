package datastructure.hashmap;

//自己写一个hashMap
//使用开散列来处理hash
//map的话是键值对
public class MyHashMap {
    static class Node {
        //key value是键值对
        public int key;
        public int value;
        public Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    //负载因子
    private static final double LOAD_FACTOR=0.75;
    //新建一个node类型数组
    //array就是hashMap的本体，数组的每个元素都是链表的头节点
    private Node[] array=new Node[101];
    private int size=0;

    //哈希函数
    private int hashFunc(int key) {
        return key%array.length;
    }

    //put方法 插入
    public void put(int key,int value){
        int index=hashFunc(key);
        Node list=array[index];
        //为了判断 链表中现在准备插入的key已经在链表中存在过
        //如果和这个传入的key一样的话，那么就把以前存的就覆盖掉,就不用再新建节点了
        for(Node cur=list;cur!=null;cur=cur.next){
            if(cur.key==key){
                cur.value=value;
                return;
            }
        }
        //现在开始新建一个node节点
        Node newNode=new Node(key,value);
        //选择头插法，头插简单，尾插写起来比较麻烦
        newNode.next=list;
        array[index]=newNode;
        size++;
        if(size/array.length>LOAD_FACTOR){
            //进行扩容
            resize();
        }
    }
    //进行扩容
    private void resize() {
        Node[] newArray=new Node[array.length*2];
        for(int i=0;i<array.length;i++){
            for(Node cur=array[i];cur!=null;cur=cur.next){
                int index=cur.key%newArray.length;
                Node newNode=new Node(cur.key,cur.value);
                newNode.next=newArray[index];
                newArray[index]=newNode;
            }

        }
    }

    //get方法 查找
    public Integer get(int key){
        int index=hashFunc(key);
        Node list=array[index];
        for(Node cur=list;cur!=null;cur=cur.next){
            if(cur.key==key){
                return cur.value;
            }
        }
        return null;
    }

    //remove 删除
    public void remove(int key){
        int index=hashFunc(key);
        Node list=array[index];
        if(list==null){
            System.out.println("删除失败");
            return;
        }
        //头删的情况,出现在头
        if(list.key==key){
            list=list.next;
            System.out.println("删除成功");
            size--;
            return;
        }
        Node cur=list.next;
        Node prev=list;
        while(cur!=null){
            if(cur.key==key){
                prev.next=cur.next;
                size--;
                System.out.println("删除成功");
                return;
            }else{
                prev=cur;
                cur=cur.next;
            }
        }
        System.out.println("删除失败");
    }



    //测试
    public static void main(String[] args) {
        MyHashMap map=new MyHashMap();
        map.put(1,10);
        map.put(2,20);
        map.put(3,30);
        map.put(4,40);
        map.put(1,50);
//        System.out.println(map.get(5));
//        System.out.println(map.get(1));
//        System.out.println(map.get(2));
//        map.remove(2);
//        System.out.println(map.get(2));
        map.remove(5);
        map.remove(2);
        System.out.println(map.get(2));


    }
}
