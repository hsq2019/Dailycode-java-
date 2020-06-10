package niuke;

//小易有一个网络盒子，网络盒子的行号为0~H-1，网格的列编号，0~W-1，每个给最多放一个蛋糕
//任意两块蛋糕的偶极里德距离不能等于2.
//((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2))的算术平方根

import java.util.Scanner;

//网格的行或者列能被4整除的话，那就可以放蛋糕的数量是 行*列/2
//如果不是的话，可以放蛋糕的数量是 行*列/2-1
public class Cake {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
            int x=sc.nextInt();
            int y=sc.nextInt();
            int count=0;
            if((x%4==0)||(y%4==0)){
               count=x*y/2;
            }else{
                count=x*y/2+1;
            }
        System.out.println(count);
        }
}
