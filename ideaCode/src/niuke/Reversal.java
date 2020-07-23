package niuke;

import java.util.Scanner;
import java.util.Stack;

public class Reversal {
    //对字符串的单词进行倒排
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String s=scanner.nextLine();
            String[] str=s.split(" ");

            Stack<String> stack=new Stack<>();
            for(int i=0;i<str.length;i++){
                stack.push(str[i]);
            }

            StringBuilder sb=new StringBuilder();
            while (!stack.isEmpty()){
                sb.append(stack.pop());
                sb.append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb.toString());
        }
    }
}
