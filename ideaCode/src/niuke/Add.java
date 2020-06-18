package niuke;

import java.math.BigInteger;
import java.util.Scanner;

public class Add {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String a=sc.nextLine();
        String b=sc.nextLine();
        System.out.println(AddLongInteger(a,b));
    }
    public static String AddLongInteger(String a,String b){
//        char[] arr1=a.toCharArray();
//        char[] arr2=b.toCharArray();
        BigInteger c=new BigInteger(a);
        BigInteger d=new BigInteger(b);
        BigInteger sum=c.add(d);
        return sum.toString();
    }
}
