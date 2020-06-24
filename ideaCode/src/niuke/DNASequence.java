package niuke;

import java.util.Scanner;

//基因序列
public class DNASequence {
    //求比例
    public static double help(String str){
        double x=0;
        double count=0;
        for(char c:str.toCharArray()){
            if(c=='C'||c=='G'){
                count++;
            }
        }
        x=count/(double)str.length();
        return x;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        int childLength=scanner.nextInt();
        String maxStr="";
        double maxRatio=0;
        for(int i=0;i<s.length()-childLength+1;i++){
            String str=s.substring(i,i+childLength);
            if(help(str)>maxRatio){
                maxStr=str;
                maxRatio=help(str);
            }
        }
        System.out.println(maxStr);
    }
}
