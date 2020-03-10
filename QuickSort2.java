package datastructure.sort;

import java.util.Arrays;

//快速排序
public class QuickSort2 {
    public static void main(String[] args) {
        int[] arr={1,8,0,9,2,5,2,9,3,7};
        quickSort2(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    /**
     *
     * @param arr 数组
     * @param leftIndex 左边起始位置
     * @param rightIndex 右边起始位置
     */
    public static void quickSort2(int[] arr,int leftIndex,int rightIndex){
        //递归出口
        if(leftIndex>=rightIndex){
            return;
        }
        int l=leftIndex;
        int r=rightIndex;
        //key的值是左边的第一个
        int key=arr[l];
        while(l<r){
            //从循环里先从右边看
            while (l<r&&arr[r]>=key){
                r--;
            }
            arr[l]=arr[r];
            while (l<r&&arr[l]<=key){
                l++;
            }
            arr[r]=arr[l];
        }
        arr[l]=key;
        //左递归
        quickSort2(arr,leftIndex,r-1);
        //右递归
        quickSort2(arr,l+1,rightIndex);
    }
}
