package DataStructure;

import java.util.Scanner;

public class CircleArrayQueue {
    public static void main(String[] args) {
        System.out.println("环形队列");
        CircleArray arrayQueue=new CircleArray(4);
        //maxsize是4，有效数字最多是3
        char key1=' ';
        Scanner scanner=new Scanner(System.in);
        boolean loop=true;
        while(loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):推出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取数据");
            System.out.println("h(head):查看队列头的数据");
            key1=scanner.next().charAt(0);//接受一个字符
            switch(key1){
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
    static class CircleArray{
        private int rear;//对列尾
        private int front;//队列头
        private int[] arr;//模拟队列
        private int maxSize;//队列的最大容量

        public CircleArray(int arrMaxSize){
            maxSize = arrMaxSize;
            arr = new int[maxSize];
            front = 0;
            rear = 0;
        }
        //判断是否满
        public boolean isFull(){
            return (rear+maxSize-front)%maxSize==front;
        }
        //判断是否是空
        public boolean isEmpty(){
            return front==rear;
        }
        //添加数据
        public void addQueue(int n){
            if(isFull()){
                System.out.println("数列已经满了，不能添加数字");
                return;
            }
            arr[rear]=n;
            rear=(rear+1)%maxSize;
        }
        //取数据
        public int getQueue(){
            if(isEmpty()){
                throw new RuntimeException("队列为空，不能取数据");
            }
            int value=arr[front];
            front=(front+1)%front;
            return value;
        }
        //当前队列有效数字个数
        public int size(){
            return (rear+maxSize-front)%maxSize;
        }

        //显示数据
        public void showQueue(){
            if(isEmpty()){
                throw new RuntimeException("队列为空，无数据");
            }
            for(int i=front;i<front+size();i++){
                System.out.println(arr[i%maxSize]+"  ");
            }
        }
        //显示队列头数据
        public int headQueue(){
            if(isEmpty()){
                throw new RuntimeException("队列空，不可以去除数据");
            }
            return arr[front];
        }
    }
}
