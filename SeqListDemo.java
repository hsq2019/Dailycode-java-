package datastructure.seqlist;

public class SeqListDemo {
    private static void testAdd(){
        //测试参属非法情况
        //测试扩容功能
        //尾插逻辑
        //普通位置的插入
        SeqList seqList=new SeqList();
        seqList.add(0,1);
        seqList.add(0,2);
        seqList.add(0,3);
        seqList.add(0,4);
        seqList.display();
    }
    private static void testContains(){
        SeqList seqList=new SeqList();
        seqList.add(0,1);
        seqList.add(0,2);
        seqList.add(0,3);
        seqList.add(0,4);
        System.out.println(seqList.contains(3));
    }
    private static void testSearch(){
        SeqList seqList=new SeqList();
        seqList.add(0,1);
        seqList.add(0,2);
        seqList.add(0,3);
        seqList.add(0,4);
        System.out.println(seqList.search(3));
    }

    private static void testRemove(){
        SeqList seqList=new SeqList();
        seqList.add(0,1);
        seqList.add(0,2);
        seqList.add(0,3);
        seqList.add(0,4);
        seqList.remove(3);
        seqList.display();
    }
    public static void main(String[] args) {
       testAdd();
       testContains();
       testSearch();
       testRemove();

    }
}
