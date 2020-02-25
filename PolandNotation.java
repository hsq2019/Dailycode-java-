package datastructure.stack;

import java.util.*;

public class PolandNotation {
    public static void main(String[] args) {
        //定义个逆波兰表达式
        String suffixExpression="3 4 + 50 * 6 -";
        //先把字符串放到一个字符数组中
        List<String> rpnList=getListString(suffixExpression);
        int res=calculate(rpnList);
        System.out.println(res);

    }
    //运算方法
    public static int calculate(List<String> ls){
        Stack<Integer> stack=new Stack<>();
        for(String s:ls){
            switch (s){
                case "+":
                    stack.push(stack.pop()+stack.pop());
                    break;
                case "-":
                    int num=stack.pop();
                    stack.push(stack.pop()-num);
                    break;
                case "*":
                    stack.push(stack.pop()*stack.pop());
                    break;
                case "/":
                    num=stack.pop();
                    stack.push(stack.pop()/num);
                default:
                    stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
    //将字符串分割
    public static List<String> getListString(String suffixExpression){
       //将 suffixExpression分割
        String[] split=suffixExpression.split(" ");//按照空格分割
        List<String> list=new ArrayList<String>();
        for(String s:split){
            list.add(s);
        }
        return list;
    }


}
