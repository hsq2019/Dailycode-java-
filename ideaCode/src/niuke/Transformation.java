package niuke;


import java.util.Scanner;

public class Transformation {
    //业务转化
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[][] array=new int[n][n];
        //输入放到二维数组里面
        for(int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                array[i][j]=scanner.nextInt();
            }
        }
        //
        int[] comp=new int[n];
        StringBuilder stringBuilder=new StringBuilder();
        for (int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!compare(array[i][j],comp)){
                    stringBuilder.append(array[i][j]+" ");
                    comp[i]=array[i][j];
                    break;
                }
            }
        }
        System.out.println(stringBuilder.toString());
    }

    private static boolean compare(int i, int[] comp) {
        for(int j=0;j<comp.length;j++){
            if(comp[j]==i){
                return true;
            }
        }
        return false;
    }
}
