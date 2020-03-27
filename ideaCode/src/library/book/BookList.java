package library.book;
//表示多本书
public class BookList {
    //类似个顺序表
    private Book[] books=new Book[100];
    //数组中有限元素的个数
    private int size=0;
    public BookList(){
        books[0]=new Book("三国演义","罗贯中",100,
                "古典名著",false);
        books[1]=new Book("西游记","吴承恩",101,
                "古典名著",false);
        books[2]=new Book("红楼梦","曹雪芹",120,
                "古典名著",false);
        size=3;

    }

    public Book getBook(int pos) {
        return books[pos];
    }

    public void setBook(int pos,Book book) {
        books[pos]=book;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
