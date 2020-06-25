package niuke;

import java.util.Scanner;

public class AppearsOnce {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n=scanner.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=scanner.nextInt();
            }
            int[] a=help(arr);
            System.out.println(a[0]+" "+a[1]);
        }
    }
    public static int[] help(int[] arr){
        int[] a=new int[2];
        int num=0;
        for(int i=0;i<arr.length;i++){
            num=num^arr[i];
        }
        int i=0;
        for(;i<32;i++){
            if(((num>>1)&1)==1){
                break;
            }
        }
        int bit=1<<i;
        int x=0;
        int y=0;
        for(int n:arr){
            if((n&bit)==0){
                x^=n;
            }else{
                y^=n;
            }
        }
        if(x>y){
            a[0]=y;
            a[1]=x;
            return a;
        }
        a[0]=x;
        a[1]=y;
        return a;
    }
}
