package niuke;


import java.util.Scanner;

//n的阶乘末尾有多少个0

public class Factorial {
    //如果老老实实算阶乘会出现问题，溢出
    //所以只能算 出现5的次数
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int count=0;
        for(int i=0;i<n;i++){
            n/=5;
            count+=n;
        }
        System.out.println(count);
    }
}
