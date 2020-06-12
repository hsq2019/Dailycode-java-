package niuke;

import java.util.Scanner;

public class Robot {
    //X*Y的网格，机器人只能向右走或者向下走，从左上角走到右下角，有多少种走法
    public int countWays(int x, int y) {
        // write code here
        int[][] arr=new int[x][y];
        for(int i=0;i<x;i++){
            arr[i][0]=1;
        }
        for(int j=0;j<y;j++){
            arr[0][j]=1;
        }
        for(int i=1;i<x;i++){
            for(int j=1;j<y;j++){
                arr[i][j]=arr[i-1][j]+arr[i][j-1];
            }
        }
        return arr[x-1][y-1];
    }
    public static void main(String[] args){
        Robot r=new Robot();
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int y=sc.nextInt();
        System.out.println(r.countWays(x,y));
    }
}
