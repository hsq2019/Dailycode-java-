package datastructure.sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        boolean flag=false;
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    flag=true;
                    int temp=0;
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            if(!flag){
                break;
            }else {
                flag=false;
            }
            System.out.println("第"+(i+1)+"次排序");
            for(int x:arr){
                System.out.print(x+" ");
            }
            System.out.println();
        }
        System.out.println("最终结果是");
        for(int x:arr){
            System.out.print(x+" ");
        }

    }
}
