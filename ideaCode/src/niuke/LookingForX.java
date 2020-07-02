package niuke;

import java.util.Scanner;

public class LookingForX {
    //寻找x
    //输入一个数字n，之后再输入n个数，再输入x，在n个数中找x，找到了返回下标，没找到返回-1
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextInt()){
            int n=scanner.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=scanner.nextInt();
            }
            int x=scanner.nextInt();
            int res=find(arr,x);
            System.out.println(res);
        }
    }
    private static int find(int[] arr,int x){
        int res=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==x){
                return i;
            }
        }
        return res;
    }
}
