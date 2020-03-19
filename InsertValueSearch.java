package datastructure.search;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

//差值查找

//数组是有序的


public class InsertValueSearch {
    public static void main(String[] args) {
//        int[] arr=new int[100];
//        for(int i=0;i<100;i++){
//            arr[i]=i+1;
//        }
        int[] arr={1,2,5,7,8,9,10,10,18,20};
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入你想查找的值");
        int value=scanner.nextInt();
        int res=insertValueSearch(arr,0,arr.length-1,value);
        System.out.println("该数的下标是"+res);

    }

    //编写插值查找
    //假设是个升序有序数组
    public static int insertValueSearch(int[] arr, int low, int high, int value) {
        if (low > high || value < arr[0] || value > arr[arr.length - 1]) {
            return -1;
        }
        int mid=low+(high-low)*(value-arr[low])/(arr[high]-arr[low]);
        if(arr[mid]>value){
            return insertValueSearch(arr,low,mid-1,value);
        }else if(arr[mid]<value){
            return insertValueSearch(arr,mid+1,high,value);
        }else{
            return mid;
        }
    }
}
