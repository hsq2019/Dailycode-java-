package datastructure.stack;
import jdk.nashorn.internal.ir.RuntimeNode;
import java.util.*;
public class ArrayStackDemo {
    public static void main(String[] args) {
        //测试
        ArrayStack stack=new ArrayStack(4);
        String key="";
        boolean loop=true;
        Scanner scanner = new Scanner(System.in);
        while (loop){
            System.out.println("show：表示显示栈");
            System.out.println("exit：表示退出程序");
            System.out.println("push：表示给栈添加数据");
            System.out.println("pop：表示从栈取出数据");
            System.out.println("请输入你的选择");
            key=scanner.next();
            switch (key){
                case "show":
                   stack.list();
                   break;
                case "exit":
                    scanner.close();
                    loop=false;
                    break;
                case "push":
                    System.out.println("请输入要压入堆栈的数字");
                    int data=scanner.nextInt();
                    stack.push(data);
                    break;
                case "pop":
                    try{
                        int res=stack.pop();
                        System.out.println("出栈的数据是"+res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("输入不正确，请重新输入");
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

//使用ArrayStack表示栈
class ArrayStack{
    private int maxSize;
    private int[] stack;
    private int top=-1;//栈顶

    //构造
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack=new int[maxSize];
    }
    //栈满
    public boolean ifFull(){
        return top==maxSize-1;
    }
    //栈空
    public boolean ifEmpty(){
        return top==-1;
    }
    //入栈
    public void push(int data){
        if(ifFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top]=data;
    }
    //出栈
    public int pop(){
        if(ifEmpty()){
           throw new RuntimeException("栈为空,没有数据");
        }
        int value=stack[top];
        top--;
        return value;
    }
    //显示栈的情况
    public void list(){
        //遍历时要从栈顶显示数据
        if(ifEmpty()){
            System.out.println("栈为空，不能显示数据");
            return;
        }
        int i=top;
        while(i>=0){
            System.out.print(stack[i]+" ");
            i--;
        }
        System.out.println();
    }
}
