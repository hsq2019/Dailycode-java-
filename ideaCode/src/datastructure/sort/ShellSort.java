package datastructure.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

//希尔排序
//优化的插入排序

public class ShellSort {
    public static void main(String[] args) {
        int[] arr1={8,9,1,7,2,3,5,4,6,0};
        int[] arr2={8,9,1,7,2,3,5,4,6,0};
        shellSort1(arr1);
        shellSort2(arr2);

    }
    //对有序序列进行插入时使用的是交换法
    //效率相对较低
    public  static void shellSort1(int[] arr){
        int dk=arr.length/2;
        System.out.println("这是交换法");
        while(dk>0){
            //分成了dk个组
            for(int i=dk;i<arr.length;i++){
                //在组内进行插入排序，这个是交换法
                for(int j=i-dk;j>=0;j-=dk){
                    if(arr[j]>arr[j+dk]){
                        int temp=0;
                        temp=arr[j+dk];
                        arr[j+dk]=arr[j];
                        arr[j]=temp;
                    }
                }
            }
            System.out.println(Arrays.toString(arr));
            dk/=2;
        }
    }
    //对有序序列进行插入时使用的是移动法（对交换法的优化）
    //效率相对较高
    public static void shellSort2(int[] arr){
        System.out.println("这是移动法");
        int dk=arr.length/2;
        while(dk>0){
            for(int i=dk;i<arr.length;i++){
                int j=i;
                int temp=arr[j];
                if(arr[j]<arr[j-dk]){
                    while (j-dk>=0&&temp<arr[j-dk]){
                        arr[j]=arr[j-dk];
                        j-=dk;
                    }
                    arr[j]=temp;
                }
            }
            System.out.println(Arrays.toString(arr));
            dk/=2;
        }
    }
}
