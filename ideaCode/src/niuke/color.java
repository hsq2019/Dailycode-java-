package niuke;

import java.util.Scanner;

public class color {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        String s2=sc.nextLine();
        int res=isColor(s1,s2);
        System.out.println(res);
    }
    public static int isColor(String s1,String s2){
        char[] c1=s1.toCharArray();
        char[] c2=s2.toCharArray();
        int num=0;
        for(int i=0;i<c2.length;i++){
            for(int j=0;j<c1.length;j++){
                if(c1[j]==c2[i]){
                    //把c2的每一位都和c1中每一位比较，如果相同，就改变c1中的那个值
                    c1[j]='1';
                    num++;
                    break;
                }
            }
        }
        return num;
    }
}
