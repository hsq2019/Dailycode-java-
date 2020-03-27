package winter_homework;
import sun.awt.windows.WPrinterJob;

import java.util.*;
public class Home {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        System.out.println(myAtoi(s));

    }

    public static int myAtoi(String str) {
        long res=0;
        int i=0;
        boolean f=false;
        for(i=0;i<str.length();i++){
            if(str.charAt(i)!=' '){
                break;
            }
        }
        if(i>=str.length()){
            return 0;
        }
        if(str.charAt(i)=='+'||str.charAt(i)=='-'){
            f=str.charAt(i)=='-'?true:false;
        }else if(Character.isDigit(str.charAt(i))){
            res=str.charAt(i)-'0';
        }else{
            return 0;
        }
        for(int j=i+1;j<str.length();j++){
            if(Character.isDigit(str.charAt(j))){
                res=res*10+(str.charAt(j)-'0');
            } else{
                break;
            }
        }
        if ((int)res!= res) {
            if(!f){
                return 2147483647;
            }else{
                return -2147483648;
            }
        }
        if(f){
            res=res*(-1);
        }
        return (int)res;
    }
}
//        String str=new String("hello");
//        char[]ch={'a','b'};
//        public static void main(String args[]){
//            Home ex=new Home();
//            ex.change(ex.str,ex.ch);
//            System.out.print(ex.str+" and ");
//            System.out.print(ex.ch);
//        }
//        public void change(String str,char ch[]){
//            str="test ok";
//            ch[0]='c';
//    }
//    public static void main(String[] args) {
//        System.out.println("value="+switchit(4));
//    }
//    public static int switchit(int x){
//        int j=1;
//        switch (x){
//            case 1:j++;
//            case 2:j++;
//            case 3:j++;
//            case 4:j++;
//            case 5:j++;
//            default:j++;
//        }
//        return j+x;
//    }

