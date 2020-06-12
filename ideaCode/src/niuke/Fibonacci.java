package niuke;

import java.util.Scanner;
//输入一个数字，从Fibonacci中找，找到最近的一个Fibonacci数字
public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int i=0;
        for(;i<n;i++){
            if(fibonacci(i)>n){
                break;
            }
        }
        int x=fibonacci(i)-n;
        int y= Math.abs(fibonacci(i-1)-n);
        if(x>y){
            System.out.println(y);
        }else{
            System.out.println(x);
        }

    }
    private static int fibonacci(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return fibonacci(n-1)+fibonacci(n-2);

    }
}
