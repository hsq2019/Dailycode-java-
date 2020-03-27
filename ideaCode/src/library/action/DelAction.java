package library.action;

import library.book.Book;
import library.book.BookList;

import java.util.Scanner;

//删除
public class DelAction implements IAction {
    public void work(BookList bookList){
        System.out.println("删除书籍");
        System.out.println("请输入要删除书籍的名称");
        Scanner scanner=new Scanner(System.in);
        String name=scanner.next();
        int i=0;
        for(;i<bookList.getSize();i++){
            Book book=bookList.getBook(i);
            if(book.getName().equals(name)){
                break;
            }
        }
        if(i>=bookList.getSize()){
            System.out.println("没有匹配的书籍，不能删除！");
            return;
        }
        int size=bookList.getSize();
        bookList.setBook(i,bookList.getBook(size-1));
        bookList.setSize(size-1);
        System.out.println("删除完成");

    }
}
