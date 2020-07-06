package library.user;

import library.action.*;
import library.book.BookList;

import java.util.Scanner;

//普通用户

public class NormalUser extends User {
    public NormalUser(String name){
        this.name=name;
        this.actions=new IAction[]{
                new ExitAction(),
                new FindAction(),
                new BorrowAction(),
                new ReturnAction()

        };
    }
    public int menu(){
        System.out.println("=======================");
        System.out.println("欢迎"+this.name+"使用图书馆管理系统");
        System.out.println("1.查找图书");
        System.out.println("2.借出图书");
        System.out.println("3.归还图书");
        System.out.println("0.退出系统");
        System.out.println("=======================");
        System.out.print("请输入你的选择：");
        int choice=0;
        Scanner scanner=new Scanner(System.in);
        choice=scanner.nextInt();
        return choice;
    }
//    public void doAction(int choice, BookList bookList){
//        actions[choice].work(bookList);
//    }
}
