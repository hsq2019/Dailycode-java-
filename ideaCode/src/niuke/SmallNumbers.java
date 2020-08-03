package niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SmallNumbers {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        int index=scanner.nextInt();
        String[] strings=s.split(",");
        int[] arr=new int[strings.length];
        for(int i=0;i<strings.length;i++){
            arr[i]=Integer.parseInt(strings[i]);
        }
        System.out.println(GetLeastNumbers_Solution(arr,index));;

    }
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        Arrays.sort(input);
        ArrayList<Integer> a=new ArrayList<>();
        for(int i=0;i<4;i++){
            a.add(input[i]);
        }
        return a;
    }
}
