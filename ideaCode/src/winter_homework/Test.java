package winter_homework;

import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;

import java.util.Scanner;

public class Test{

    public static void main(String[] args) {
        String str="hello word hello bit";
        String[] res=str.split(" ",2);
        for(String s:res){
            System.out.println(s);
        }

    }
}
