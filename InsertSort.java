package datastructure.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

//插入排序
public class InsertSort {
    public static void main(String[] args) {
        int[] arr={17,3,25,14,20,9};
        insertSort(arr);

    }
    public static void insertSort(int[] arr){
        int insertVal=0;//要插入的数
        int insertIndex=0;//要插入的前面那个数的下标
        for(int i=0;i<arr.length-1;i++){
            insertVal=arr[i+1];
            insertIndex=i;
            while (insertIndex>=0&&insertVal<arr[insertIndex]){
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex+1]=insertVal;
            System.out.println(Arrays.toString(arr));
        }

    }
}
