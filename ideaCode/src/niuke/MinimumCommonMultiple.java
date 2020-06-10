package niuke;

import java.util.Scanner;

//最小公倍数
public class MinimumCommonMultiple {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int y=sc.nextInt();
        if(x<y){
            int temp=x;
            x=y;
            y=temp;
        }
        int num=help(x,y);
        int res=(x/num)*y;
        System.out.println(res);
    }
    //辗转相除法
    public static int help(int big,int small){
        if(small==0){
            return big;
        }
        int r=big%small;
        return help(small,r);
    }
}
