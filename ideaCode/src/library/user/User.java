package library.user;

import library.action.IAction;
import library.book.Book;
import library.book.BookList;

abstract public class User {
    //抽象类不能实例化
    protected String name;
    protected IAction[] actions;//当前用户可以执行哪些操作
    abstract public int menu();//生成菜单
    //管理员和普通用户不一样

    public void doAction(int choice, BookList bookList){
        //通过菜单输入选项
        actions[choice].work(bookList);
    }

}
