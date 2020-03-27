package library.action;

import library.book.BookList;

public class ExitAction implements IAction {
    @Override
    public void work(BookList bookList) {
        System.out.println("goodbye!!!");
        System.exit(0);

    }
}
