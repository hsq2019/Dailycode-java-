package niuke;

import java.util.Arrays;
import java.util.Scanner;

//每个测试输入包含空格分隔的n+1个整数，最后一个整数为k值,n不超过100

public class MinimumNumberOfK {
    //一串数字中最小的k个数
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextLine()){
            String s=sc.nextLine();
            String[] arr=s.split(" ");
            int n=Integer.valueOf(arr[arr.length-1]);
            int[] nums=new int[arr.length-1];
            for(int i=0;i< nums.length;i++){
                nums[i]=Integer.valueOf(arr[i]);
            }
            Arrays.sort(nums);
            for(int i=0;i<n;i++){
                System.out.print(nums[i]+" ");
            }
        }
    }
}
