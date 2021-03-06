package datastructure.sort;

import java.util.Arrays;

//归并排序
public class MergeSort {
    public static void main(String[] args) {
        int[] arr={1,3,5,7,2,2,3,5,4,9,6};
        int[] temp=new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }

    //拆分
    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if(left<right){
            int mid=(left+right)/2;
            //左分
            mergeSort(arr,left,mid,temp);
            //右分
            mergeSort(arr,mid+1,right,temp);
            //合并
            merge(arr,left,right,mid,temp);

        }

    }



    //合并
    public static void merge(int[] arr,int left,int right,int mid,int[] temp){
        int i=left;
        int j=mid+1;
        int t=0;
        while (i<=mid&&j<=right){
            if(arr[i]<arr[j]){
                temp[t]=arr[i];
                t++;
                i++;
            }else {
                temp[t]=arr[j];
                t++;
                j++;
            }
        }
        while (i<=mid){
            temp[t]=arr[i];
            t++;
            i++;
        }
        while (j<=right){
            temp[t]=arr[j];
            t++;
            j++;
        }

        t=0;
        int tempLeft=left;
        while (tempLeft<=right){
            arr[tempLeft]=temp[t];
            t++;
            tempLeft++;
        }


    }

}
