package niuke;

import java.util.Arrays;

public class Permutation {
    //数组的全排列
    public static void main(String[] args) {
        int[] arr={1,2,3};
        permute(arr,0);
    }
    private static void permute(int[] arr,int start){
        if(start==arr.length-1){
            System.out.println(Arrays.toString(arr));
        }else {
            for(int i=start;i<arr.length;++i){
                swap(arr,start,i);
                permute(arr,start+1);
                swap(arr,start,i);
            }
        }
    }
    private static void swap(int[] arr,int x,int y){
        int temp=arr[y];
        arr[y]=arr[x];
        arr[x]=temp;
    }
}
