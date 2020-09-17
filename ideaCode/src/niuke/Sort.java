package niuke;

import java.security.UnrecoverableEntryException;
import java.util.Arrays;
import java.util.Queue;

//冒插归为稳
//冒插选n方
public class Sort {
    public static void main(String[] args) {
        int[] arr={4,5,3,6,2,5,1};
//        System.out.println("冒泡");
//        bubble(arr);
//        System.out.println("选择");
//        select(arr);
//        System.out.println("插入");
//        insertSort(arr);
//        System.out.println("希尔");
//        shell(arr);
//        System.out.println("快排");
//        QuickSort(arr,0,arr.length-1);
//        System.out.println(Arrays.toString(arr));
//        System.out.println("堆排");
//        heap(arr);
        System.out.println("归并");
        mergeSort(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));

    }
    //冒泡
    private static void bubble(int[] arr){
        //比较次数
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    //选择排序
    //在a[0]-a[n-1]中选择一个最小的数字和a[0]交换
    private static void select(int[] arr){

        for(int i=0;i<arr.length-1;i++){
            int j=i;
            int min=arr[j];
            int minIndex=j;
            for(;j<arr.length;j++){
                if(min>arr[j]){
                    min=arr[j];
                    minIndex=j;
                }
            }

            if(arr[i]!=min){
                int temp=arr[i];
                arr[i]=arr[minIndex];
                arr[minIndex]=temp;
            }
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    //插入排序
    private static void insertSort(int[] arr){
        int insert=0;//要插入的值
        int insertIndex=0;//将要被插入的下标
        for(int i=0;i<arr.length-1;i++){
            insert=arr[i+1];
            insertIndex=i;
            while (insertIndex>=0&&insert<arr[insertIndex]){
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex+1]=insert;
        }
        System.out.println(Arrays.toString(arr));
    }

    //希尔排序，和插入排序很类似，就只是把数组分了组。之后再进行插排
    //时间复杂度是n^1.3
    private static void shell(int[] arr){
        int grep=arr.length/2;
        while (grep>1){
            insertGrep(arr,grep);
            grep=grep/2;
        }
        insertGrep(arr,1);
        System.out.println(Arrays.toString(arr));
    }
    private static void insertGrep(int[] arr,int grep){
        for(int bound=grep;bound<arr.length;bound++){
            int insert=arr[bound];//插入的数字
            int insertIndex=bound-grep;
            while (insertIndex>=0&&arr[insertIndex]>insert){
                arr[insertIndex+grep]=arr[insertIndex];
                insertIndex-=grep;
            }
            insertIndex=insertIndex+grep;
            arr[insertIndex]=insert;
        }
    }

    //快速排序
    private static void QuickSort(int[] arr,int left,int right){
        if(left>right){
            return;
        }
        int num=arr[left];
        int l=left;
        int r=right;
        //找到右边比num小的数的下标
        while (l<r) {
            while (l<r&&arr[r]>=num){
                r--;
            }
            arr[l]=arr[r];
            while (l<r&&arr[l]<=num){
                l++;
            }
            arr[r]=arr[l];
        }
        arr[l]=num;
        QuickSort(arr,left,l-1);
        QuickSort(arr,l+1,right);
    }

    //堆排序
    private static void heap(int[] arr){
        heapCreat(arr);
        //升序的话，建个大堆，之后把堆顶的元素和数组中最后一个元素交换位置
        for(int i=0;i<arr.length-1;i++){
            swap(arr,arr.length-1-i,0);
            //进行向下调整
            Down(arr,arr.length-1-i,0);
        }
        System.out.println(Arrays.toString(arr));
    }
    private static void swap(int[] arr,int x,int y ){
        int temp=arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }
    private static void heapCreat(int[] arr){
        for(int i=(arr.length-1-1)/2;i>=0;i--){
            Down(arr,arr.length,i);
        }
    }
    private static void Down(int[] arr,int heapLength,int index){
        int parent=index;
        int child=parent*2+1;
        while (child<heapLength){
            if(child+1<heapLength&&arr[child]<arr[child+1]){
                child=child+1;//最大的
            }
            if(arr[child]>arr[parent]) {
                swap(arr, child, parent);
            }else {
                break;
            }
            parent=child;
            child=child*2+1;
        }
    }


    //归并
    private static void mergeSort(int[] arr,int low,int high){
        //先分解
        if(high-low<=1){
            //说明数组里面只有一个或者0个元素
            return;
        }
        int mid=(high+low)/2;
        //分
        mergeSort(arr,low,mid);
        mergeSort(arr,mid,high);
        //和
        merge(arr,low,high,mid);

    }
    private static void merge(int[] arr,int low,int high,int mid){
        int[] output=new int[high-low];
        int outputIndex=0;//数组的长度
        int size=mid;
        int num=low;
        while (num<size&&size<high){
            if(arr[num]>arr[size]){
                output[outputIndex]=arr[size];
                outputIndex++;
                size++;
            }else {
                output[outputIndex]=arr[num];
                outputIndex++;
                num++;
            }
        }
        while (num<mid){
            output[outputIndex]=arr[num];
            num++;
            outputIndex++;
        }
        while (size<high){
            output[outputIndex]=arr[size];
            size++;
            outputIndex++;
        }
        for(int i=0;i<high-low;i++){
            arr[low+i]=output[i];
        }
    }

}
