package niuke;

import java.util.ArrayList;
import java.util.List;

public class FindNumsAppearOnce {
    //数组中有两个数字只出现了一次，其他数字都只出现两次
    public static void main(String[] args) {
        int[] arr={1,1,2,2,3,4,5,5};
        findNumsAppearOnce(arr);
    }

    private static void findNumsAppearOnce(int[] arr){
        int n=0;
        for (int i=0;i<arr.length;i++){
            n^=arr[i];
        }
        int i=0;
        for(;i<31;i++){
            if((n&1)==1){
                break;
            }else {
                n=n>>1;
            }
        }
        List<Integer> a1=new ArrayList<>();
        List<Integer> a2=new ArrayList<>();
        for(int j=0;j<arr.length;j++){
            if(((arr[j]>>i)&1)==0){
                a1.add(arr[j]);
            }else {
                a2.add(arr[j]);
            }
        }
        int num1=0;
        int num2=0;
        for (int x=0;x<a1.size();x++){
            num1^=a1.get(x);
        }
        for (int y=0;y<a2.size();y++){
            num2^=a2.get(y);
        }
        System.out.println(num1+" "+num2);
    }
}
