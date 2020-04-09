package datastructure.heap;

import java.util.Arrays;

//小堆的向下调整
//作用是可以把一个数组构建成堆
public class Heap {
    /**
     *
     * @param array array一个含堆数组
     * @param size 通过size指定array那些元素是有效堆元素
     * @param index 表示从index位置的下标开始调整
     */
    public static void shiftDown(int[] array,int size,int index){
        int parent=index;
        //先假设child是左孩子节点
        int child=parent*2+1;
        while (child<size){
            if (child + 1 < size && array[child] > array[child + 1]) {
                child=child+1;
                //这时候的child不知道是左节点还是右节点
                //确定的是child下标中存的是较小数字
            }
            //如果parent中的值大于child中的值，那么交换
            if(array[parent]>array[child]){
                int temp=array[parent];
                array[parent]=array[child];
                array[child]=temp;
            }else{
                //调整完毕
                break;
            }
            //更新条件
            parent=child;
            child=parent*2+1;
        }
    }
    public static void creatHeap(int[] array,int size){
        for(int i=(size-1-1)/2;i>=0;i--){
            shiftDown(array,size,i);
        }
    }

    public static void main(String[] args) {
        int[] array={9,5,2,7,3,6,8};
        creatHeap(array,array.length);
        System.out.println(Arrays.toString(array));
    }
}
