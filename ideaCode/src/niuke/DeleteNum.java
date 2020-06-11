package niuke;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//每隔两个数就删除一个数
//类似于约瑟夫问题
public class DeleteNum {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextInt()){
           int n=sc.nextInt();
            if(n>1000){
                n=999;
            }
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<n;i++){
                list.add(i);
            }
            int i=0;
            while (list.size()>1){
                i=(i+2)%list.size();
                list.remove(i);
            }
            System.out.println(list.get(0));
        }

    }
}
