package niuke;

import java.util.Scanner;

public class Change {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        String res=change(s);
        System.out.println(res);
    }
    private static String change(String s){
        char[] arr=s.toCharArray();
        int i=0;
        StringBuilder sb=new StringBuilder();
        while (i<arr.length-1){
            int num=1;
            while (i<arr.length-1&&arr[i]==arr[i+1]){
                i++;
                num++;
            }
            sb.append(num);
            sb.append(arr[i]);
            i++;
        }
            i--;
            if (arr[i - 1] != arr[i]) {
                sb.append(1);
                sb.append(arr[i]);
            }
            return sb.toString();
    }
}
