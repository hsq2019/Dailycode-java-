package datastructure.sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr={109,11,5,111,4};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    //选择排序
    public static void selectSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int minIndex=i;
            int min=arr[i];
            for(int j=i+1;j<arr.length;j++){
                if(min>arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if(arr[minIndex]!=arr[i]){
                arr[minIndex]=arr[i];
                arr[i]=min;
            }
        }
    }
}
