package niuke;

import java.util.Scanner;
//X 共有两次比赛
//第一行输入参赛人数
//第二行输入 第一次比赛名次
//第三行输入 第二次比赛名次
//问X 这个人，最好能拿第几名，最坏能拿第几名
public class Ranking {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextLine()){
            String s=sc.nextLine();
            int n=Integer.valueOf(s);
            String s1=sc.nextLine();
            String s2=sc.nextLine();
            System.out.print(min(n,s1,s2)+" "+max(n,s1,s2));
            System.out.println();
        }
    }
    private static int min(int n,String s1,String s2){
        int num=0;
        String[] strings1=s1.split(" ");
        String[] strings2=s2.split(" ");

        int i;
        for(i=0;i<n;i++){
            if(strings1[i].equals("X")){
                break;
            }
        }
        int j;
        for(j=0;j<n;j++){
            if(strings2[j].equals("X")){
                break;
            }
        }
        for(int x=0;x<i;x++){
            for(int y=0;y<j;y++){
                if(strings1[x].equals(strings2[y])){
                    num++;
                }
            }
        }
        return num+1;
    }
    private static int max(int n,String s1,String s2){
        int num=0;
        String[] strings1=s1.split(" ");
        String[] strings2=s2.split(" ");
        int i;
        for(i=0;i<n;i++){
            if(strings1[i].equals("X")){
                break;
            }
        }
        int j;
        for(j=0;j<n;j++){
            if(strings2[j].equals("X")){
                break;
            }
        }
        for(int x=i+1;x<n;x++){
            for(int y=j+1;y<n;y++){
                if(strings1[x].equals(strings2[y])){
                    num++;
                }
            }
        }
        return (n-num);
    }
}