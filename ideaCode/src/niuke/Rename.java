package niuke;


import java.util.Scanner;

public class Rename {
    //驼峰命名
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            StringBuilder sb=new StringBuilder();
            String str=scanner.nextLine();
            String[] s=str.split("_");
            sb.append(s[0]);
            //首字母大写
            for(int i=1;i<s.length;i++){
                char[] c=s[i].toCharArray();
                sb.append((char)(c[0]-'a'+'A'));
                for(int j=1;j<c.length;j++){
                    sb.append(c[j]);
                }
            }
            System.out.println(sb.toString());
        }
    }
}
