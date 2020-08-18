package niuke;


import java.util.Scanner;

public class StringAndSubstring  {
    public static void main(String[] args) {
        int sum=0;
        Scanner sc=new Scanner(System.in);
        //输入A B
        //A为主串
        //B为子串
        String A=sc.nextLine();
        String B=sc.nextLine();
        if(A.length()<B.length()){
            return;
        }
        int la=A.length();
        int lb=B.length();
        //使用hash来解
        int hashA=hash(A.substring(0,lb));
        int hashB=hash(B);
        for(int i=0;i<=la-lb;i++){
            if(hashA==hashB&&compare(B,A.substring(i,lb+i))){
                sum++;
            }
            if(i<la-lb){
                hashA=hash(A.substring(i+1,lb+i+1));
            }
        }
        System.out.println(sum);
    }
    private static int hash(String s){
        int n=0;
        for(int i=0;i<s.length();i++){
            n+=s.charAt(i)-'0';
        }
        return n;
    }

    private static boolean compare(String b,String a){
        return b.equals(a);
    }
}
