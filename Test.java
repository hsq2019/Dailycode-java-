package java_learn;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.*;
public class Test {
    public static void main(String[] args) {
        // Scanner scanner=new Scanner(System.in);
        int[] arr = new int[]{1,2,3};
        System.out.println(avg(arr));
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = i + 1;
//        }
//        transform(arr);
//        for(int x:arr){
//            System.out.println(x);
//        }
        //  int n=scanner.nextInt();
        // System.out.println("青蛙跳法总数是"+frogJmp(n));
    }

    public static void printArray(int[] a) {
        for (int x : a) {
            System.out.println(x);
        }
    }

    public static void transform(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = a[i] * 2;
        }
    }

    public static int sum(int[] a){
        int sum=0;
        for(int x:a){
            sum+=x;
        }
        return sum;
    }
    public static double avg(int[] a){
        double avg1=sum(a)/a.length;
        return avg1;
    }

//    public static String toString(int[] a){
//        String ret="[";
//        for(int i=0;i<a.length;i++){
//            if(i==a.length-1){
//                ret+=a[i];
//                ret+="]";
//            }else{
//                ret+=a[i];
//                ret+=",";
//            }
//        }
//        return ret;
//    }

    public static int[] copyOf(int[] a,int len){
        int[] arr=new int[len];
        for(int i=0;i<len;i++){
            arr[i]=a[i];
        }
        return arr;

    }
    public static boolean find(int[] a,int n){
        int left=0;
        int right=a.length-1;
        int mid=0;
        while(left<right){
            mid=(left+right)/2;
            if(a[mid]>n){
                right=mid-1;
            }else if(a[mid]<n){
                left=mid+1;
            }else{
                return true;
            }
        }
        return false;
    }

    public static boolean isSequence(int[] a){
        for(int i=0;i<a.length-1;i++){
            if(a[i]>a[i+1]){
                return false;
            }
        }
        return true;
    }

    public static int[] bubble(int[] a){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length-i-1;j++){
                if(a[j]>a[j+1]){
                    int temp=0;
                    temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
        return a;
    }


}



//    public static int frogJmp(int n) {
//        if(n>2){
//            return frogJmp(n-1)*2;
//        }else if(n<=0){
//            return 0;
//        }else {
//            return n;
//        }
//    }
//}

//        Scanner scanner=new Scanner(System.in);
//
//        String str=scanner.nextLine();
//        System.out.println(isPalindrome(str) );
//        }
//    public static boolean isPalindrome(String s) {
//        if(s.length()==0){
//            return true;
//        }
//        int left=0;
//        int right=s.length()-1;
//        while(left<=right){
//            if(!Character.isLetter(s.charAt(left))){
//                left++;
//            }else if(!Character.isLetter(s.charAt(right))){
//                right--;
//            }else{
//                int l=0,r=0;
//                if(Character.isUpperCase(s.charAt(left))){
//                    l=s.charAt(left)-'A';
//                }else{
//                    l=s.charAt(left)-'a';
//                }
//                if(Character.isUpperCase(s.charAt(right))){
//                    r=s.charAt(right)-'A';
//                }else{
//                    r=s.charAt(right)-'a';
//                }
//                if(l!=r){
//                    return false;
//                }
//                left++;
//                right--;
//            }
//        }
//        return true;



