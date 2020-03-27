package winter_homework;

public class SortArrayByParity {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,6,7,8,9,13,11};
        //偶数在前，奇数在后
        int left=0;
        int right=arr.length-1;
        while (left<right){
            if(arr[left]%2==0){
                left++;
            }else if(arr[right]%2==1){
                right--;
            }else{
                int temp=0;
                temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
            }
        }
        for(int x:arr){
            System.out.print(x+" ");
        }
    }
}
