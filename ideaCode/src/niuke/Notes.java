package niuke;

import java.util.Scanner;
import java.util.Stack;

public class Notes {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String a=sc.nextLine();
        char[] c=new char[a.length()];
        for(int i=0;i<a.length();i++){
            c[i]=a.charAt(i);
        }
        System.out.println(conversion(c));
    }
    private static String conversion(char[] c){
        StringBuilder sb=new StringBuilder();
        Stack<Character> stack=new Stack<>();
        int is=0;
        for(int i=0;i<c.length;i++){
            if(c[i]=='('){
                is++;
                continue;
            }
            if(c[i]==')'){
                is--;
                continue;
            }
            if(c[i]=='<'&&(is==0)){
                stack.pop();
                continue;
            }
            if(is==0){
                stack.push(c[i]);
            }
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