//    public static int plus(int n){
//        if(n==1){
//            return 1;
//        }else if(n==0){
//            return 0;
//        }else{
//            return n+plus(n-1);
//        }
//    }
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        System.out.print("请输入你的数n：");
//        int n=scanner.nextInt();
//        System.out.println("从1加到"+n+"="+plus(n));
//    }
//    public static int max(int num1,int num2){
//        if(num1>num2){
//            return num1;
//        }else if(num1<num2){
//            return num2;
//        }else{
//            return num1;
//        }
//    }
//    public static double max(double num3,double num4) {
//        if ((num3-num4)>0) {
//            return num3;
//        } else if ((num3-num4)<0) {
//            return num4;
//        } else {
//            return num3;
//        }
//    }
//    public static void comp(int num2,double num3,double num4){
//        if(num2-max(num3,num4)>0){
//            System.out.println(num2+"最大");
//            System.out.println(max(num3,num4)+"其次");
//            if(max(num3,num4)==num3){
//                System.out.println(num4+"最小");
//            }else if(max(num3,num4)==num4){
//                System.out.println(num3+"最小");
//            }
//        }else{
//            System.out.println(max(num3,num4)+"最大");
//            if(max(num3,num4)==num3){
//                if(num2-num4>0){
//                    System.out.println(num2+"其次");
//                    System.out.println(num4+"最小");
//                }else{
//                    System.out.println(num4+"其次");
//                    System.out.println(num2+"最小");
//                }
//            }else if(max(num3,num4)==num4){
//                if(num2-num3>0){
//                    System.out.println(num2+"其次");
//                    System.out.println(num3+"最小");
//                }else{
//                    System.out.println(num3+"其次");
//                    System.out.println(num2+"最小");
//                }
//            }
//        }
//    }
//    public static void main(String[] args) {
//        int num1=5;
//        int num2=7;
//        double num3=1.2;
//        double num4=5.4;
//        System.out.println("两个整数的最大值是"+max(num1,num2));
//        System.out.println("两个浮点数的最大值是"+max(num3,num4));
//        System.out.println("一个整数与两个小数的大小关系是：");
//        comp(num2,num3,num4);
//    }
//    public static void main(String[] args) {
//            int[] a={1,1,2,2,3,3,4};
//            int res=0;
//            for(int i=0;i<a.length;i++){
//                res^=a[i];
//            }
//        System.out.println(res);
//    }
//    public static int fib(int num){
//        int[] a=new int[num];
//        int i;
//        if((num==1)||(num==2)){
//            return 1;
//        }else {
//            a[0] = 1;s
//            a[1] = 1;
//            for (i = 2; i < num; i++) {
//                a[i] = a[i - 1] + a[i - 2];
//            }
//            return a[i-1];
//        }
//    }
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        System.out.print("请输入你想知道的斐波那契数列的第几位：");
//        int num=scanner.nextInt();
//        int res=fib(num);
//        System.out.println(res);
//    }
//    public static int fact(int num){
//        int mul=1;
//        for(int i=1;i<=num;i++){
//            mul*=i;
//        }
//        return mul;
//    }
//    public static int plus(int num){
//        int sum=0;
//        for(int i=1;i<=num;i++){
//            sum+=fact(i);
//        }
//        return sum;
//    }
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        System.out.print("请输入一个数");
//        int num=scanner.nextInt();
//        System.out.println("这个数的阶乘是："+fact(num));
//        System.out.println("这个数的阶乘相加是"+plus(num));
//        int[] arr={1,2,3,4,5,6};
//        int left=0;
//        int right=arr.length-1;
//        while(left<right){
//            while((left<right)&&(arr[left]%2!=0)){
//                left++;
//            }
//            while((left<right)&&(arr[right]%2==0)){
//                right--;
//            }
//            int temp=arr[right];
//            arr[right]=arr[left];
//            arr[left]=temp;
//        }
//        for(int x:arr){
//            System.out.println(x);
//        }
//    public static int max2(int num1,int num2){
//        if(num1>num2){
//            return num1;
//        }else{
//            return num2;
//        }
//    }
//    public static int max3(int num1,int num2,int num3){
//      return max2(max2(num1,num2),num3);
//    }
//        int num1=5;
//        int num2=6;
//        int num3=7;
//        int res1=max2(num1,num2);
//        int res2=max3(num1,num2,num3);
//        System.out.println(res1+"  "+res2);
//        Scanner scanner=new Scanner(System.in);
//        System.out.print("请输入一个数：");
//        int num=scanner.nextInt();
//        System.out.print("偶数位:");
//        for(int i=0;i<32;i+=2){
//            int res=0;
//            res=((num>>31-i)&1);
//            System.out.print(res+" ");
//        }
//        System.out.println();
//        System.out.print("奇数位:");
//        for(int j=1;j<32;j+=2){
//            int res=0;
//            res=((num>>31-j)&1);
//            System.out.print(res+" ");
//        }
//    int[] arr={1,2,3,4,5,6};
//    int left=0;
//    int right=arr.length-1;
//    while(left<right){
//       while(left<right&&arr[left]%2!=0){
//           left++;
//       }
//       while(left<right&&arr[right]%2==0){
//           right--;
//       }
//       int temp=arr[right];
//       arr[right]=arr[left];
//       arr[left]=temp;
//    }
//    for(int x:arr){
//        System.out.println(x);
//    }
//        String key="123456";
//        Scanner scanner=new Scanner(System.in);
//        int count=0;
//        while(count<3) {
//            System.out.print("请输入密码：");
//            String yourKey=scanner.nextLine();
//            if (key.equals(yourKey)) {
//                System.out.println("登陆成功！");
//                break;
//            } else {
//                count++;
//                System.out.println("密码错误！你还有"+(3-count)+"次机会");
//            }
//        }
//        Scanner scanner=new Scanner(System.in);
//        System.out.println("请输入一个整数");
//        int num=scanner.nextInt();
//        print(num);
//        for(int i=1;i<10;i++){
//            for(int j=1;j<=i;j++){
//                System.out.print(i+" * "+j+" = "+(i*j)+"   ");
//            }
//            System.out.println();
//        }
//        Scanner scanner=new Scanner(System.in);
//        Random random=new Random();
//        int res=random.nextInt(100);
//        boolean r=true;
//        while(r) {
//            int count=0;
//            System.out.print("请输入你猜的数字：");
//            int yourNum=scanner.nextInt();
//            if(yourNum>res){
//                System.out.println("你猜大了，请重新猜");
//                count++;
//            }else if(yourNum<res){
//                System.out.println("你猜小了，请重新猜");
//                count++;
//            }else{
//                System.out.println("恭喜你！猜对了！！！");
//                if(count>8){
//                    System.out.println("技术不行嘛~");
//                }
//                r=false;
//            }
//        }
//        for(int i=1;i<999;i++){
//            flower(i);
//        }
//        double num1=0,num2=0;
//        for(double i=1;i<100;i+=2){
//            num1+=1/i;
//        }
//        for(double j=2;j<=100;j+=2){
//            num2+=1/j;
//        }
//        double num=num1-num2;
//        System.out.println(num);
//    Scanner scanner=new Scanner(System.in);
//       System.out.print("请输入2个数字：");
//       int num1=scanner.nextInt();
//       int num2=scanner.nextInt();
//        int num3=gcd(num1,num2);

