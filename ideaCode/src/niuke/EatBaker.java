package niuke;

import java.util.Scanner;

public class EatBaker {
    //小易吃贝克
    //饥饿的小易
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long x0=sc.nextLong();
        long m=1000000007;
        long s=100000;//使用神秘力量的次数
        long[] arr=new long[3];
        arr[0]=x0;
        arr[1]=(4*x0+3)%m;
        arr[2]=(8*x0+7)%m;
        long min=s;
        int step=0;
        long cur=0;
        for(int i=0;i<3;i++){
            cur=arr[i];
            step=i;
            while (cur!=0&&step<min){
                cur=(8*cur+7)%m;
                step++;
            }
            min=min<step?min:step;
        }
        if(min<s){
            System.out.println(min);
        }else{
            System.out.println(-1);
        }
    }
}
