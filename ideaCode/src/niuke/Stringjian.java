package niuke;

import java.util.Scanner;

public class Stringjian {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(stringJian(s));
    }
    private static String stringJian(String s){
        char[] c=s.toCharArray();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<c.length;i++){
            if(i!=0){
                i--;
            }
            char tem=c[i];
            int index=0;
            while (i<c.length){
                if(c[i]==tem){
                    i++;
                    index++;
                }else {
                    sb.append(tem);
                    sb.append(index);
                    break;
                }
            }
        }
        int i=c.length-1;
        char temp=c[c.length-1];
        int index=0;
        while (i>=0){
            if(c[i]==temp){
                index++;
                i--;
            }else {
                sb.append(temp);
                sb.append(index);
                break;
            }
        }
        return sb.toString();
    }
}