//        int i;
//        boolean flag=true;
//        for(i=2;i<Math.sqrt(num);i++) {
//            if(num%i==0) {
//                flag=false;
//                System.out.println("不是素数");
//                break;
//            }
//            }
//        if(flag){
//            System.out.println("是素数");
//        }
//        for(int year=1000;year<=2000;year++){
//            if(year%4==0&&year%100!=0||year%400==0) {
//                System.out.println(year+"是闰年");
//            }
//        }
//        int count=0;
//        for(int num=1;num<=100;num++){
//            if(num%10==9||num/10==9){
//                count++;
//            }
//        }
//        System.out.println("出现了"+count+"次9");
//        int count=0;
//        for(int i=0;i<32;i++){
//         if((num&1)==1){
//             count++;
//         }
//         num=num>>1;
//        }
//        System.out.println("共有"+count+"个1");
//        public static int gcd(int big,int small) {
//        if(small==0){
//            return big;
//        }
//        r=big%small;
//        return gcd(small,r);
//        }
//        public static void flower(int i){
//            int num1=i%10;
//            int num2=(i/10)%10;
//            int num3=(i/100)%10;
//            if((Math.pow(num1,3)+Math.pow(num2,3)+Math.pow(num3,3))==i){
//                System.out.println(i);
//            }



