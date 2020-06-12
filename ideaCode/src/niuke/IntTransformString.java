package niuke;

import java.util.Scanner;

//int转化成逆置字符串
//例子 100-----001
public class IntTransformString {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String s=String.valueOf(n);
        StringBuilder sb=new StringBuilder(s);
        s=sb.reverse().toString();
        System.out.println(s);
    }
}
