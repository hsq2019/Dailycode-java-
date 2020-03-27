package datastructure.toinfixespression;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//中缀表达式转化成后缀表达式
public class ToInfixExpression {
    public static void main(String[] args) {
        //  1+((2+3)*4)-5  转换成  1 2 3 + 4 * + 5 -
        //  因为对str进行操作，不方便，将中缀表达式转化成对应的list
        //1+((2+3)*4)-5转成 ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]
        //中缀表达式list转化成后缀表达式list
        String expression="1+((2+3)*4)-5";
        List<String> infixExpression=toInfixExpressionList(expression);
        System.out.println("中缀表达式："+infixExpression);
        System.out.println("后缀表达式"+parseSuffixExpressionList(infixExpression));
    }
    //将中缀表达式转化成对应的list
    public static List<String> toInfixExpressionList(String s){
        List<String> ls=new ArrayList<>();//存放中缀表达式
        int i=0;//指针用于遍历字符串s
        String str;//用于做拼接
        char c;//遍历到每一个字符，放入到c
        do{
            //如果c是非数字
            if((c=s.charAt(i))<48||(c=s.charAt(i))>57){
                ls.add(""+c);
                i++;//i后移
            }else {
                //考虑多位数
                str="";
                while (i<s.length()&&(c=s.charAt(i))>=48&&(c=s.charAt(i))<=57){
                    str+=c;
                    i++;
                }
                ls.add(str);
            }
        }while (i<s.length());
        return ls;
    }
    public static List<String> parseSuffixExpressionList(List<String> ls){
        //定义俩栈 s1，s2
        Stack<String> s1=new Stack<>();//符号栈
        //s2栈 在整个转换中没有pop操作，还要逆序输出。可以直接使用List<String>
        //Stack<String> s2=new Stack<>();//存储中间结果的栈
        List<String> s2=new ArrayList<>();
        for(String item:ls){
            //如果是一个数字，那么加入s2
            if(item.matches("\\d+")){
                s2.add(item);
            }else if(item.equals("(")){
                s1.push(item);
            }else if(item.equals(")")){
                //如果是右括号，那么依次弹出s1栈顶运算符，并且压入s2，直到遇到左括号，此时将括号丢弃
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                //弹出s1中的左括号。作用是消除括号
                s1.pop();
            }else{
                //当item的优先级小于或等于栈顶优先级
                //那么s1弹出栈顶之后加入到s2中去，之后反复这个操作

                while (s1.size()!=0&&Operation.getValue(s1.peek())>=Operation.getValue(item)){
                    s2.add(s1.pop());
                }
                //之后将item压入栈s1
                s1.push(item);
            }

        }
        //s1剩余的内容加入到s2中
        while(s1.size()!=0){
            s2.add(s1.pop());
        }
        //按顺序输出
        return s2;
    }
}
//可以返回一个运算符的优先级
class Operation{
    private static int ADD=1;
    private static int SUB=1;
    private static int MUL=2;
    private static int DIV=2;
    //返回对应的优先级数字
    public static int getValue(String operation){
        int result=0;
        switch (operation){
            case "+":
                result=ADD;
                break;
            case "-":
                result=SUB;
                break;
            case "*":
                result=MUL;
                break;
            case "/":
                result=DIV;
                break;
            default:
                break;
        }
        return result;
    }
}


