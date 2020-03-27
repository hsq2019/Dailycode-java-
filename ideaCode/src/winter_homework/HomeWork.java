package winter_homework;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import java.util.Scanner;
public class HomeWork {
    public static void main(String[] args) {
//        int x=20;
//        int y=5;
//        System.out.println(x+y+y+""+x+y+y);
         Scanner scanner=new Scanner(System.in);
         String str=scanner.nextLine();
        System.out.println(toLowerCase(str));
    }


    public static int remove(int[] nums,int val) {
        if(nums.length==0){
            return 0;
        }
        int j=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;

    }

    public static void rotate(int[] nums,int k){
        while(k>0){
            int temp=nums[nums.length-1];
            for(int i=nums.length-1;i>0;i--){
                nums[i]=nums[i-1];
            }
            nums[0]=temp;
            k--;
        }
    }
    public static String toLowerCase(String str){
        char[] chars=str.toCharArray();//将字符串转成字符数组
        for(int i=0;i<chars.length;i++){
            if(chars[i]>='A'&&chars[i]<='Z'){
                chars[i]=(char)(chars[i]-'A'+'a');
            }
        }
        return String.valueOf(chars);
    }
    public static void fun(int a){
        System.out.println(a%10);
        if(a/10!=0){
            fun(a/10);
        }
        System.out.println(a%10);
    }
}
