package datastructure.stack;

public class Calculator {
    public static void main(String[] args) {
        String expression="3+2*6-2";
        //创建两个栈
        ArrayStack2 numStark = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        int index=0;
        int num1=0;
        int num2=0;
        int oper=0;
        int res=0;
        char ch=' ';//将每次扫描到的char保存到ch
        String keepNum="";//用于拼接多位数
        while (true){
            ch=expression.substring(index,index+1).charAt(0);
            //判断ch是什么
            if(operStack.isOper(ch)){
                //判断符号栈是不是空
                if(!operStack.ifEmpty()){
                    //不是空
                    if(operStack.priority(ch)<=operStack.priority(operStack.peek())){
                        num1=numStark.pop();
                        num2=numStark.pop();
                        oper=operStack.pop();
                        res=numStark.cal(num1,num2,oper);
                        //把运算结果入数栈
                        numStark.push(res);
                        operStack.push(ch);
                    }else{
                        operStack.push(ch);
                    }
                }else{
                    //空，直接入栈
                    operStack.push(ch);

                }
            }else{//如果是数字，直接入数栈是不对的，可能是的多位数
                //应该在表达式的后再看一位，如果是数字，那么继续扫描
                //如果后面是符号，那么数字入栈
                //需要定义变量用于拼接
                keepNum+=ch;
                if(index==expression.length()-1){
                    numStark.push(Integer.parseInt(keepNum));
                }else{
                    if(operStack.isOper(expression.substring(index+1,index+2).charAt(0))){
                        //如果后一位是操作符，则入栈
                        numStark.push(Integer.parseInt(keepNum));
                        //清空keepnum
                        keepNum="";
                    }
                }
            }
          //让index+1，并判断是否扫描到expression的最后
            index++;
            if(index>=expression.length()){
                break;
            }
        }
        while (true){
            //如果符号栈为空，数栈只有一个数
            if(operStack.ifEmpty()){
                break;
            }
            num1=numStark.pop();
            num2=numStark.pop();
            oper=operStack.pop();
            res=numStark.cal(num1,num2,oper);
            numStark.push(res);//入栈
        }
        System.out.println("表达式="+numStark.pop());
    }
}

class ArrayStack2{
    private int maxSize;
    private int[] stack;
    private int top=-1;//栈顶

    //构造
    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack=new int[maxSize];
    }
    //返回当前栈顶的值
    public int peek(){
        return stack[top];
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
    //规定优先级
    public int priority(int oper){
        if(oper=='*'||oper=='/'){
            return 1;
        }else if(oper=='+'||oper=='-') {
            return 0;
        }else{
            return -1;
        }
    }
    //判断是不是一个运算符
    public boolean isOper(char val){
        return val=='+'||val=='-'||val=='*'||val=='/';
    }
    //计算方法
    public int cal(int num1,int num2,int oper){
        int res=0;
        switch (oper){
            case '+':
                res=num1+num2;
                break;
            case '-':
                res=num2-num1;
                break;
            case '*':
                res=num1*num2;
                break;
            case '/':
                res=num2/num1;
            default:
                break;
        }
        return res;
    }
}

