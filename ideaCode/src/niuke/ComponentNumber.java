package niuke;

import java.util.Arrays;
import java.util.Scanner;

public class ComponentNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String[] arr=s.split(" ");
        Arrays.sort(arr);
        StringBuilder sb=new StringBuilder();
        int i;
        for (i=0;i<arr.length;i++){
            if(!"0".equals(arr[i])){
                sb.append(arr[i]);
                break;
            }
        }
        for(int j=0;j<i;j++){
            sb.append(arr[j]);
        }
        for(int j=i+1;j<arr.length;j++){
            sb.append(arr[j]);
        }
        System.out.println(sb.toString());
    }
}
