package datastructure.search;

import jdk.nashorn.internal.ir.CallNode;

//二分查找（折半查找）
//要求数组是个有序数组
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr={1,2,5,7,8,9,10,10,18,20};
        int left=0;
        int right=arr.length-1;
        int res=binarySearch(arr, 10,right,left);
        if(res==-1){
            System.out.println("没找到！");
        }else{
            System.out.println("找到了，下标是"+res);
        }

    }
    public static int binarySearch(int[] arr,int value,int right,int left){
        if(right<left){
            return -1;
        }
        int mid=(right+left)/2;
        if(arr[mid]>value){
            return binarySearch(arr,value,mid-1,left);
        }else if(arr[mid]<value){
            return binarySearch(arr,value,right,mid+1);
        }else{
            return mid;
        }
    }
}
