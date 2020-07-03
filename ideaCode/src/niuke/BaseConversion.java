package niuke;



import java.util.Scanner;

public class BaseConversion {
    //ip地址之间的转换
    //先转换成二进制，再转成十进制，再按照位数转换成10进制
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String ip1=scanner.nextLine();
        long decimal2=scanner.nextLong();
        System.out.println(decimal1(ip1));
        System.out.println(ip2(decimal2));
    }
    private static long decimal1(String ip){
        //用.分割
        String[] s=ip.split("\\.");
        int[] arr=new int[s.length];
        for(int i=0;i<s.length;i++){
            arr[i]=Integer.parseInt(s[i]);
        }
        long x=0;
        for(int i=0;i<arr.length;i++){
            x=x<<8;
            x=x^arr[i];
        }
        return x;
    }
    private static String ip2(long decimal){
        StringBuilder sb=new StringBuilder();
        sb.append(String.valueOf((decimal>>>24)));
        sb.append(".");
        sb.append(String.valueOf((decimal&0x00FFFFFF)>>>16));
        sb.append(".");
        sb.append(String.valueOf((decimal&0x0000FFFF)>>>8));
        sb.append(".");
        sb.append(String.valueOf(decimal&0x000000FF));
        return sb.toString();
    }
}
