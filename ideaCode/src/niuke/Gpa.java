package niuke;


import java.util.Scanner;

public class Gpa {
    //大学的学分绩点
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        int[] grade=new int[num];
        int[] g=new int[num];
        for(int i=0;i<num;i++){//实际绩点
            grade[i]=scanner.nextInt();
        }
        for(int i=0;i<num;i++){//考试成绩
            g[i]=scanner.nextInt();
        }
        System.out.printf("%.2f",help(grade,g));
    }
    public static double help(int[] grade,int[] g){
        double sum1=0.0;
        double sum2=0.0;
        for(int i=0;i<grade.length;i++){
            sum1+=gpa(g[i])* grade[i];
            sum2+=grade[i];
        }
        return sum1/sum2;
    }

    private static double gpa(int i) {
        double point;
        if(100>=i&&i>=90){
            point=4.0;
        }else if(i<90&&i>=85){
            point=3.7;
        }else if(i<85&&i>=82){
            point=3.3;
        }else if(i<82&&i>=78){
            point=3.0;
        }else if(i<78&&i>=75){
            point=2.7;
        }else if(i<75&&i>=72){
            point=2.3;
        }else if(i<72&&i>=68){
            point=2.0;
        }else if(i<68&&i>=64){
            point=1.5;
        }else if(i<64&&i>=60){
            point=1.0;
        }else {
            point=0.0;
        }
        return point;
    }

}
