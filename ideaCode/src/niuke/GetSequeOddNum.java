package niuke;

import java.io.BufferedReader;
import java.util.Scanner;

public class GetSequeOddNum {
    //尼科撤定理
    //任何一个整数m的立方都可以写成m个连续奇数之和
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        StringBuilder sb=new StringBuilder();
        int num=n*n-n+1;
        sb.append(num);
        for(int i=1;i<n;i++){
            sb.append("+");
            sb.append(num+=2);
        }
        System.out.println(sb.toString());
    }
}
