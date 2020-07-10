package datastructure.sort;

import java.util.Arrays;


//基数排序（桶排序的扩展）
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53, 3, 452, 748, 14, 214};
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();
        radixSort(arr, maxLength);
    }

    public static void radixSort(int[] arr, int maxLength) {
        //桶
        int[][] bucket = new int[10][arr.length];
        //记录每个同的有效数字个数
        int[] bucketElementCount = new int[10];
        //给桶里放数据
        for (int i = 0; i < maxLength; i++) {

            for (int y = 0; y < arr.length; y++) {
                int digit = (arr[y] / (int) Math.pow(10, i)) % 10;
                bucket[digit][bucketElementCount[digit]] = arr[y];
                bucketElementCount[digit]++;
            }
            //把数据重新放回arr数组中
            int num = 0;
            for (int x = 0; x < bucketElementCount.length; x++) {
                if (bucketElementCount[x] != 0) {
                    for (int l = 0; l < bucketElementCount[x]; l++) {
                        arr[num] = bucket[x][l];
                        num++;
                    }
                }
                bucketElementCount[x] = 0;
            }
            System.out.println("第" + (i + 1) + "次处理,arr是" + Arrays.toString(arr));
        }
    }
}
