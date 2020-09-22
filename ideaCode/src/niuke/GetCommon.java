package niuke;

public class GetCommon {
    public static void main(String[] args) {
        String s1="abccade";
        String s2="dgcadde";
        System.out.println(getCommon(s1,s2));
    }
    private static String getCommon(String s1,String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        //把s2一个一个单词和s1比较，
        //比较次数就素s2的长度
        int max = 0;
        int resIndex = 0;
        for (int i = 0; i < c2.length; i++) {
            //s2的每个单词都要比较s1次
            int num = 0;
            int index = i;
            int j = 0;

            while (j < c1.length&&c1[index] == c2[j]) {
                    j++;
                    index++;
            }
            if (j > max) {
                max = j;
                resIndex = index;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 3; i> 0; i--) {
            sb.append(c1[resIndex-i]);
        }
        return sb.toString();
    }
}
