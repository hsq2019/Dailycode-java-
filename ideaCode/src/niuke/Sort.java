package niuke;

public class Sort {
    public static void main(String[] args) {
        int[] arr={4,5,3,6,2,5,1};
//        System.out.println("冒泡");
//        bubble(arr);
        System.out.println("选择");
        select(arr);

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

}
