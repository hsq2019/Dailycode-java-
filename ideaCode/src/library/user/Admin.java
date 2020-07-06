package library.user;

import library.action.*;

import java.util.Scanner;

//管理员
public class Admin extends User {
    public Admin(String name){
        this.name=name;
        this.actions=new IAction[] {
                new ExitAction(),
                new FindAction(),
                new AddAction(),
                new DelAction(),
                new DisplayAction()
        };
    }
    public int menu(){
        System.out.println("=======================");
        System.out.println("欢迎"+this.name+"使用图书馆管理系统,您是管理员");
        System.out.println("1.查找图书");
        System.out.println("2.新增图书");
        System.out.println("3.删除图书");
        System.out.println("4.显示图书");
        System.out.println("0.退出系统 ");
        System.out.println("=======================");
        System.out.print("请输入你的选择：");
        int choice=0;
        Scanner scanner=new Scanner(System.in);
        choice=scanner.nextInt();
        return choice;

    }
}
