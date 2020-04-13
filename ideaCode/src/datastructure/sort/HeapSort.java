package datastructure.sort;


import java.util.Arrays;

import static datastructure.heap.Heap.shiftDown;
//堆排序
//升序建大堆
//1交换堆顶元素与堆的最后一个元素
//2移去堆底元素(确保了最后一个是最大的)
//3之后进行大堆的向下调整，确保堆的内容还是大堆
//循环123
public class HeapSort {
    public static void main(String[] args) {
        int[] array={9,5,2,3,6,8,1,7,4};
        heapSort(array);
        System.out.println(Arrays.toString(array));

    }

    private static void heapSort(int[] array) {
        createHeap(array);
        for(int i=0;i<array.length-1;i++){
            swap(array,0,array.length-1-i);
            shiftDown(array,array.length-1-i,0);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }

    private static void createHeap(int[] array) {
        for(int i=(array.length-1-1)/2;i>=0;i--){
            shiftDown(array,array.length,i);
        }
    }
    private static void shiftDown(int[] array,int size,int index){
        int parent=index;
        int child=2*parent+1;
        while (child<size){
            if(child+1<size&&array[child+1]>array[child]){
                swap(array,child,child+1);
            }
            if(array[parent]<array[child]){
                swap(array,parent,child);
            }else {
                break;
            }
            parent=child;
            child=parent*2+1;
        }
    }


}
