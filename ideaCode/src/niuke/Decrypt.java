package niuke;

import java.util.Scanner;
import java.util.Stack;

public class Decrypt {
    //解码操作,笔试
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        String s = scanner.next();
        char[] c = s.toCharArray();
        int i = 0;
        for (; i < c.length; i++) {
            if (c[i] == 'M') {
                break;
            }
        }
        int j ;
        for (j=i+1 ; j < c.length; j++) {
            if (c[j] == 'T') {
                break;
            }
        }
        //开始中间的被加密的字符串
        //全部压入栈
        Stack<Character> stack = new Stack<>();
        for (int x = j + 1; x < c.length; x++) {
            stack.push(c[x]);
        }
        //开始出栈
        Boolean flag = false;
        while (!stack.isEmpty()) {
            if (!flag && stack.peek() == 'T') {
                stack.pop();
                while (!stack.isEmpty()) {
                    if (stack.peek() == 'M') {
                        stack.pop();
                        flag = true;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            } else {
                if (flag) {
                    break;
                }
                stack.pop();
            }

        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        stringBuilder.reverse();
        System.out.println(stringBuilder.toString());
    }
}
