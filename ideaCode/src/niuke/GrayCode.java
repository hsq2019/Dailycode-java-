package niuke;

public class GrayCode {
        public static String[] getGray(int n) {
            int i=(int)Math.pow(2,n);
            String[] arr=new String[i];
            for(int x=0;x<arr.length;x++){
                StringBuffer sb=new StringBuffer();
                for(int j=0;j<n;j++){
                    sb.append((x>>j)%2);
                    sb.reverse();
                }
                arr[x]=sb.toString();
            }
            return arr;
        }

    public static void main(String[] args) {
        String[] arr=getGray(3);
       for(String s:arr){
           System.out.println(s);
       }
    }
}
