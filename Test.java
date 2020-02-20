package datastructure.linkdelist_2;

public class Test {
    private static void testAddFirst(){
        LinkedList linkedList=new LinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        linkedList.addFirst(4);
    }
    private static void testAddLast(){
        LinkedList linkedList=new LinkedList();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.display();//打印
    }
    private static void testContains(){
        LinkedList linkedList=new LinkedList();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        System.out.println(linkedList.contains(3));
    }
    private static void testToRemove(){
        LinkedList linkedList=new LinkedList();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.remove(2);
        linkedList.display();
    }
    private static void testRmoveAll(){
        LinkedList linkedList=new LinkedList();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(2);
        linkedList.addLast(4);
        linkedList.removeAll(2);
        linkedList.display();
    }


    public static void main(String[] args) {
        testAddFirst();
        testAddLast();
        testContains();
        testToRemove();
        testRmoveAll();
    }
}
