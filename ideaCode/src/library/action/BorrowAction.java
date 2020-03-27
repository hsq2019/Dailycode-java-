package library.action;

import library.book.Book;
import library.book.BookList;

import java.util.Scanner;

//借书
public class BorrowAction implements IAction {
    @Override
    public void work(BookList bookList) {
        System.out.println("执行借书操作");
        System.out.println("请输入你要借阅的书籍名称：");
        Scanner scanner=new Scanner(System.in);
        String name=scanner.next();
        for(int i=0;i<bookList.getSize();i++){
            Book book=bookList.getBook(i);
            if(book.getName().equals(name)){
                if(book.isBorrowed()){
                    continue;
                }else {
                    book.setBorrowed(true);
                    System.out.println("借书成功！");
                    return;
                }
            }
        }
        System.out.println("借书失败！没有相应匹配书籍");
    }
}
