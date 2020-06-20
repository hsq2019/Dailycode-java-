package niuke;

import java.util.Scanner;

public class Square {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        char c=sc.next().charAt(0);
        for(int i=1;i<=n;i++){
            System.out.print(c);
        }
        System.out.println();
        for(int i=1;i<=Math.ceil((double)n/2)-2;i++){
            System.out.print(c);
            for(int j=2;j<=n-1;j++){
                System.out.print(" ");
            }
            System.out.println(c);
        }
        for(int i=1;i<=n;i++){
            System.out.print(c);
        }
    }
}
