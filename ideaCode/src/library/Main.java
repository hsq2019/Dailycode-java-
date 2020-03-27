package library;

import library.book.BookList;
import library.user.Admin;
import library.user.NormalUser;
import library.user.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookList bookList=new BookList();
        User user=login();
        while (true){
           int choice= user.menu();
           user.doAction(choice,bookList);
        }
    }

    public static User login(){
        System.out.println(" 请输入姓名 ");
        Scanner scanner=new Scanner(System.in);
        String name=scanner.next();
        System.out.println("请输入身份 1：表示管理 ；2：表示普通用户");
        int who=scanner.nextInt();
        if(who==1){
            return new Admin(name);
        }
        return new NormalUser(name);
    }
}
