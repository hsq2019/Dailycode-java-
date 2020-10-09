package niuke;

import java.util.Scanner;

public class Add_niuke {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num1=scanner.nextInt();
        int num2=scanner.nextInt();
        while (num2!=0){
            int temp=num1^num2;
            num2=(num1&num2)<<1;
            num1=temp;
        }
        System.out.println("相加结果是"+num1);
    }
}
