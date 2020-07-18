package datastructure.search;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
//二分查找的优化
public class BinarySearch2 {
    public static void main(String[] args) {
        int[] arr={1,2,5,7,8,9,10,10,18,20};
        System.out.println("请输入你想查找的值");
        Scanner scanner=new Scanner(System.in);
        int value=scanner.nextInt();
        int left=0;
        int right=arr.length-1;
        List<Integer> reaList=binarySearch2(arr,value,left,right);
        System.out.println(reaList);
    }
    public static List binarySearch2(int[] arr,int value,int left,int right){
        //如果找不到，返回一个空的ArrayList
        if(right<left){
            return new ArrayList();
        }
        int mid=(left+right)/2;
        if(arr[mid]>value){
            return binarySearch2(arr,value,left,mid-1);
        }else if(arr[mid]<value){
            return binarySearch2(arr,value,mid+1,right);
        }else{
            List<Integer> resList=new ArrayList<Integer>();
            //先找左边的
            int temp=mid-1;
            while (true){
                if(temp<0||arr[temp]!=value){
                    break;
                }
                resList.add(temp);
                temp--;
            }
            //把中间的mid放进去
            resList.add(mid);
            //开始找右边
            temp=mid+1;
            while(true){
                if(temp>right||arr[temp]!=value){
                    break;
                }
                resList.add(temp);
                temp++;
            }
            return resList;
        }
    }
}
