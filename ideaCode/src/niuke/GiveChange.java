package niuke;


import java.util.Scanner;

public class GiveChange {
    //在霍尔沃兹找零钱
    //17sickle=galleon
    //29knut=sickle
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.next();//应付款
        String[] arr1=s.split("\\.");
        String e=scanner.next();//实付款
        String[] arr2=e.split("\\.");
        long[] a1={Long.parseLong(arr1[0]),
                Long.parseLong(arr1[1]),
                Long.parseLong(arr1[2]),
        };
        long[] a2={Long.parseLong(arr2[0]),
                Long.parseLong(arr2[1]),
                Long.parseLong(arr2[2]),
        };

        String res=help(a1,a2);
        System.out.println(res);


    }
    private static String help(long[] arr1,long[] arr2){
        long n1=arr1[0]*17*29+arr1[1]*29+arr1[2];
        long n2=arr2[0]*17*29+arr2[1]*29+arr2[2];
        long num=n2-n1;
        StringBuilder sb=new StringBuilder();
        sb.append(num/(29*17));
        sb.append(".");
        long num2=num%(29*17);
        sb.append(num2/29);
        sb.append(".");
        sb.append(num%29);
        return sb.toString();
    }
}
