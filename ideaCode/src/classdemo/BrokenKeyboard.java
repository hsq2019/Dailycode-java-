package classdemo;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//[牛客网]
//输入7_This_is_a_test<br/>_hs_s_a_es
//输出7TI
//要求：按照发现顺序，在一行中输出坏掉的键。其中英文字母只输出大写，每个坏键只输出一次。题目保证至少有1个坏键。
public class BrokenKeyboard {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            //原来的字符串输入
            String expected=scanner.next();
            //实际上字符串输入
            String actual=scanner.next();
            //转大写
            expected=expected.toUpperCase();
            actual=actual.toUpperCase();
            Set<Character> actualMap=new HashSet<>();
            for(int i=0;i<actual.length();i++){
                //如果给set加入之前加入过的字符，那么会插入失败
                actualMap.add(actual.charAt(i));
            }
            Set<Character> expectedSet=new HashSet<>();
            for(int i=0;i<expected.length();i++){
                if(actualMap.contains(expected.charAt(i))){
                    continue;
                }
                if(expectedSet.contains(expected.charAt(i))){
                    continue;
                }
                System.out.print(expected.charAt(i));
                expectedSet.add(expected.charAt(i));
            }

        }
    }
}
