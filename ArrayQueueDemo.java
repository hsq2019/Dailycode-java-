package DataStructure;
import java.util.*;
public class ArrayQueueDemo {
    public static void main(String[] args) {
    ArrayQueue arrayQueue=new ArrayQueue(3);
    char key=' ';
    Scanner scanner=new Scanner(System.in);
    boolean loop=true;
    while(loop){
        System.out.println("s(show):显示队列");
        System.out.println("e(exit):推出程序");
        System.out.println("a(add):添加数据到队列");
        System.out.println("g(get):从队列取数据");
        System.out.println("h(head):查看队列头的数据");
        key=scanner.next().charAt(0);//接受一个字符
        switch(key){
            case 's':
                arrayQueue.showQueue();
                break;
            case 'a':
                System.out.println("请输入一个数字");
                int value=scanner.nextInt();
                arrayQueue.addQueue(value);
                break;
            case 'g'://取数据
                try{
                    int res= arrayQueue.getQueue();
                    System.out.println("取出的数据是"+res);
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
                break;
            case 'h':
                try{
                    int res=arrayQueue.headQueue();
                    System.out.println("队列头数据是"+res);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
                break;
            case 'e':
                scanner.close();
                loop=false;
                break;
            default:
                break;
            }
        }
        System.out.println("程序退出");
    }
}
class ArrayQueue {
    private int rear;//对列尾
    private int front;//队列头
    private int[] arr;//模拟队列
    private int maxSize;//队列的最大容量

    //创建构造器
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    //判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断队列是否空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    //获取队列数据
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取数据");
        }
        front++;
        return arr[front];
    }

    //显示队列的数据
    public void showQueue() {
        if (isEmpty()) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    //查看队列头的数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front + 1];
    }
}